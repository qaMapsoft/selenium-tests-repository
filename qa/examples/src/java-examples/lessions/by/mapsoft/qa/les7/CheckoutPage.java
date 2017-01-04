package by.mapsoft.qa.les7;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

/**
 * Created by Alex on 04.01.2017.
 */

public class CheckoutPage {

	private WebDriver driver;

	CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public void goCheckOut() {
		goLiteCart();
		waitPage();
		driver.findElement(By.xpath(".//*[@id='cart']/a[3]")).click();
		waitPageCheckout();
	}

	public void addProductToCart() {
		driver.findElement(By.xpath(".//button[.='Add To Cart']")).click();
	}

	public void addNewProductCheckout(int i) {

		if (i< findProducts().size()) {
			findProducts().get(i).click();
		}
		else {
			if(isProductPresent()) {
				findProducts().get(0).click();
			}
		}
		waitPage();
		selectOptions();
		addProductToCart();
		waitCheckoutCount(i);
		goLiteCart();
		waitPage();
	}

	public void deleteProductsCart() {

		while(isProductCartPresent()){
			 waitAndClickRemote();
			 waitProducts();
		}
	}



	protected List<WebElement> findProducts() {
		return driver.findElements(By.xpath("//*[starts-with(@class,'product')]"));
	}

	protected void waitPage() {
		WebDriverWait wait = new WebDriverWait(DriverBase.getDriver(), 10);
		wait.until(presenceOfElementLocated(By.cssSelector("div#copyright")));
	}
	protected void waitPageCheckout() {
		WebDriverWait wait = new WebDriverWait(DriverBase.getDriver(), 10);
		wait.until(presenceOfElementLocated(By.xpath(".//button[.='Confirm Order']")));
	}

	protected void goLiteCart() {
		WebDriver driver = DriverBase.getDriver();
		driver.get("http://localhost:7080/litecart");
		waitPage();
	}
	protected void waitCheckoutCount(int i) {

		WebDriverWait wait = new WebDriverWait(DriverBase.getDriver(), 10);
		WebElement element = DriverBase.getDriver().findElement(By.xpath(".//*[@id='cart']/a[2]/span[1]"));
		wait.until(textToBePresentInElement(element,String.valueOf(i+1)));

	}

	protected void waitAndClickRemote() {

			WebDriverWait wait = new WebDriverWait(DriverBase.getDriver(), 10);
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
	protected void waitProducts() {

			WebDriverWait wait = new WebDriverWait(DriverBase.getDriver(), 10);
			wait.until((ExpectedCondition<Boolean>) webDriver -> {
				try {
					driver.findElement(By.xpath(".//table/tbody/tr/td[@class='item']"));
				}catch (NoSuchElementException e) {
						return true;
				}catch (StaleElementReferenceException e) {
						return false;
				}
				return true;
			});
	}

	protected void selectOptions(){
		if(isOptionsPresent()){
			WebElement element = driver.findElement(By.xpath(".//select[contains(@name,'options')]"));
			Select combo =  new Select(element);
			combo.selectByIndex(1);
		}
	}
	protected boolean isProductPresent() {
		try {
			driver.findElement(By.xpath("//*[starts-with(@class,'product')]"));
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	protected boolean isOptionsPresent() {
		try {
			driver.findElement(By.xpath(".//table/tbody/tr/td[@class='options']"));
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
	protected boolean isProductCartPresent() {
		try {
			driver.findElement(By.xpath(".//table/tbody/tr/td[@class='item']"));
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}



}
