package com.cui.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo02 {

    //校验a == a
    @Test
    public void assertEqualTest(){
        String a = "dhfdkajfd";
        String b = "dhfdkajfsssd";

//        Assert.assertEquals(a,b,"a等于b");
        Assert.assertEquals(a,b);
    }

}
