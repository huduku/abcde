package com.abcde.algorithm;


/**
 * 打印字符串全排列
 */
public class StrFullPermutation {

    public static void main(String[] args) {

        fullPermutation("abcd");
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

    /**
     *
     * @param cArr 待打印全排列的字符串的字符数组
     * @param i
     */
    public static void permutation(char[] cArr, int i) {
        if (i >= cArr.length) // 递归出口
            return;
        if (i == cArr.length - 1) { //当递归到数组中的最后一个元素时，打印数组
            System.out.println(String.valueOf(cArr));
        } else {
            for (int j = i; j < cArr.length; j++) {
                //交换前缀
                char temp = cArr[j];
                cArr[j] = cArr[i];
                cArr[i] = temp;

                permutation(cArr, i + 1);

                //将前缀交换回来
                temp = cArr[j];
                cArr[j] = cArr[i];
                cArr[i] = temp;
            }
        }
    }
}
