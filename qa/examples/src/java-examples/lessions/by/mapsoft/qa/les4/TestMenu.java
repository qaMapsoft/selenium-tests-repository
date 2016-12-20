package by.mapsoft.qa.les4;

import org.testng.annotations.Test;

/**
 * Created by Alex on 20.12.2016.
 */
public class TestMenu extends TestBase{
    @Test
    public void testMenu() {
        loginLitecart();

        menuCount = findMenu().size();
        if (menuCount != 0) {
            i = 0;
            while (i < menuCount) {
                findMenu().get(i).click();
                waitPage();
                titlePagePresent();
                submenuCount = findSubMenu().size();
                if (submenuCount != 0) {
                    j = 0;
                    while (j < submenuCount) {
                        findSubMenu().get(j).click();
                        waitPage();
                        titlePagePresent();
                        j++;
                    }

                }
                i++;
            }
        }
    }
}
