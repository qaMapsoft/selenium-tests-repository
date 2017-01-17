package by.mapsoft.qa.les10;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Alex on 17.01.2017.
 */
public class ProductPage extends BasePage {

	private WebDriver driver;


	ProductPage(WebDriver driver) {
		this.driver = driver;
	}

public void goCategory(String menu) {

		driver.findElement(By.xpath(".//*[@id='content']/form/table//a[.='" + menu + "']")).click();
		waitRows();
	}
	public void goProducts() {
		List<WebElement> pr = driver.findElements(By.xpath(".//*[@id='content']/form/table/tbody/tr/td/a"));
		int count = pr.size();
		for(int i=0; i<count; i++) {
			pr = driver.findElements(By.xpath(".//*[@id='content']/form/table/tbody/tr/td/a"));
			String newName = pr.get(i).getText();
			if (newName.contains("Duck")) {
				pr.get(i).click();
				waitButtonCancel();
				driver.findElement(By.xpath(".//*[@id='content']/form/p/span/button[2]")).click();
				waitRows();
				List<LogEntry> logs = (List<LogEntry>) driver.manage().logs().get("browser").getAll();
				Assert.assertTrue(logs.isEmpty());
				}
			}
		}



}
