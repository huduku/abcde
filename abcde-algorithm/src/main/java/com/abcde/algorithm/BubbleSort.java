package com.abcde.algorithm;


/**
 * 冒泡排序 - 将已排序的部分定义在右端，在遍历未排序部分的过程中执行比较和交换，如果左侧数据大于右侧，则交换,最终，最大的元素会被交换到未排序部分的最右端。
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3,2,5,8,4,2,1};
        traversal(arr);
        long t = System.currentTimeMillis();
        bubbleSort(arr);
        System.out.println();;
        System.out.println(System.currentTimeMillis() - t);
        traversal(arr);
    }

    /**
     * 从小到大排序
     * @param arr
     */
    public static void sort(int[] arr){
        for (int i = arr.length - 1 ; i > 0 ; i--) {
            for (int j = 0 ; j < i ; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }


    public static void bubbleSort (int[] arr) {
        for (int i = arr.length - 1 ; i > 0; i--) {
            for (int j = 0 ; j < i ; j++) {
                int p = j;
                int q = j + 1;
                if (arr[p] > arr[q]) {
                    swap(arr,p,q);
                }
            }
        }
    }

    public static void swap(int[] arr, int p , int q) {
        int tmp = arr[p];
        arr[p] = arr[q];
        arr[q] = tmp;
    }

    public static void traversal(int[] arr) {
        System.out.println();
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
