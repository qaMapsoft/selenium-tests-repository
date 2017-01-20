package by.mapsoft.qa.les11;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Created by Alex on 20.01.2017.
 */

public class MainPage extends Page{

	MainPage(WebDriver driver) {
		super(driver);
	}

	protected void goLiteCart() {
		driver.get("http://localhost:7080/litecart");
		waitPage();
	}
	protected void goCheckOut() {
		goLiteCart();
		waitPage();
		driver.findElement(By.xpath(".//*[@id='cart']/a[3]")).click();
		waitPageCheckout();
	}
	protected void waitPage() {
		WebDriverWait wait = new WebDriverWait(DriverBase.getDriver(), 10);
		wait.until(presenceOfElementLocated(By.cssSelector("div#copyright")));
	}
	protected void waitPageCheckout() {
		WebDriverWait wait = new WebDriverWait(DriverBase.getDriver(), 10);
		wait.until(presenceOfElementLocated(By.xpath(".//button[.='Confirm Order']")));
	}
	protected void selectProduct(int i) {

		if (i< findProducts().size()) {
			findProducts().get(i).click();
		}
		else {
			if(isProductPresent()) {
				findProducts().get(0).click();
			}
		}
		waitPage();
	}
	protected List<WebElement> findProducts() {
		return driver.findElements(By.xpath("//*[starts-with(@class,'product')]"));
	}
	protected boolean isProductPresent() {
		try {
			driver.findElement(By.xpath("//*[starts-with(@class,'product')]"));
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
}
