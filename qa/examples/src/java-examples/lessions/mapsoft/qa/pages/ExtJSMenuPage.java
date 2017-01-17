package mapsoft.qa.pages;

import mapsoft.qa.base.ExtJSComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by agembitsky on 11.01.2017.
 */
public class ExtJSMenuPage extends ExtJSMainPage {
    public WebDriver driver;
    public ExtJSComponent component;

    public ExtJSMenuPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        component = new ExtJSComponent(driver);
    }

    public void MenuDictModal() {
        openMenuItemModal("Страны");
        closeWindowModal("map-common-countries");

        openMenuItemModal("Адреса");
        closeWindowModal("map-common-addresses");
/*
        openMenuItem("Категории организаций");
        closeWindowModal("map-common-organizationkinds");
*/
        openMenuItemModal("Типы населенных пунктов");
        closeWindowModal("map-common-addressplacetypes");

        openMenuItemModal("Типы улиц");
        closeWindowModal("map-common-addressstreettypes");

        openMenuItemModal("Типы участков");
        closeWindowModal("med-common-sectortypes");

        openMenuItemModal("Районы");
        closeWindowModal("ed-common-districts");

        openMenuItemModal("Профессии");
        closeWindowModal("med-common-professions");
    }

    public void MenuDict() {
        String name;
        name = "Организации";
        dictOpenMaxClose(name);
        name = "Отделения";
        dictOpenMaxClose(name);
        name = "Поликлиники";
        dictOpenMaxClose(name);
        name = "Врачи";
        dictOpenMaxClose(name);
    }

    public void dictOpenMaxClose(String name){
        openMenuItem(name);
        maxSizeWindow(name);
        closeWindow(name);

    }

    public void openMenuItemModal(String itemName) {
        getBaseElement();
        WebElement menu = component.getMenuItemName(mainNavigator, itemName);
        menu.click();
    }

    public void closeWindowModal(String dictName) {
        WebElement dictForm = component.getDictNameModal(dictName);
        WebElement closeButton = component.getButtonCloseWindow(dictForm);
        closeButton.click();
        waitstalenessOf(closeButton);

    }

    public void openMenuItem(String itemName) {
        getBaseElement();
        WebElement menu = component.getMenuItemName(mainNavigator, itemName);
        menu.click();

    }
    public void maxSizeWindow(String dictName) {
        WebElement dictForm = component.getDictName(dictName);
        WebElement maxSizeWindowButton = component.getButtonMaxSizeWindow(dictForm);
        maxSizeWindowButton.click();
    }
    public void closeWindow(String dictName) {
        WebElement tabForm = component.getTaskTabName(dictName);
        WebElement closeButton = component.getButtonCloseTab(tabForm);
        closeButton.click();
        waitstalenessOf(closeButton);
    }
}
