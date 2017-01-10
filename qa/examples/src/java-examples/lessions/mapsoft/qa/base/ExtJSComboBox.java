package mapsoft.qa.base;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.http.HttpResponse;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


/**
 * Created by agembitsky on 09.01.2017.
 */
public class ExtJSComboBox {
    WebDriver driver;

    ExtJSComboBox(WebDriver driver) {
          this.driver = driver;
          driver.get("http://192.168.101.170:8080");
          waitPage(".//a[.='Медицинская информационная система']");
          driver.findElement(By.xpath(".//a[.='Медицинская информационная система']")).click();
          waitPage(".//*[@id='title-1036-textEl']/table/tbody/tr/td[1]");
/*        HtmlUnitDriver htmlUnitDriver;
        htmlUnitDriver =   new HtmlUnitDriver();
        htmlUnitDriver.executeScript("");

        HttpPost loginRequest = new HttpPost("http://cells.org.ua/scrum-selenium/admin/pageHome.php");
        List<NameValuePair> credentials = new ArrayList<NameValuePair>();
        credentials.add(new BasicNameValuePair("username", "admin"));
        credentials.add(new BasicNameValuePair("password", "admin"));
        loginRequest.setEntity(new UrlEncodedFormEntity(credentials, Consts.UTF_8));
        HttpResponse response = getHttpClient().execute(loginRequest);
        response.getStatus();*/
    }


    protected void waitPage(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(presenceOfElementLocated(By.xpath(locator)));
    }
    private String getId2Xpath(String type, int i) {
        String idFind;
        List<WebElement> elem;
        switch (type){
        case "combobox":
            elem = driver.findElements(By.xpath(".//*[@class='x-autocontainer-innerCt'][contains(@id,'form')]/./div[contains(@id,'combo')]"));
            idFind = elem.get(i).getAttribute("id");
            break;
        case "checkbox":
            elem = driver.findElements(By.xpath(".//*[@class='x-autocontainer-innerCt'][contains(@id,'form')]/./div[contains(@id,'check')]"));
            idFind = elem.get(i).getAttribute("id");
            break;
        default: idFind = "";
        }
      return idFind;
    }


    protected WebElement getBox(){
        System.out.println(getId2Xpath("combobox",1)); // 0 - 1-ый элемент
        return driver.findElement(By.id(getId2Xpath("combobox",1)));
    }

    protected List<WebElement> getOptions(int i){

        List<WebElement> elem;
        elem =  driver.findElements(By.xpath(".//ul[li[contains(@class,'x-boundlist-item')]]"));
        System.out.println(elem);
        System.out.println(elem.get(i).findElements(By.xpath(".//li[contains(@class,'x-boundlist-item')]")));
        return elem.get(i).findElements(By.xpath(".//li[contains(@class,'x-boundlist-item')]"));
    }
}
