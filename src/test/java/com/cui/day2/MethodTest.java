package com.cui.day2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MethodTest {
    WebDriver webDriver;
    @BeforeMethod
    public void openBrowser() {

        System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver_win32-84\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void clickTest() throws InterruptedException {
        webDriver.get("http://www.baidu.com");
        WebElement newslink = webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/a[1]"));
        
        newslink.click();
        Thread.sleep(5000);
//        Assert.assertEquals();



    }
    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }

}
