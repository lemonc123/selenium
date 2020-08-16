package com.cui.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class test1 {
    WebDriver webDriver;
    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver_win32-84\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    /**
     *   1. 打开百度首页
     * 	 2. 点击百度首页的“新闻”链接。
     */
    @Test
    public void clickTest() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        WebElement el = webDriver.findElement(By.xpath("//*[@id=\"s-top-left\"]/a[1]"));
        Thread.sleep(3000);
        el.click();
        Thread.sleep(3000);
    }

    /**
     * 1. 打开百度页面
     * 2. 在搜索文本框输入selenium
     * 3. 点击百度一下按钮
     */
    @Test
    public void clickTest2() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        WebElement el = webDriver.findElement(By.id("kw"));
        el.sendKeys("selenium");
        Thread.sleep(3000);
         webDriver.findElement(By.id("su")).click();
        Thread.sleep(3000);
        el.clear();
        Thread.sleep(3000);
    }

    /**
     * 1. 打开百度首页
     * 	2. 获取左上角所有的文本并输出
     */
    @Test
    public void clickTest3() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        //获取title
        String title = webDriver.getTitle();
        Assert.assertEquals(title,"百度一下，你就知道");
        //校验百度一下按钮已经展示
        boolean bool = webDriver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(bool,"百度一下按钮已经展示");
        List<WebElement> lists =  webDriver.findElements(By.xpath("//*[@id=\"s-top-left\"]/a"));
        for (int i = 0; i < lists.size(); i++) {
            String str = lists.get(i).getText();
            System.out.println(str);
        }

    }


    @Test
    public void clickTestn() throws InterruptedException {
        webDriver.get("https://www.baidu.com");

    }


















    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }

}
