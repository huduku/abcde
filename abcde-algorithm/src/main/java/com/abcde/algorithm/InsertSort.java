package com.abcde.algorithm;



public class InsertSort {


    public static void main(String[] args) {
        int[] arr = {3,2,5,8,4,2,1};
        traversal(arr);
        long t = System.currentTimeMillis();
        insertSort(arr);
        System.out.println();;
        System.out.println(System.currentTimeMillis() - t);
        traversal(arr);
    }

    public static void insertSort(int[] arr) {
        int tmp;
        for (int i = 1 ; i < arr.length ; ++i) {
            //j -> i已排序部分
            //i -> arr.length 未排序部分
            tmp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > tmp) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = tmp;
        }
    }


    public static void binInsertSort(int[] arr , int lo , int hi) {
        if (lo < 0 || hi > arr.length || lo > hi){
            throw new IllegalArgumentException("边界有问题");
        }

        int mid = (lo + 1 + hi)/2;
        if (arr[mid] < arr[lo]) {

        }
    }

    public static void traversal(int[] arr) {
        System.out.println();
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
