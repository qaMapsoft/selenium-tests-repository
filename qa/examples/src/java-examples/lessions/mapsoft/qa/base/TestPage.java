package mapsoft.qa.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

/**
 *  Created by alex on 04.01.2017..
 */
public class TestPage extends ExtJSDriver {
    private ExtJSComboBox newCheckPage;
    @Test
    public void test() throws InterruptedException {
        newCheckPage = new ExtJSComboBox(getDriver());
        newCheckPage.getBox();
//        newCheckPage.getOptions(0);

        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        String bodyId = (String) (executor.executeScript("return Ext.getBody().id"));
        System.out.println(bodyId);
        List<WebElement> element = (List<WebElement>) executor.executeScript("return Ext.query('div')");
        System.out.println(element);
      //  System.out.println(executor.executeScript("return Ext.select('div[id^='combo']');"));


    }

}
