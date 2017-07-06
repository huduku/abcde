package com.abcde.reflect;


import java.lang.reflect.Field;

public class TestReflect {


    public static void main(String[] args) {

        try {
            Class clazz = Class.forName("com.abcde.reflect.Person");
            Person person = (Person) clazz.newInstance();

            System.out.println(person);

            Field testField = clazz.getField("test");

            System.out.println(testField.get(testField));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
