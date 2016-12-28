package by.mapsoft.qa.les6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductPage extends TestBaseAll{

	private WebDriver driver;
	private ProductData testProduct;

	ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public void createNewProduct() {
		testProduct = new ProductData();
		fillTabGeneral();
		fillTabInformation();
		fillTabPrices();
		save();
	}
	
	public void checkAddNewProduct() {
		String newName = driver.findElement(By.xpath("//table/tbody/tr/td/a[.='"+testProduct.name+"']")).getText();
		Assert.assertEquals(newName,testProduct.name,"failed add new product");
	}	

	private void fillTabGeneral() {
		goTab("General");
		setStatus();
		setName();
		setCode();
		setCategories();
		setQuantity();
	}

	private void fillTabInformation() {
		goTab("Information");
		setManufacturer();
		setShortDescription();
		setDescription();
	}

	private void fillTabPrices() {
		goTab("Prices");
		setPurchasePrice();
		setPrice();
	}

	public void save() {
		driver.findElement(By.xpath(".//*[@id='content']/form/p/span/button[@name='save']")).click();
	}

	protected void setStatus() {
		driver.findElement(By.xpath(".//*[@id='tab-general']//input[@name='status']")).click();
	}

	protected void setName() {
		driver.findElement(By.xpath(".//*[@id='tab-general']//input[contains(@name,'name')]")).sendKeys(testProduct.name);
	}

	protected void setCode() {
		driver.findElement(By.xpath(".//*[@id='tab-general']//input[@name='code']")).sendKeys(testProduct.code);
	}

	protected void setCategories() {
		driver.findElement(By.xpath(".//*[@id='tab-general']//input[@data-name='Root']")).click();
		driver.findElement(By.xpath(".//*[@id='tab-general']//input[@data-name='Rubber Ducks']")).click();
	}

	protected void setQuantity() {
		WebElement element = driver.findElement(By.xpath(".//*[@id='tab-general']//input[@name='quantity']"));
		element.clear();
		element.sendKeys(testProduct.quantity);
	}

	protected void setManufacturer() {
		Select m = new Select(driver.findElement(By.xpath(".//*[@id='tab-information']//select[@name='manufacturer_id']")));
		m.selectByVisibleText(testProduct.manufacturer);
	}

	protected void setShortDescription() {
		driver.findElement(By.xpath(".//*[@id='tab-information']//input[contains(@name,'short_description')]")).sendKeys(testProduct.short_description);
	}

	protected void setDescription() {
		driver.findElement(By.xpath(".//*[@id='tab-information']//div/div[contains(@class,'editor')]")).sendKeys(testProduct.description);
	}

	protected void setPurchasePrice() {
		WebElement element = driver.findElement(By.xpath(".//*[@id='tab-prices']//input[@name='purchase_price']"));
		element.clear();
		element.sendKeys(testProduct.purchase_price);
		Select m = new Select(driver.findElement(By.xpath(".//*[@id='tab-prices']//select[@name='purchase_price_currency_code']")));
		m.selectByVisibleText(testProduct.currency);		
	}

	protected void setPrice() {
		WebElement element = driver.findElement(By.xpath(".//*[@id='tab-prices']//input[@name='prices[USD]']"));
		element.clear();
		element.sendKeys(testProduct.price);
	
	}

}
