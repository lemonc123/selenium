package com.cui.exercise;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class testUI {
    WebDriver webDriver;
    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver_win32-84\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    /**
     * 1. 打开 “UI自动化测试”主页
     * 2. 校验 “Volvo”单选框已经选中
     */
    @Test
    public void selectTest() throws InterruptedException {
        webDriver.get("C:\\Users\\cui\\Desktop\\webdriver_demo\\selenium_html\\demo1.html");
        Thread.sleep(5000);
        WebElement element = webDriver.findElement(By.className("Volvo"));
        boolean boole = element.isSelected();
//        Assert.assertTrue(boole,"true");
        Assert.assertFalse(boole,"false");

    }


    /**
     *   1. 打开“UI自动化测试”主页
     * 	2. 校验 submit 文本框为不可输入状态
     *
     */
    @Test
    public void isEnabledTest() throws InterruptedException {
        webDriver.get("C:\\Users\\cui\\Desktop\\webdriver_demo\\selenium_html\\demo1.html");
        Thread.sleep(5000);
        boolean button = webDriver.findElement(By.id("button")).isEnabled();
//        Assert.assertTrue(button,"submit按钮不可以选");
        Assert.assertFalse(button,"submit按钮不可以选");

    }

    /**
     * 1. 打开百度主页
     * 	2. 截图
     *
     */
    @Test
    public void shortcutTest() throws InterruptedException, IOException {
        webDriver.get("https://www.baidu.com");
        Thread.sleep(5000);
        File screenshotAs = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotAs,new File("D:/t.png"));

    }

    /**
     *  1. 打开“UI自动化测试”主页
     * 	2. 点击Alert按钮
     * 	3.  在alert警告框点击确定按钮
     *
     */
    @Test
    public void alterTest() throws InterruptedException {
        webDriver.get("C:\\Users\\cui\\Desktop\\webdriver_demo\\selenium_html\\index.html");
        Thread.sleep(5000);
        webDriver.findElement(By.className("alert")).click();
        Thread.sleep(5000);
        //选取alert弹窗，把控制权交给alert
        Alert alert = webDriver.switchTo().alert();
        alert.accept();
        Thread.sleep(5000);
    }

    /**
     *  1. 打开“UI自动化测试”主页
     * 	2. 点击Prompt按钮
     * 	3. 在Prompt 弹窗中，输入“这个是Prompt”
     * 	4.  点击确定\取消按钮
     */
    @Test
    public void promptTest() throws InterruptedException {
        webDriver.get("C:\\Users\\cui\\Desktop\\webdriver_demo\\selenium_html\\index.html");
        Thread.sleep(3000);
//        webDriver.findElement(By.id("prompt")).click();
        webDriver.findElement(By.xpath("//*[@id=\"prompt\"]/input")).click();
        Alert alert = webDriver.switchTo().alert();
        Thread.sleep(3000);
        alert.sendKeys("这个是prompt");
        alert.accept();
        Thread.sleep(3000);
        alert.accept();
    }


    /**
     *  1. 定位iFrame
     * 	2. driver控制权交给iFrame
     * 	3. 操作iFrame里面的元素
     * 	4. driver控制权交回原页面
     *
     *
     *  1. selectByIndex() 根据索引来选取，从0开始
     * 	2. selectByValue() 根据属性value的属性值来选取
     * 	3. selectByVisibleText()根据标签之间的Text值，也就是页面显示的
     */
    @Test
    public void iframeTest() throws InterruptedException {
        webDriver.get("C:\\Users\\cui\\Desktop\\webdriver_demo\\selenium_html\\index.html");
        Thread.sleep(3000);
        //用id或者name定位iframe，并将控制权交给iframe
        webDriver.switchTo().frame("aa");
        webDriver.findElement(By.id("user")).sendKeys("我爱 自动化");
        Thread.sleep(3000);
        WebElement select1 = webDriver.findElement(By.name("select"));
        Select select = new Select(select1);
        select.selectByIndex(3);
        Thread.sleep(3000);
        select.selectByValue("iphone");
        select.selectByVisibleText("");
        webDriver.switchTo().defaultContent();
        Thread.sleep(3000);
    }


    /**
     * 多窗口处理
     *
     */

    @Test
    public void Test() throws InterruptedException {
        webDriver.get("C:\\Users\\cui\\Desktop\\webdriver_demo\\selenium_html\\index.html");
        Thread.sleep(3000);
//        定位元素并点击
        webDriver.findElement(By.xpath("//*[@id=\"open\"]/a")).click();;
//        获取当前页面句柄
        String handle = webDriver.getWindowHandle();
//      获取所有页面的句柄，并循环判断不是当前的句柄，就做选取switchTo()
        for (String handles:webDriver.getWindowHandles()) {
            if (handles.equals(handle))
                continue;
            webDriver.switchTo().window(handles);
        }
        webDriver.findElement(By.id("user")).sendKeys("test1");

    }

    @AfterMethod
    public void closeBrowser(){

        webDriver.quit();
    }



}
