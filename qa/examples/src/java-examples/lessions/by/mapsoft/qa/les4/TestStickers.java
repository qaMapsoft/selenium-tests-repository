package by.mapsoft.qa.les4;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

/**
 * Created by on 20.12.2016.
 */
public class TestStickers extends TestBaseLes4 {
    WebElement product;

    @Test
    public void testComents() {

        litecart();
        products = findProducts();
        productCount = products.size();
        i = 0;
        while (i < productCount) {
            product = products.get(i);
            Assert.assertEquals(findStickers(product).size(), 1);
            i++;
        }
    }
}
