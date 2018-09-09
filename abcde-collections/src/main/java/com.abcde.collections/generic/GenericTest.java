package com.abcde.collections.generic;


import java.util.*;

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

        NavigableSet original = new TreeSet();
        original.add("1");
        original.add("21");
        original.add("3");

//this headset will contain "1" and "2"
        SortedSet headset = original.headSet("3");

        for (Object i : headset) {
            System.out.println(i);
        }

        headset = original.headSet("3", true);

        for (Object i : headset) {
            System.out.println(i);
        }

        Object obj = original.ceiling("12");
        System.out.println(obj);
        obj = original.floor("12");
        System.out.println(obj);
        obj = original.higher("3");
        System.out.println(obj);
        obj = original.lower("1");
        System.out.println(obj);
        obj = original.pollFirst();
        System.out.println(obj);
        obj = original.pollLast();
        System.out.println(obj);
        obj = original.headSet("3");
        System.out.println(obj);

        Map<Object , Object> map = new HashMap<>();
        map.put(null,1);
        map.put(null,2);
        System.out.println(map.get(null));
        System.out.println(map.keySet());
        System.out.println(map.values());


        Stack stack = new Stack();

        stack.push("1");
        stack.push("2");
        stack.push("2");

        int index = stack.search("2");
        System.out.println(index);

        stack.remove("2");
        System.out.println(stack);
    }


    public static class Person {

    }

    public static class Student extends Person{

    }

    public static class MenStudent extends Student {

    }
}
