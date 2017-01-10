package by.mapsoft.qa.les8;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 *  Created by alex on 10.01.2017.
 */
public class DriverNewBase {
	private static InheritableThreadLocal<WebDriver> tlDriver = new InheritableThreadLocal<>();
	private static BrowserFactory factory;

	@Parameters({"browserName"})
	@BeforeClass
	public void setUp(@Optional String browserName) throws IllegalAccessException {
		DriverNewBase.setDriver(browserName);
	}

	@AfterClass
	public void tearDown() throws Exception{
		DriverNewBase.getDriver().quit();
		tlDriver.set(null);
	}

	public static void setDriver(String browserName) throws IllegalAccessException {
		factory = new BrowserFactory();
		if(browserName == null){
			browserName = "Chrome";
		}
		tlDriver.set(factory.create(browserName));
	}

	public static WebDriver getDriver(){
		return tlDriver.get();
	}

}
