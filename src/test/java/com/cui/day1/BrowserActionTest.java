package com.cui.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserActionTest {

    /*
        打开chrome浏览器
        打开百度首页
        等待5s
        关闭浏览器

     */
    //启动chrome览器
    @Test
    public void getTet(){
        System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver_win32-84\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://www.baidu.com");
        webDriver.close();
//        webDriver.quit();
    }

}
