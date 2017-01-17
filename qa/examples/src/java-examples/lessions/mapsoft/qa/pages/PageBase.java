package mapsoft.qa.pages;

import by.mapsoft.qa.les7.DriverBase;
import mapsoft.qa.base.ExtJSDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * Created by agembitsky on 03.01.2017.
 */
public class PageBase {

    public String runExtJSScriptFindLocator(String script) {
        JavascriptExecutor executor = (JavascriptExecutor) ExtJSDriver.getDriver();
        return (String) (executor.executeScript(script));
    }

    public List<String> runExtJSScriptFindLocators(String script) {
        JavascriptExecutor executor = (JavascriptExecutor) ExtJSDriver.getDriver();
        return  (List<String>) (executor.executeScript(script));
    }


    public void waitPage(String locator) {
        WebDriverWait wait = new WebDriverWait(ExtJSDriver.getDriver(), 10);
        wait.until(presenceOfElementLocated(By.xpath(locator)));
    }
    protected void waitTextPresent(int i) {

        WebDriverWait wait = new WebDriverWait(DriverBase.getDriver(), 10);
        WebElement element = DriverBase.getDriver().findElement(By.xpath(".//*[@id='cart']/a[2]/span[1]"));
        wait.until(textToBePresentInElement(element,String.valueOf(i+1)));

    }

    	protected void waitAndClickButtonNoStale() {
                WebDriver driver = ExtJSDriver.getDriver();
                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until((ExpectedCondition<Boolean>) webDriver -> {
                    try {
                        driver.findElement(By.xpath(".//button[@name='remove_cart_item']")).click();
                    }catch (NoSuchElementException e) {
                            return true;
                    }catch (StaleElementReferenceException e) {
                            return false;
                    }
                    return true;
                });
        }
    protected void waitAndClickButtonWhile() {
        WebDriver driver = ExtJSDriver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(presenceOfElementLocated(By.xpath(".//button[@name='remove_cart_item']")));
            driver.findElement(By.xpath(".//button[@name='remove_cart_item']")).click();
        }catch (StaleElementReferenceException e) {
            waitAndClickButtonWhile();
        }catch (NoSuchElementException e) {}
    }

    public static void waitpresenceOf(String xpath) {
            WebDriverWait wait = new WebDriverWait(ExtJSDriver.getDriver(), 10);
            wait.until(presenceOfElementLocated(By.xpath(xpath)));
    }

    public static void waitstalenessOf(WebElement element) {
        WebDriverWait wait = new WebDriverWait(ExtJSDriver.getDriver(), 10);
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    public static void waitToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(ExtJSDriver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    protected void waitelementToBeClickableXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(ExtJSDriver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }
    protected void waitelementToBeClickableElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(ExtJSDriver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    protected void selectOptions(){
        WebDriver driver = ExtJSDriver.getDriver();
        if(isOptionsPresent()){
            WebElement element = driver.findElement(By.xpath(".//select[contains(@name,'options')]"));
            Select combo =  new Select(element);
            combo.selectByIndex(1);
        }
    }

    protected boolean isOptionsPresent() {
        try {
            ExtJSDriver.getDriver().findElement(By.xpath(".//table/tbody/tr/td[@class='options']"));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
    protected boolean isLogoutPresent() {
        try {
            ExtJSDriver.getDriver().findElement(By.xpath(".//a[.='Logout']"));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    protected boolean isErrorMessagePresent() {
        try {
            ExtJSDriver.getDriver().findElement(By.xpath(".//*[@id='notices']/div"));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
