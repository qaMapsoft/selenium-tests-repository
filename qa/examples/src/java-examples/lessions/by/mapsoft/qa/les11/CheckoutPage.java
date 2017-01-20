package by.mapsoft.qa.les11;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Created by Alex on 04.01.2017.
 */

public class CheckoutPage extends Page{

	CheckoutPage(WebDriver driver) {
		super(driver);
	}


	protected void deleteProductsCart() {

		while(isProductCartPresent()){
			 waitAndClickRemoteButton();
			 waitProducts();
		}
	}

	protected void waitAndClickRemoteButton() {

		WebDriverWait wait = new WebDriverWait(DriverBase.getDriver(), 10);
		try {
			wait.until(visibilityOf(driver.findElement(By.xpath(".//button[@name='remove_cart_item']"))));
			driver.findElement(By.xpath(".//button[@name='remove_cart_item']")).click();
			}catch (StaleElementReferenceException e) {
					waitAndClickRemoteButton();
			}catch (NoSuchElementException e) {}
	}

	protected void waitProducts() {
		try {
			WebDriverWait wait = new WebDriverWait(DriverBase.getDriver(), 10);
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

}
