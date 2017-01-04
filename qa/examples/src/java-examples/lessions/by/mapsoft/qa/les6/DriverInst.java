package by.mapsoft.qa.les6;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

/**
 *  Created by Alex on 28.12.2016.
 */
public class DriverInst {
	private static InheritableThreadLocal<WebDriver> tlDriver = new InheritableThreadLocal<WebDriver>();
	private static WebDriverFactory factory;

	@Parameters({"browserName"})
	@BeforeClass
	public void setUp(@Optional String browserName) throws IllegalAccessException {
		DriverInst.setDriver(browserName);
	}

	@AfterClass
	public void tearDown() throws Exception{
		DriverInst.getDriver().quit();
		tlDriver.set(null);
	}

	public static void setDriver(String browserName) throws IllegalAccessException {
		factory = new WebDriverFactory();
		tlDriver.set(factory.create(browserName));
	}

	public static WebDriver getDriver(){
		return tlDriver.get();
	}

}
