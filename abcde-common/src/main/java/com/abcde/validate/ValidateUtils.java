package com.abcde.validate;


import com.abcde.utils.StringHelper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.io.*;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

public class ValidateUtils {


    /**
     * 根据json文件获取校验Map
     * @param filename classpath下的json校验文件
     * @return
     */
    public static HashMap<String , ValidateModel> getValidateMap(String filename){
        StringBuilder json = new StringBuilder();
        BufferedReader br = null;
        try {
            //"validateCTIF-TEST.json"
            URL url = ValidateUtils.class.getClassLoader().getResource(filename);
            br = new BufferedReader(new FileReader(url.getFile()));
            String line = null;
            while ((line = br.readLine()) != null) {
                json.append(line);
            }

            Object object = JSON.parse(json.toString());
            HashMap<String , ValidateModel> validateMap = JSON.parseObject(json.toString(), new TypeReference<HashMap<String , ValidateModel>>(){});
            return validateMap;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }


    /**
     * 根据校验元数据，校验字段名为fieldName，字段值为fieldValue的有效性
     * @param validateMap   检验元数据
     * @param fieldName     字段名
     * @param fieldValue    字段值
     * @return RetData 如果通过校验，retData 的status为success，否则为failed，并带出错误信息
     */
    public static RetData validateField(HashMap<String , ValidateModel> validateMap , String fieldName,String fieldValue){
        RetData retData = new RetData();
        retData.setStatus("success");
        retData.setErrMsg("通过校验");


        ValidateModel validateModel = validateMap.get(fieldName);

        if (StringHelper.isEmpty(validateModel.getFieldName())) {
            retData.setStatus("failed");
            retData.setErrMsg("配置文件中字段 "+ fieldName +" 缺少校验项：fieldName" );
            return retData;
        }

        if (null == validateModel.getRequired()) {
            retData.setStatus("failed");
            retData.setErrMsg("配置文件中字段 "+ fieldName +" 缺少校验项：required" );
            return retData;
        }

        if (validateModel.getRequired()) {
            if (StringHelper.isEmpty(fieldValue)){
                retData.setStatus("failed");
                retData.setErrMsg("字段：" +fieldName+ " 为必填项");
                return retData;
            }
        }

        /**
         * 如果字段不是必填项，但是字段为空，则字段不必走下面的逻辑
         */
        if (StringHelper.isNotEmpty(fieldValue) ) {
            Integer[] length = validateModel.getLength();
            if (null != length) {
                if (null != length[0] && length[0] > fieldValue.length() ) {
                    retData.setStatus("failed");
                    retData.setErrMsg("字段：" +fieldName+ "  长度应大于 [ " + length[0] + " ]");
                    return retData;
                }
                if (null != length[1] && length[1] < fieldValue.length()) {
                    retData.setStatus("failed");
                    retData.setErrMsg("字段：" +fieldName+ "  长度应小于 [ " + length[1] + " ]");
                    return retData;
                }
            }

            BigDecimal[] range = validateModel.getRange();
            if (null != range) {
                if (null != range[0] && range[0].compareTo(new BigDecimal(fieldValue)) >= 0 ) {
                    retData.setStatus("failed");
                    retData.setErrMsg("字段：" +fieldName+ "  范围应大于 [ " + range[0] + " ]");
                    return retData;
                }
                if (null != range[1] && range[1].compareTo(new BigDecimal(fieldValue)) <= 0) {
                    retData.setStatus("failed");
                    retData.setErrMsg("字段：" +fieldName+ "  范围应小于 [ " + range[1] + " ]");
                    return retData;
                }
            }


            String[] dateRange = validateModel.getDateRange();
            if (null != dateRange) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateStr = sdf.format(fieldValue);
                if (null != dateRange[0] && dateRange[0].compareTo(dateStr) >=0){
                    retData.setStatus("failed");
                    retData.setErrMsg("字段：" +fieldName+ "  日期应大于 [ " + dateRange[0] + " ]");
                    return retData;
                }
                if (null != dateRange[1] && dateRange[1].compareTo(dateStr) <=0){
                    retData.setStatus("failed");
                    retData.setErrMsg("字段：" +fieldName+ "  日期应小于 [ " + dateRange[1] + " ]");
                    return retData;
                }
            }

            String regex = validateModel.getRegex();
            if (regex!=null && !fieldValue.matches(regex)) {
                retData.setStatus("failed");
                retData.setErrMsg("字段：" + fieldName + "  格式有误");
                return retData;
            }

            List<String> optItems = validateModel.getOptItems();
            if (null != optItems && optItems.size() > 0) {
                if (!optItems.contains(fieldValue)){
                    retData.setStatus("failed");
                    retData.setErrMsg("字段：" +fieldName+ "  的值" +fieldValue+ "不在可取值选项列表内，请检查");
                    return retData;
                }
            }

            //字典表项校验省略

            //自定义校验省略
            String validateMethod = validateModel.getValidateMethod();
            if (null != validateMethod) {
                try{
                    String[] methodItems = validateMethod.split("\\|");
                    if (methodItems.length > 0) {
                        String className = methodItems[0].substring(0,methodItems[0].lastIndexOf("."));
                        String method = methodItems[0].substring(methodItems[0].lastIndexOf(".") + 1);


                        Class clazz = Class.forName(className);
                        //
                        Object obj = clazz.newInstance();

                        //获取方法
                        Method m = null;
                        if (methodItems.length > 1){
                            Class[] clses = new Class[methodItems.length - 1];
                            for (int i = 1; i < methodItems.length ; i++) {
                                clses[i-1] = Class.forName(methodItems[i]);
                            }
                            m = obj.getClass().getDeclaredMethod(method,clses );
                        }else {
                            m = obj.getClass().getDeclaredMethod(method);
                        }

                        //调用方法
                        RetData result =  (RetData) m.invoke(obj, "aaaaa");
                        retData = result;
//                        System.out.println(result);
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return retData;
    }


}
