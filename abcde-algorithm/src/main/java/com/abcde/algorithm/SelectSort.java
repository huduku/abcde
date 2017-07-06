package com.abcde.algorithm;



/**
 * 选择排序 - 将已排序的部分定义在左端，然后选择未排序的部分最小的元素，将其直接交换到未排序部分的左端。
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {3,2,5,8,4,2,1};
        traversal(arr);
        sort(arr);
        System.out.println();
        traversal(arr);
    }

    public static void sort(int[] arr) {
        for (int i = 0 ; i < arr.length ; i++) {
            int minIndex = selectMinPos(arr,i);
            swap(arr , i , minIndex);
        }
    }

    public static int selectMinPos(int[] arr , int startPos) {
        int min = arr[startPos];
        int minIndex = startPos;
        // i -> j 已排序部分 ； j ->  arr.length 未排序的部分
        for (int j = startPos + 1 ; j < arr.length ; j++) {
            if (min > arr[j]) {
                minIndex = j;
                min = arr[j];
            }
        }
        return minIndex;
    }

    public static void swap(int[] arr , int p, int q) {
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
