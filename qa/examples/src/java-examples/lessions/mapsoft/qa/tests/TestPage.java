package mapsoft.qa.tests;

import mapsoft.qa.base.ExtJSDriver;
import mapsoft.qa.pages.ExtJSMainPage;
import mapsoft.qa.pages.ExtJSMenuPage;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

/**
 *  Created by alex on 04.01.2017..
 */
public class TestPage extends ExtJSDriver {

    ExtJSMenuPage menuPage;

    @Test
    public void test() throws InterruptedException {

        menuPage = new ExtJSMenuPage(getDriver());
        try {
            menuPage.start();
        } catch (NoSuchElementException ex){}
        menuPage.login();
        menuPage.MenuDictModal();
        menuPage.MenuDict();
    }
}
