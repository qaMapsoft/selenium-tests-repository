package by.mapsoft.qa.les6;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UserPage extends TestBaseAll{

	private WebDriver driver;
	private UserData testUser;

	UserPage(WebDriver driver) {
		this.driver = driver;
	}

	public UserPage createNewUser() {
		testUser = new UserData();
		setFirstName();
		setLastName();
		setAddress1();
		setPostCode();
		setCity();
		setCountry();
		setEmail();
		setPhone();
		setPassword();
		setConfirmPassword();
		createAccountButton();
		return this;
	}

	private void createAccountButton() {

		driver.findElement(By.xpath(".//button[@name='create_account']")).click();
		waitPageMain();
		if(!isLogoutPresent()){
			if (isErrorMessagePresent()) {
				testUser.getNewMail();
				setEmail();
				setPassword();
				setConfirmPassword();
				createAccountButton();
			}
		}
	}

	public void checkAddNewUser() {
		driver.findElement(By.xpath(".//a[.='Logout']")).click();
		waitPageMain();
		driver.findElement(By.xpath(".//input[@name='email']")).sendKeys(testUser.email);
		driver.findElement(By.xpath(".//input[@name='password']")).sendKeys(testUser.password);
		driver.findElement(By.xpath(".//button[@name='login']")).click();
		waitPageMain();
		driver.findElement(By.xpath(".//a[.='Logout']")).click();
	}

	protected void setFirstName() {
		driver.findElement(By.xpath(".//input[@name='firstname']")).sendKeys(testUser.firstname);
	}
	
	protected void setLastName() {
		driver.findElement(By.xpath(".//input[@name='lastname']")).sendKeys(testUser.lastname);
	}

	protected void setAddress1() {
		driver.findElement(By.xpath(".//input[@name='address1']")).sendKeys(testUser.address1);
	}

	protected void setPostCode() {
		driver.findElement(By.xpath(".//input[@name='postcode']")).sendKeys(testUser.postcode);}

	protected void setCity() {
		driver.findElement(By.xpath(".//input[@name='city']")).sendKeys(testUser.city);
	}

	protected void setCountry() {

		driver.findElement(By.xpath(".//*[contains(@id,'select2-country_code-')]")).click();
		WebElement element = driver.findElement(By.xpath(".//input[contains(@class,'select2-search__field')]"));
		element.sendKeys(testUser.country);
		element.click();
	}

	protected void setEmail() {
		WebElement element = driver.findElement(By.xpath(".//input[@name='email']"));
		element.clear();
		element.sendKeys(testUser.email);
	}

	protected void setPhone() {
		driver.findElement(By.xpath(".//input[@name='phone']")).sendKeys(testUser.phone);
	}

	protected void setPassword() {
		driver.findElement(By.xpath(".//input[@name='password']")).sendKeys(testUser.password);
	}

	protected void setConfirmPassword() {
		driver.findElement(By.xpath(".//input[@name='confirmed_password']")).sendKeys(testUser.confirm_password);
	}

}
