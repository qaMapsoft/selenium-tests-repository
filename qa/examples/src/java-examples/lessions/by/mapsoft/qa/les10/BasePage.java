package by.mapsoft.qa.les10;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by agembitsky on 03.01.2017.
 */
public class BasePage {

    protected void loginLitecart() {
        DriverInst.getDriver().manage().deleteAllCookies();
        DriverInst.getDriver().get("http://localhost:7080/litecart/admin");
        waitPageLogin();
        DriverInst.getDriver().findElement(By.name("username")).sendKeys("admin");
        DriverInst.getDriver().findElement(By.name("password")).sendKeys("admin");
        DriverInst.getDriver().findElement(By.name("login")).click();
        waitPageAdmin();
    }

    protected void waitPageMain() {
        WebDriverWait wait = new WebDriverWait(DriverInst.getDriver(), 10);
        wait.until(presenceOfElementLocated(By.cssSelector("div#copyright")));
    }

    protected void waitPageLogin() {
        WebDriverWait wait = new WebDriverWait(DriverInst.getDriver(), 10);
        wait.until(presenceOfElementLocated(By.cssSelector("div#box-login")));
    }

    protected void waitPageAdmin() {
        WebDriverWait wait = new WebDriverWait(DriverInst.getDriver(), 10);
        wait.until(presenceOfElementLocated(By.cssSelector("#platform")));
    }

    protected void waitPageMenu() {
        WebDriverWait wait = new WebDriverWait(DriverInst.getDriver(), 10);
        wait.until(presenceOfElementLocated(By.xpath("//h1")));
    }

    protected void waitRows() {
        WebDriverWait wait = new WebDriverWait(DriverInst.getDriver(), 10);
        wait.until(presenceOfElementLocated(By.xpath(".//*[@id='content']/form/table/tbody/tr/td/a")));
    }

    protected void waitTab(String tab) {
        WebDriverWait wait = new WebDriverWait(DriverInst.getDriver(), 10);
        wait.until(presenceOfElementLocated(By.xpath(".//form/div/ul/li/a [.='" + tab + "']")));
    }

    public void waitButtonCancel() {
        WebDriverWait wait = new WebDriverWait(DriverInst.getDriver(), 10);
        wait.until(presenceOfElementLocated(By.xpath(".//*[@id='content']/form/p/span/button[2]")));

    }

    protected void goLiteCart() {
        DriverInst.getDriver().manage().deleteAllCookies();
        DriverInst.getDriver().get("http://localhost:7080/litecart");
        waitPageMain();
    }

    protected void goMenu(String menu) {
        DriverInst.getDriver().findElement(By.xpath(".//*[@id='app-']/a/span[contains(text(),'" + menu + "')]")).click();
        waitPageMenu();
    }

    protected void goTab(String tab) {
        DriverInst.getDriver().findElement(By.xpath(".//form/div/ul/li/a [.='" + tab + "']")).click();
        waitTab(tab);
    }

    protected void goAddNewProduct() {
        DriverInst.getDriver().findElement(By.xpath(".//*[@id='content']/div[1]/a[2]")).click();
        waitPageMenu();
    }

    public void goAddNewAccount() {
        DriverInst.getDriver().findElement(By.xpath(".//a[.='New customers click here']")).click();
        waitPageMenu();
    }

    protected boolean isLogoutPresent() {
        try {
            DriverInst.getDriver().findElement(By.xpath(".//a[.='Logout']"));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    protected boolean isErrorMessagePresent() {
        try {
            DriverInst.getDriver().findElement(By.xpath(".//*[@id='notices']/div"));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
