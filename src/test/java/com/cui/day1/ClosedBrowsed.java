package com.cui.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ClosedBrowsed {
    WebDriver webDriver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver_win32-84\\chromedriver.exe");
        webDriver = new ChromeDriver();
        System.out.println("打开浏览器");
    }


    @Test
    public void closdeChrome(){
//        设置chromedriver路径
//        System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver_win32-84\\chromedriver.exe");
//        实例化chromeDriver
//        webDriver = new ChromeDriver();
        //打开浏览器get方法
        webDriver.get("http://www.baidu.com");
//        线程等待5s
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        刷新
        webDriver.navigate().refresh();

        webDriver.manage().window().maximize();
//        webDriver.close();
//       完全退出浏览器
//        webDriver.quit();
//        浏览器后退
        webDriver.navigate().back();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.navigate().forward();
          webDriver.get("http://www.baidu.com");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.quit();
    }

    @Test
    public void winTest() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver_win32-84\\chromedriver.exe");
//        webDriver = new ChromeDriver();
//     实例化Dimension 设置窗口大小
        Dimension dimension =  new Dimension(500,500);
        webDriver.manage().window().setSize(dimension);
        Thread.sleep(3000);
//      窗口最大化
        webDriver.manage().window().maximize();
        Thread.sleep(3000);
        webDriver.quit();
    }
    @Test
    public void getTest() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver_win32-84\\chromedriver.exe");
//        webDriver = new ChromeDriver();
        webDriver.get("https://www.baidu.com");
        Thread.sleep(3000);
        String url = webDriver.getCurrentUrl();
        System.out.println("获取到的url" + url);
        Assert.assertEquals(url, "https://www.baidu.com/");
//        webDriver.quit();
    }
    @AfterMethod
    public void closedBrowsed(){
        webDriver.quit();
        System.out.println("关闭浏览器");
    }


    /**
     * 打开百度页面
     * 通过id定位搜索文本框
     */

    @Test
    public void byIDTest(){
        webDriver.get("https://www.baidu.com");
        WebElement keyField = webDriver.findElement(By.id("kwaaaaa"));
    }

    /**
     * 打开百度页面
     * 通过name定位搜索文本框
     */

    @Test
    public void byIDName(){
        webDriver.get("https://www.baidu.com");
//        WebElement keyField = webDriver.findElement(By.name("wd"));

//        WebElement list = webDriver.findElement(By.xpath("//*[@id=\"s-top-left\"]/a"));


        List<WebElement> list = webDriver.findElements(By.xpath("//*[@id=\"s-top-left\"]/a"));
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get);
//        }
/*
        }
        List<WebElement> list = webDriver.findElements(By.id("s-top-left"));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list);
        }
*/

        }








































































}

