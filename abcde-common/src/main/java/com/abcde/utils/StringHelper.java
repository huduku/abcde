package com.abcde.utils;



public class StringHelper {


    public static boolean isEmpty(String str){
        if (null == str || str.trim().equals("")) {
            return true;
        }
        return false;
    }


    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
