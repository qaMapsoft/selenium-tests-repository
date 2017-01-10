package by.mapsoft.qa.les8;

import org.testng.annotations.Test;

/**
 *  Created by alex on 04.01.2017..
 */
public class TestMenu extends DriverNewBase {
    private MenuPage newMenuPage;

    @Test
    public void testMenuWindow() throws InterruptedException {

        newMenuPage = new MenuPage(getDriver());
        newMenuPage.goCountry();

        for(int i=0; i<newMenuPage.getCountExternalLink(); i++) {
            newMenuPage.goExternalLink(i);
        }

    }

}
