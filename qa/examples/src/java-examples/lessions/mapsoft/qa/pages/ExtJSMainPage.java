package mapsoft.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import mapsoft.qa.base.ExtJSComponent;

/**
 * Created by agembitsky on 11.01.2017.
 */
public class ExtJSMainPage extends PageBase {
    public WebDriver driver;
    public WebElement mainHeader, mainBody, mainNavigator, mainDesktop;

    public ExtJSMainPage(WebDriver driver){
        this.driver =  driver;
    }

    public void start(){
        driver.get("http://192.168.101.170:8080");
        waitPage(".//a[.='Медицинская информационная система']");
        driver.findElement(By.xpath(".//a[.='Медицинская информационная система']")).click();
        waitPage(".//*[contains(@id,'title')]/table/tbody");
    }

    public void login()
    {
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<WebElement>() {
                    @Override
                    public WebElement apply(WebDriver d) {
                        return d.findElement(By.xpath(".//div[contains(@id,'trigger-picker')]"));
                    }
                });
        myDynamicElement.click();

        driver.findElement(By.xpath(".//ul[contains(@id,'boundlist')]/ul/li")).click();

        driver.findElements(By.xpath(".//div[contains(@id,'trigger-picker')]")).get(1).click();
        driver.findElement(By.xpath(".//ul[contains(@id,'boundlist')]/li")).click();

//        driver.findElement(By.xpath(".//input[@type='password']")).sendKeys("20102010");

        driver.findElement(By.xpath(".//span[contains(@id,'button')]")).click();

//    driver.findElement(By.id("button-1023-btnInnerEl")).click();


    }
    public void getBaseElement(){
        ExtJSComponent component = new ExtJSComponent(driver);
        waitpresenceOf(".//*[@id='common-main_header']");
        mainHeader = component.getMainHeader();
        mainBody = component.getMainBody();
        mainNavigator = component.getMainNavigator();
        mainDesktop = component.getMainDesktop();
    }
}
