package by.mapsoft.qa.les6;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
/**
 *  Created by Alex on 28.12.2016.
 */
public class TestBaseAll {

	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected WebElement product;

	@BeforeSuite
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, 10);
	}

	@AfterSuite
	public void tearDown() throws Exception {
//		driver.quit();
//		driver = null;
	}

	protected void loginLitecart() {
		driver.manage().deleteAllCookies();
		driver.get("http://localhost:8080/litecart/admin");
		waitPageLogin();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		waitPageAdmin();
	}

	protected void waitPageMain() {
		wait.until(presenceOfElementLocated(By.cssSelector("div#copyright")));
	}

	protected void waitPageLogin() {
		wait.until(presenceOfElementLocated(By.cssSelector("div#box-login")));
	}

	protected void waitPageAdmin() {
		wait.until(presenceOfElementLocated(By.cssSelector("#platform")));
	}

	protected void waitPageMenu() {
		wait.until(presenceOfElementLocated(By.xpath("//h1")));
	}
	
	protected void waitTab(String tab) {
		wait.until(presenceOfElementLocated(By.xpath(".//form/div/ul/li/a [.='" + tab + "']")));
	}	

	protected void goLiteCart() {
		driver.manage().deleteAllCookies();
		driver.get("http://localhost:8080/litecart");
		waitPageMain();
	}

	protected void goMenu(String menu) {
		driver.findElement(By.xpath(".//*[@id='app-']/a/span[contains(text(),'" + menu + "')]")).click();
		waitPageMenu();
	}
	
	protected void goTab(String tab) {
		driver.findElement(By.xpath(".//form/div/ul/li/a [.='" + tab + "']")).click();
		waitTab(tab);
	}	

	protected void goAddNewProduct() {
		driver.findElement(By.xpath(".//*[@id='content']/div[1]/a[2]")).click();
		waitPageMenu();
	}

	public void goAddNewAccount() {
		driver.findElement(By.xpath(".//a[.='New customers click here']")).click();
		waitPageMenu();
	}

	protected boolean isLogoutPresent() {
		try {
			driver.findElement(By.xpath(".//a[.='Logout']"));
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	protected boolean isErrorMessagePresent() {
		try {
			driver.findElement(By.xpath(".//*[@id='notices']/div"));
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
}
