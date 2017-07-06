package com.abcde.algorithm;



public class StrFullPermutation {

    public static void main(String[] args) {
        fullPermutation("test");
    }


    /**
     * 递归打印字符串的全排列
     * @param test
     */
    public static void fullPermutation(String test){
        if (null != test) {
            permutation(test.toCharArray(),0);
        }
    }

    public static void permutation(char[] str, int i) {
        if (i >= str.length)
            return;
        if (i == str.length - 1) {
            System.out.println(String.valueOf(str));
        } else {
            for (int j = i; j < str.length; j++) {
                char temp = str[j];
                str[j] = str[i];
                str[i] = temp;

                permutation(str, i + 1);

                temp = str[j];
                str[j] = str[i];
                str[i] = temp;
            }
        }
    }
}
