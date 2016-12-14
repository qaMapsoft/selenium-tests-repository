package com.company.tests.less2;

import java.util.concurrent.TimeUnit;

/**
 * Created by agembitsky on 14.12.2016.
 */
public class TestLitecartLogin {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testHello() {
        driver.get("http://localhost:7080/litecart/admin");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        driver = null;
    }
}
