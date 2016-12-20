package by.mapsoft.qa.les4;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

/**
 * Created by on 20.12.2016.
 */
public class TestStickers extends TestBase {
    WebElement product;

    @Test
    public void testComents() {

        productCount = findProduct().size();
        i = 0;
        while (i < productCount) {
            product = findProduct().get(i);
            Assert.assertEquals(findStickers(product).size(), 1);
            i++;
        }
    }
}
