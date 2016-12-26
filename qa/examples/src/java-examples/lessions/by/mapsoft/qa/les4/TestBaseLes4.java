package by.mapsoft.qa.les4;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class TestBaseLes4 {

//    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
//parallel="none" thread-count="5"
    public static WebDriver driver;
    public static WebDriverWait wait;
    protected List<WebElement> products;
    protected WebElement product;
    protected int i,j,menuCount,submenuCount,productCount;

    @BeforeSuite
    public void setUp() {

/*        if (tlDriver.get() != null) {
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, 10);
            return;
        }
*/        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
//        tlDriver.set(driver);
        wait = new WebDriverWait(driver, 10);

    }

    @AfterSuite
    public void tearDown() throws Exception {
        driver.quit();
        driver = null;
    }
    protected void loginLitecart() {
        driver.manage().deleteAllCookies();
        driver.get("http://localhost:8080/goLitecart/admin");
        waitPageLogin();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        waitPageAdmin();
    }

    protected void litecart() {
        driver.get("http://localhost:8080/goLitecart");
        waitPageMain();
    }

    protected void waitPageLogin() {
        wait.until(presenceOfElementLocated(By.cssSelector("div#box-login")));
    }

    protected void waitPageAdmin() {
        wait.until(presenceOfElementLocated(By.cssSelector("#platform")));
    }
    protected void waitPageMain() {
        wait.until(presenceOfElementLocated(By.cssSelector("#copyright")));
    }

    protected List<WebElement> findMenu() {
        return driver.findElements(By.xpath("//*[@id='app-']"));
    }

    protected List<WebElement> findSubMenu() {
        return driver.findElements(By.xpath(".//*[starts-with(@id,'doc')]"));
    }

    protected boolean isTitlePagePresent() {
        try {
            driver.findElement(By.xpath("//h1"));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    protected List<WebElement> findProducts() {
        return driver.findElements(By.xpath("//*[starts-with(@class,'product')]"));

    }
    protected List<WebElement> findStickers(WebElement element) {
        return element.findElements(By.xpath(".//*[starts-with(@class,'sticker')]"));

    }

}
