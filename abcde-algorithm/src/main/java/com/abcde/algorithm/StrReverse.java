package com.abcde.algorithm;



public class StrReverse {


    public static void main(String[] args) {
        String test = "asdf";
        System.out.println(getReverse2(test));

    }

    /**
     * 获得字符串的反序字符串
     * @param test
     * @return
     */
    public static String getReverse(String test){
        int len = test.length();
        char[] testArr = test.toCharArray();
        for (int i = 0 ; i < len/2 ; i++){
            char tmp = testArr[i];
            testArr[i] = testArr[len - i - 1];
            testArr[len - i - 1] = tmp;
        }
        return String.valueOf(testArr);
    }

    /**
     * 获得字符串的反序字符串
     * @param test
     * @return
     */
    public static String getReverse2(String test){
        if (null != test)
            return new StringBuilder(test).reverse().toString();
        return null;
    }

    //js : str.split("").reverse().join("");
}
