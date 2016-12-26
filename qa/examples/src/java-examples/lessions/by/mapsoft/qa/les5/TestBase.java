package by.mapsoft.qa.les5;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import by.mapsoft.qa.les5.ProductData;

public class TestBase {


	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected WebElement product;
	protected ProductData testProduct,mainProduct, localProduct;
    	

	@BeforeSuite
	public void setUp() {

       ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, 10);
	}

	@AfterSuite
	public void tearDown() throws Exception {
		 driver.quit();
		 driver = null;
	}

	protected void goLitecart() {
		driver.get("http://localhost:8080/litecart");
		waitPageMain();
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
		wait.until(presenceOfElementLocated(By.cssSelector("#copyright")));
	}

	protected void waitPageLogin() {
		wait.until(presenceOfElementLocated(By.cssSelector("div#box-login")));
	}
	
	protected void waitPageAdmin() {
		wait.until(presenceOfElementLocated(By.cssSelector("#platform")));
	}

	protected void waitPageEditCountry() {
		wait.until(presenceOfElementLocated(By.xpath(".//*[@id='content']/form/h2")));
	}

	protected void waitPageMenu() {
		wait.until(presenceOfElementLocated(By.xpath("//h1")));
	}


	protected void goMenu(String menu) {
		driver.findElement(By.xpath(".//*[@id='app-']/a/span[contains(text(),'"+menu+"')]")).click();;
		waitPageMenu();
	}


	protected List<WebElement> findRowsCountries(int type) {
		if (type == 1) {
			return driver.findElements(By.xpath("//table/tbody/tr[@class='row']"));
		}
		else {
			return driver.findElements(By.xpath("//table/tbody/tr/td[3]/select"));
		}
	}

	protected WebElement findColCountries(WebElement element) {
		return element.findElement(By.xpath(".//td[5]/a"));
	}

	
	protected WebElement findColZones(WebElement element) {
		return element.findElement(By.xpath(".//td[6]"));
	}
	
	protected List<WebElement> findRowsZones(int type) {
		if(type ==1) {
			return driver.findElements(By.xpath("//*[@id='table-zones']/tbody/tr/td/input[@type='hidden']/../.."));
		}
		else {
			return driver.findElements(By.xpath("//table/tbody/tr/td[3]/a"));
		}
	}

	protected WebElement findZones(WebElement element) {
		return element.findElement(By.xpath(".//td[3]"));
	}


	protected List<WebElement> findProductsCampaigns() {
		return driver.findElements(By.xpath(".//*[@id='box-campaigns']/div/ul/li"));
	}

	protected WebElement findProductName(WebElement element) {
		return element.findElement(By.xpath(".//div[@class='name']"));
	}
	protected WebElement findProductPrice(WebElement element) {
		return element.findElement(By.xpath(".//div/s[@class='regular-price']"));
	}

	protected WebElement findProductPriceSale(WebElement element) {
		return element.findElement(By.xpath(".//div/strong[@class='campaign-price']"));
	}

	protected WebElement findLocalProductName() {
		return driver.findElement(By.xpath(".//h1[@class='title']"));
	}

	protected WebElement findLocalProductPrice() {
		return driver.findElement(By.xpath(".//div/s[@class='regular-price']"));
	}

	protected WebElement findLocalProductPriceSale() {
		return driver.findElement(By.xpath(".//div/strong[@class='campaign-price']"));
	}

	}
