package mapsoft.qa.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class ExtJSDriver {
	private static InheritableThreadLocal<WebDriver> tlDriver = new InheritableThreadLocal<>();
	private static ExtJSBrowserFactory factory;

	@Parameters({"browserName"})
	@BeforeClass
	public void setUp(@Optional String browserName) throws IllegalAccessException {
		ExtJSDriver.setDriver(browserName);
	}

	@AfterClass
	public void tearDown() throws Exception{
		ExtJSDriver.getDriver().quit();
		tlDriver.set(null);
	}

	public static void setDriver(String browserName) throws IllegalAccessException {
		factory = new ExtJSBrowserFactory();
		if(browserName == null){
			browserName = "Chrome";
		}
		tlDriver.set(factory.create(browserName));
	}

	public static WebDriver getDriver(){
		return tlDriver.get();
	}


}
