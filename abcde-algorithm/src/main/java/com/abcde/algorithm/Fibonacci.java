package com.abcde.algorithm;

public class Fibonacci {


    public static int fib(int N) {
        if (N < 1)
            return 0;
        int[] memo = new int[N+1];
        return helper(memo, N);
    }

    private static int helper(int[] memo, int n) {
        if (n == 1 || n==2)
            return 1;
        if (memo[n] != 0)
            return memo[n];
        memo[n] = helper(memo, n - 1) +  helper(memo, n - 2);
        return memo[n];
    }

    public static void main(String[] args) {
        int fib = fib(20);
        System.out.println(fib);
    }

}
