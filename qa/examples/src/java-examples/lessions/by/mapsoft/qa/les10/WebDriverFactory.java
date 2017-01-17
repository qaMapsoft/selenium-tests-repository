package by.mapsoft.qa.les10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by agembitsky on 17.01.2017
 */
public class WebDriverFactory {
    static WebDriver create(String type) throws IllegalAccessException {
        WebDriver driver;
        switch (type){
            case "Firefox":
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case "Chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                driver = new ChromeDriver(options);
                break;
            case "IE":
                driver = new InternetExplorerDriver();
                break;
        default:
            throw new IllegalAccessException();
        }
        return driver;
    }
}
