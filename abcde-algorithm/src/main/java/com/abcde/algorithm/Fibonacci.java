package com.abcde.algorithm;

public class Fibonacci {


    // ---------------------------------- 1 start--------------------------
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

    // ---------------------------------- 1 end--------------------------

    // ---------------------------------- 2 start--------------------------
    public static int fibDp(int N) {
        int[] dp = new int[N+1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i < N+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[N];
    }

    // ---------------------------------- 2 end--------------------------



    public static void main(String[] args) {
        int fib = fib(20);
        System.out.println(fib);
        System.out.println(fibDp(20));
    }

}
