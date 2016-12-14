package com.company.tests.less2;

import java.util.concurrent.TimeUnit;

/**
 * Created by agembitsky on 14.12.2016.
 */
public class TestHello {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testHello() {
        driver.get("http://selenium2.ru");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        driver = null;
    }
}
