package com.abcde.reflect;


public class TestStr {


    public static void main(String[] args) {
        String hello = "hello";
        String test = "he" + new String ("llo");
        System.out.println(test == hello);
    }
}
