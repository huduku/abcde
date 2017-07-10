package com.abcde.collections.generic;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenericTest {


    public static void main(String[] args) {
        List<Student> strList = new ArrayList<>();

        strList.add(new MenStudent());

        Set set = new HashSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        for (Object i : set) {
            System.out.println(i);
        }

    }


    public static class Person {

    }

    public static class Student extends Person{

    }

    public static class MenStudent extends Student {

    }
}
