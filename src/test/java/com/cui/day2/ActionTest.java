package com.cui.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class ActionTest {
    /**
     * 点击百度首页的新闻按钮
     *那我我打开了相对的连接
     *
     */

    WebDriver webDriver;
//打开浏览器

    @BeforeMethod
    public void openBrowser() {

        System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver_win32-84\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }
    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }

    @Test
    public void clickTest() throws InterruptedException {
        webDriver.get("https://cn.bing.com/");
        WebElement newsLink = webDriver.findElement(By.id("scpl0"));
        newsLink.click();
        Thread.sleep(5000);
         String url = webDriver.getCurrentUrl();
        System.out.println(url);
//        Assert.assertEquals(url,"https://cn.bing.com/");
    }

/**
 * 打开百度页面，
 * 输入selennium，
 * 点击百度按钮搜索
 * 校验：title是否等于selenium_百度搜索
 */

    @Test
    public void sendKeysTest() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        WebElement input = webDriver.findElement(By.id("kw"));
//        sendKeys只对文本框，input进行操作
        input.sendKeys("selenium");
        Thread.sleep(3000);

        input.clear();
        Thread.sleep(3000);
        input.sendKeys("java");
        WebElement but = webDriver.findElement(By.xpath("//*[@id=\"su\"]"));
        but.click();
        Thread.sleep(3000);
        String title = webDriver.getTitle();
        Assert.assertEquals(title,"java_百度搜索");
//        Thread.sleep(5000);
    }


    /**
     *
     *打开百度
     *获取搜索框的文本
     * 校验是否为“java”
     * 校验完成后清除
     * 再次获取输入文本
     * 校验是否为空
     *
     */

    @Test
    public void checkTest() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        WebElement input = webDriver.findElement(By.id("kw"));
        input.sendKeys("java");
        WebElement input1 = webDriver.findElement(By.xpath("//*[@id=\"su\"]"));
        input1.click();
        Thread.sleep(3000);
        WebElement ele = webDriver.findElement(By.xpath("//*[@id=\"kw\"]"));
        String text = ele.getText();
        Thread.sleep(3000);
        System.out.println(text);
        Assert.assertEquals(text,"java");
//        System.out.println("实际值与预期值一致");
        ele.clear();
        String text2 = ele.getText();
        Assert.assertNull(text2,null);


    }

    /**
     * 打开百度首页
     * 获取新闻字段
     * 校验
     */
    @Test
    public void checkTest2() {
        webDriver.get("https://www.baidu.com");
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"s-top-left\"]/a[1]"));
        String text = element.getText();
        Assert.assertEquals(text,"新闻");
    }
/**
 * getTagName
 *  getAttribute(获取文本框默认值)
 *
 *
 */



























}
