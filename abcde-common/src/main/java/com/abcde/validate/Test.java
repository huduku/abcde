package com.abcde.validate;


import java.util.HashMap;

public class Test {

//    public static void main(String[] args) throws Exception {
//
//        String validateMethod = "com.abcde.validate.ValidateCTIF.validateCTIF_TEST|java.lang.String|java.lang.String";
//        String[] methodItems = validateMethod.split("\\|");
//        String className = methodItems[0].substring(0,methodItems[0].lastIndexOf("."));
//        String method = methodItems[0].substring(methodItems[0].lastIndexOf(".") + 1);
//
//
//        Class clazz = Class.forName(className);
//        //
//        Object obj = clazz.newInstance();
//
//        //获取方法
//        Method m = null;
//        if (methodItems.length > 1){
//            Class[] clses = new Class[methodItems.length - 1];
//            for (int i = 1; i < methodItems.length ; i++) {
//                clses[i-1] = Class.forName(methodItems[i]);
//            }
//            m = obj.getClass().getDeclaredMethod(method,clses );
//        }else {
//            m = obj.getClass().getDeclaredMethod(method);
//        }
//
//        //调用方法
//        RetData result =  (RetData) m.invoke(obj, "TEST","TESTASDF");
//
//        System.out.println(result);
//
//    }
//
//    public String sayHello(String str){
//        System.out.println("say " + str);
//        return str;
//    }

    @org.junit.Test
    public void test(){
        FieldModel fieldModel = new FieldModel();

        fieldModel.setCCTL("asdf");
        fieldModel.setCEML("asdf");
        fieldModel.setCITP("asdfasdf");
        fieldModel.setCRIT("asdf");
        fieldModel.setCTID("asdf");



        HashMap<String,ValidateModel> map = ValidateUtils.getValidateMap("conf/validateCTIF-TEST.json");
        RetData retData = ValidateUtils.validateField(map,"CEML","asdf");
        System.out.println(retData);


    }
}
