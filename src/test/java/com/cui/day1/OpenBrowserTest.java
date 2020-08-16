package com.cui.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpenBrowserTest {

    @Test
    public void openFF(){
        WebDriver webDriver = new FirefoxDriver();
    }

    //启动狐火浏览器
    @Test
    public void openFF2(){
       System.setProperty("webdriver.firefox.bin","D:\\tools\\firefox\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();
    }

    //启动chrome览器
    @Test
    public void openChorme(){
        System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver_win32-84\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://www.baidu.com");
        webDriver.close();
        webDriver.quit();
    }



}



