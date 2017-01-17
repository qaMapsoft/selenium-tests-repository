package mapsoft.qa.base;

import mapsoft.qa.pages.PageBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static mapsoft.qa.pages.PageBase.waitToBeClickable;
import static mapsoft.qa.pages.PageBase.waitpresenceOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;

/**
 * Created by agembitsky on 11.01.2017.
 */
public class ExtJSComponent {



    public static enum Xtype {
        NUMBERFIELD,
        BOX,
        DATEFIELD,
        BUTTON,
        BUTTONGROUP,
        COLORPALETTE,
        COMPONENT,
        CONTAINER,
        CYCLE,
        DATAVIEW,
        DATEPICKER,
        EDITOR,
        EDITORGRID,
        FLASH,
        GRID,
        LISTVIEW,
        PANEL,
        WINDOW,
        SPLITBUTTON,
        TABPANEL,
        TREEPANEL,
        VIEWPORT,
        TREEGRID,
        TEXTFIELD,
        TEXTAREA,
        COMBO,
        CHECKBOX,
        TRIGGER,
        RADIO,
        LABEL,
        MENU,
        SUPERBOXSELECT;
        public String getName() {
            return toString().toLowerCase();
        }
    }

    WebDriver driver;
    public ExtJSComponent(WebDriver driver){
    this.driver = driver;
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

    public WebElement getMainHeader(){
        return driver.findElement(By.xpath(".//*[@id='common-main_header']"));
    }
    public WebElement getMainBody(){
        return driver.findElement(By.xpath(".//*[@id='common-main-body']"));
    }
    public WebElement getMainNavigator(){
        return driver.findElement(By.xpath(".//*[contains(@id,'common-main-navigator')][contains(@class,'x-autowidth-table')]"));
    }
    public WebElement getMainDesktop(){
        return driver.findElement(By.xpath(".//*[@id='common-main-desktop']"));
    }
    public WebElement getHeader(WebElement element){
        return element.findElement(By.id("common-main_header"));
    }
    public WebElement getBody(WebElement element){
        return element.findElement(By.id("common-main-body"));
    }
    public WebElement getGridContainer(WebElement element){
        return element.findElement(By.id("x-grid-item-container"));
    }
    public List<WebElement> getMenuList(WebElement element) {
        return element.findElements(By.xpath(".//table[contains(@id,'treeview')][contains(@id,'record')]"));
    }

    public WebElement getMenuItemName(WebElement element, String name) {
        String findXpath = ".//*[contains(@class,'x-tree-icon-leaf')]/../../*[.='"+name+"']";
        waitpresenceOf(findXpath);
        return element.findElement(By.xpath(findXpath));
    }
    public WebElement getDictNameModal(String name) {
        String findXpath = ".//*[contains(@id,'"+name+"')]";
        waitpresenceOf(findXpath);
        return driver.findElement(By.xpath(findXpath));
    }
    public WebElement getDictName(String name) {
        String findXpath = ".//*[contains(@id,'header')]/*[contains(@id,'title')][.='"+name+"']/..";
        waitpresenceOf(findXpath);
        return driver.findElement(By.xpath(findXpath));
    }
    public WebElement getTabName(String dictName) {
        return driver.findElement(By.xpath(".//a[contains(@id,'common-main-tasktab')]"));
    }

    public List<WebElement> getTaskTabs(WebElement element) {
        return element.findElements(By.xpath(".//a[contains(@id,'common-main-tasktab')]"));
    }
    public WebElement getTaskTabName(String name) {
        String findXpath = ".//a[contains(@id,'common-main-tasktab')]/*[.='"+name+"']/../..";
        waitpresenceOf(findXpath);
        return driver.findElement(By.xpath(findXpath));
    }
    public WebElement getTaskTabActive(WebElement element) {
        return element.findElement(By.xpath(".//a[contains(@id,'common-main-tasktab')][contains(@class,'x-tab-active')]"));
    }


    public WebElement getButtonCloseWindow(WebElement element) {
        WebElement webElement = element.findElement(By.xpath(".//*[contains(@class,'x-tool-close')]"));
        waitToBeClickable(webElement);
        return webElement;
    }
    public WebElement getButtonCloseTab(WebElement element) {
        WebElement webElement = element.findElement(By.xpath(".//*[@class='x-tab-close-btn']"));
        waitToBeClickable(webElement);
        return webElement;
    }
    public WebElement getButtonMaxSizeWindow(WebElement element) {
        List<WebElement> window = element.findElements(By.xpath(".//*[contains(@class,'x-tool-maximize')]"));
        waitToBeClickable(window.get(0));
        return window.get(0);
    }



    public List<WebElement> getToolbar(WebElement element) {
        return element.findElements(By.xpath(".//a[contains(@id,'toolbar')]"));
    }

    public List<WebElement> getgrid(WebElement element) {
        return element.findElements(By.xpath(".//a[contains(@id,'grid')]"));
    }

    public List<WebElement> getPageToolbar(WebElement element) {
        return element.findElements(By.xpath(".//a[contains(@id,'pagingtoolbar')]"));
    }
    public List<WebElement> getButton(WebElement element, String name) {
        return element.findElements(By.xpath(".//a[contains(@id,'button')][.='"+name+"']"));
    }
    public List<WebElement> getButtonQtip(WebElement element, String name) {
        return element.findElements(By.xpath(".//a[contains(@id,'button')][@data-qtip='"+name+"']"));
    }
    public List<WebElement> getTextField(WebElement element) {
        return element.findElements(By.xpath(".//a[contains(@id,'textfield')]"));
    }
    public List<WebElement> getTextFieldName(WebElement element, String name) {
        return element.findElements(By.xpath(".//a[contains(@id,'textfield')][@name="+name+"]"));
    }

    public List<WebElement> getTextFieldLabel(WebElement element, String label) {
        return element.findElements(By.xpath(".//a[contains(@id,'textfield')]"));
    }
    public List<WebElement> getNumberFieldName(WebElement element, String name) {
        return element.findElements(By.xpath(".//a[contains(@id,'numberfield')][@name="+name+"]"));
    }
    public List<WebElement> getDateFieldName(WebElement element, String name) {
        return element.findElements(By.xpath(".//a[contains(@id,'datefield')][@name="+name+"]"));
    }
    public List<WebElement> getTextareaName(WebElement element, String name) {
        return element.findElements(By.xpath(".//textarea[@name="+name+"]"));
    }

    public List<WebElement> getCheckbox(WebElement element) {
        return element.findElements(By.xpath(".//a[contains(@id,'checkbox')]"));
    }

    public List<WebElement> getComboName(WebElement element, String name) {
        return element.findElements(By.xpath(".//a[contains(@id,'combo')][@name="+name+"]"));
    }


/// остальные элементы другими способами
    public WebElement getCombobox(){
        return driver.findElement(By.id(getId2Xpath("combobox",1)));
    }

    protected List<WebElement> getComboboxOptions(int i){

        List<WebElement> elem;
        elem =  driver.findElements(By.xpath(".//ul[li[contains(@class,'x-boundlist-item')]]"));
        return elem.get(i).findElements(By.xpath(".//li[contains(@class,'x-boundlist-item')]"));
    }
}
