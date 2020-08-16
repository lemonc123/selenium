package com.cui.day1;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo1 {

    @BeforeTest
    public void beforeTest01(){
        System.out.println("这是beforetest注解");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }
    @Test
    public  void testCase1(){
        System.out.println("这是test1注解");
    }

    @Test
    public  void testCase2(){
        System.out.println("这是test2注解");
    }


}



