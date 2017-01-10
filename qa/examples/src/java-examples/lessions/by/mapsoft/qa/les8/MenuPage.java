package by.mapsoft.qa.les8;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Created by Alex on 04.01.2017.
 */

public class MenuPage {

	private WebDriver driver;
	private String currentWindow,newWindow;
	private Set<String> existingWindows;

	MenuPage(WebDriver driver) {
		this.driver = driver;
	}

	public void goCountry() {
		loginLitecart();
		goMenu("Countries");
		waitPageMenu();
		List<WebElement> rows =  findRowsCountries();
		rows.get(1).findElement(By.xpath(".//td[5]/a")).click();
		waitPageEditCountry();
	}

	public void goExternalLink(int i) {
		saveCurrentWindow();
		clickExternalLink(i);
		waitNewWindow();
		goNewWindow();
		waitPageSourceNewWindow();
		closeNewWindow();
		goEditCountryWindow();
	}


	public int getCountExternalLink() {
		return driver.findElements(By.xpath(".//a[@target='_blank']/i[contains(@class,'external-link')]")).size();
	}


	public void clickExternalLink(int i) {
		driver.findElements(By.xpath(".//a[@target='_blank']/i[contains(@class,'external-link')]")).get(i).click();
	}


	protected void waitPage() {
		WebDriverWait wait = new WebDriverWait(DriverNewBase.getDriver(), 10);
		wait.until(presenceOfElementLocated(By.cssSelector("div#copyright")));
	}

	protected void waitPageLogin() {
		WebDriverWait wait = new WebDriverWait(DriverNewBase.getDriver(), 10);
		wait.until(presenceOfElementLocated(By.cssSelector("div#box-login")));
	}

	protected void waitPageAdmin(){
		WebDriverWait wait = new WebDriverWait(DriverNewBase.getDriver(), 10);
		wait.until(presenceOfElementLocated(By.cssSelector("#platform")));
	}

	protected void waitPageEditCountry(){
		WebDriverWait wait = new WebDriverWait(DriverNewBase.getDriver(), 10);
		wait.until(presenceOfElementLocated(By.xpath(".//*[@id='content']/form/h2")));
	}

	protected void waitPageMenu() {
		WebDriverWait wait = new WebDriverWait(DriverNewBase.getDriver(), 10);
		wait.until(presenceOfElementLocated(By.xpath("//h1")));
	}


	protected void goMenu(String menu) {
		driver.findElement(By.xpath(".//*[@id='app-']/a/span[contains(text(),'"+menu+"')]")).click();;
		waitPageMenu();
	}

	protected void loginLitecart() {
		driver.manage().deleteAllCookies();
		driver.get("http://localhost:7080/litecart/admin");
		waitPageLogin();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		waitPageAdmin();
	}

	protected List<WebElement> findRowsCountries() {
			return driver.findElements(By.xpath("//table/tbody/tr[@class='row']"));
		}

	public void waitNewWindow() {
		WebDriverWait wait = new WebDriverWait(DriverNewBase.getDriver(), 10);
		newWindow = wait.until(anyWindowOtherThan(existingWindows));
	}

	public void waitPageSourceNewWindow() {
		WebDriverWait wait = new WebDriverWait(DriverNewBase.getDriver(), 10);
		newWindow = wait.until(WebDriver::getPageSource);
	}


	public ExpectedCondition<String> anyWindowOtherThan(Set<String> oldWindows) {
		return new ExpectedCondition<String>() {
			@Override
			public String apply(WebDriver driver) {
				Set<String> handles = driver.getWindowHandles();
				handles.removeAll(oldWindows);
				return handles.size() > 0 ? handles.iterator().next() :null;
			}
		};

	}


	public void goNewWindow()  {
		DriverNewBase.getDriver().switchTo().window(newWindow);
	}

	public void closeNewWindow() {
		DriverNewBase.getDriver().close();
	}

	public void goEditCountryWindow() {
		DriverNewBase.getDriver().switchTo().window(currentWindow);
	}

	public void saveCurrentWindow() {
		currentWindow = DriverNewBase.getDriver().getWindowHandle();
		existingWindows = DriverNewBase.getDriver().getWindowHandles();
	}

/*	protected void waitAndClickRemote() {

			WebDriverWait wait = new WebDriverWait(DriverNewBase.getDriver(), 10);
			wait.until((ExpectedCondition<Boolean>) webDriver -> {
				try {
					driver.findElement(By.xpath(".//button[@name='remove_cart_item']")).click();
				}catch (NoSuchElementException e) {
						return true;
				}catch (StaleElementReferenceException e) {
						return false;
				}
				return true;
			});
	}
	protected void waitAndClickRemoteButton() {

		WebDriverWait wait = new WebDriverWait(DriverNewBase.getDriver(), 10);
		try {
			wait.until(visibilityOf(driver.findElement(By.xpath(".//button[@name='remove_cart_item']"))));
			driver.findElement(By.xpath(".//button[@name='remove_cart_item']")).click();
			}catch (StaleElementReferenceException e) {
					waitAndClickRemoteButton();
			}catch (NoSuchElementException e) {}
	}

	protected void waitProducts() {
		try {
			WebDriverWait wait = new WebDriverWait(DriverNewBase.getDriver(), 10);
			wait.until(visibilityOf(driver.findElement(By.xpath(".//table/tbody/tr/td[@class='item']"))));
		}catch (StaleElementReferenceException e) {
			waitProducts();
		}catch (NoSuchElementException e) {}
	}

	protected boolean isProductCartPresent() {
		try {
			driver.findElement(By.xpath(".//table/tbody/tr/td[@class='item']"));
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
*/


}
