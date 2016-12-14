package com.company.tests.less2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by agembitsky on 14.12.2016.
 */
public class TestHello {
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://selenium2.ru");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testHello() {
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
        driver = null;
    }
}
