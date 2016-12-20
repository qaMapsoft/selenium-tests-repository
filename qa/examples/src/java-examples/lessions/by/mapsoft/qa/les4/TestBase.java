package by.mapsoft.qa.les4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
/**
 * Created by Alex on 20.12.2016.
 */
public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected int i,j,menuCount,submenuCount,productCount;

    @BeforeSuite
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10/* seconds */);
        driver.get("http://localhost:7080/litecart");

    }

    @AfterSuite
    public void tearDown() throws Exception {
        driver.quit();
        driver = null;
    }
    protected void loginLitecart() {
        driver.get("http://localhost:7080/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        waitPage();
    }

    protected void waitPage() {
        wait.until(presenceOfElementLocated(By.cssSelector("#platform")));
    }

    protected List<WebElement> findMenu() {
        return driver.findElements(By.xpath("//li[contains(@id,'app-')]"));
    }

    protected List<WebElement> findSubMenu() {
        return driver.findElements(By.xpath(".//ul[@class='docs']/li"));
    }

    protected void titlePagePresent() {
        titleIs(driver.getTitle());
    }

    protected List<WebElement> findProduct() {
        return driver.findElements(By.xpath("//li[contains(@class,'product')]/a[@class='link']/div[1]"));

    }

    protected List<WebElement> findStickers(WebElement element) {
        return element.findElements(By.xpath(".//div[contains(@class,'sticker')]"));

    }
}
