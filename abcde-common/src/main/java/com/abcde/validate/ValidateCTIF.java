package com.abcde.validate;



public class ValidateCTIF {


    public RetData validateCTIF_TEST(String fieldName,String fieldValue) {
        System.out.println(fieldName);
        System.out.println(fieldValue);
        RetData retData = new RetData();
        retData.setStatus("failed");
        retData.setErrMsg("错误信息 ");
        return retData;
    }
}
