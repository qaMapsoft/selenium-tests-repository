package by.mapsoft.qa.les8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by alex on 10.01.2017.
 */
public class BrowserFactory {
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
