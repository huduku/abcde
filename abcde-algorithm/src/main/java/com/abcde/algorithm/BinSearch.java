package com.abcde.algorithm;


/**
 * 二分查找
 */
public class BinSearch {


    public static void main(String[] args) {
        int[] arr = new int[6];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 2;
        arr[4] = 3;
        arr[5] = 4;
        int result = binSearchLastPos(arr,2);
        //1,2,3,4,5,6  result == 3
        System.out.println(result);
    }


    /**
     * 二分查找- 非递归算法 数据不重复
     * @param arr 待查找的数组，从小到大排序
     * @param a 带查找的关键字
     * @return 待查找的关键字a在arr中的位置下标
     */
    public static int binSearch(int[] arr , int a) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid;

        while (lo <= hi) {
            mid = (lo + hi)/2; // 无论arr中元素有奇数个，还是偶数个，都是向下取整就行
            if (arr[mid] == a) {  // 查找过程中必不可少的比较操作
                return mid ;
            } else if (arr[mid] < a) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }


    /**
     * 二分查找算法 - 递归实现 数据不重复
     * @param arr  待查找的数组，从小到大排序
     * @param a 待查找的关键字
     * @param lo 待查找数组的起始位置 low
     * @param hi 待查找数组的终止位置 high
     * @return 待查找的关键字a在arr中的位置下标
     */
    public static int binSearch (int[] arr , int a , int lo , int hi) {
        if (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (a == arr[mid]) {
                return mid;
            } else if (a < arr[mid]) {
                return binSearch(arr, a , lo, mid - 1);
            }else {
                return binSearch(arr, a , mid + 1,hi);
            }
        }
        return -1;
    }


    /**
     * 二分查找 查找第一个元素出现的位置（元素允许重复）
     * @param arr 待查找的数组，从小到大排序
     * @param a 待查找的关键字
     * @return 查找第一个元素出现的位置
     */
    public static int binSearchFirstPos(int[] arr , int a){
        int lo = 0;
        int hi = arr.length - 1;
        int mid = 0;
        while (lo < hi) {
            mid = (lo + hi)/2;
            if (arr[mid] < a) {
                lo = mid + 1;
            }else {
                hi = mid;
            }
        }

        if (arr[lo] != a) {
            return -1;
        }else {
            return lo;
        }
    }


    /**
     * 二分查找 查询元素最后一次出现的位置（元素允许重复）
     * @param arr 待查找的数组，从小到大排序
     * @param a 待查找的关键字
     * @return 查询元素最后一次出现的位置
     */
    public static int binSearchLastPos(int[] arr , int a) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid = 0;

        while (lo < hi) {
            mid = (lo + hi)/2;
            if (arr[mid] <= a) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }

        if (arr[lo] != a) {
            return -1;
        }else {
            return hi;
        }

    }

}
