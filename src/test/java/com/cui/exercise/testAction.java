package com.cui.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testAction {
    WebDriver webDriver;
    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver_win32-84\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }
    @Test
    public void test1(){
        webDriver.get("https://www.baidu.com");
        WebElement su = webDriver.findElement(By.id("su"));
//        Action action = new Action(webDriver);
        //在百度一下按钮上右键
//        action.contextClick().perform();
        //双击
//        action.doubleClick().perform();
//鼠标移动到更多产品上
//        action.moveToElement(su).perform();
    }






    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }



}
