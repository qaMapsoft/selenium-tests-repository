package by.mapsoft.qa.les11;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Created by Alex on 04.01.2017.
 */

public class ProductPage extends Page{

	ProductPage(WebDriver driver) {
		super(driver);
	}

	protected void addProductToCart() {
		driver.findElement(By.xpath(".//button[.='Add To Cart']")).click();
	}

	protected void addNewProductCheckout(int i) {
		selectOptions();
		addProductToCart();
		waitCheckoutCount(i);
	}

	protected void waitCheckoutCount(int i) {

		WebDriverWait wait = new WebDriverWait(DriverBase.getDriver(), 10);
		WebElement element = DriverBase.getDriver().findElement(By.xpath(".//*[@id='cart']/a[2]/span[1]"));
		wait.until(textToBePresentInElement(element,String.valueOf(i+1)));

	}

	protected void selectOptions(){
		if(isOptionsPresent()){
			WebElement element = driver.findElement(By.xpath(".//select[contains(@name,'options')]"));
			Select combo =  new Select(element);
			combo.selectByIndex(1);
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

}
