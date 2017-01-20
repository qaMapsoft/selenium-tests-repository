package by.mapsoft.qa.les11;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 *  Created by alex on 20.01.2016.
 */
public class DriverBase {
	private static InheritableThreadLocal<WebDriver> tlDriver = new InheritableThreadLocal<>();
	private static DriverFactory factory;

	@Parameters({"browserName"})
	@BeforeClass
	public void setUp(@Optional String browserName) throws IllegalAccessException {
		DriverBase.setDriver(browserName);
	}

	@AfterClass
	public void tearDown() throws Exception{
		DriverBase.getDriver().quit();
		tlDriver.set(null);
	}

	public static void setDriver(String browserName) throws IllegalAccessException {
		factory = new DriverFactory();
		if(browserName == null){
			browserName = "Chrome";
		}
		tlDriver.set(factory.create(browserName));
	}

	public static WebDriver getDriver(){
		return tlDriver.get();
	}

}
