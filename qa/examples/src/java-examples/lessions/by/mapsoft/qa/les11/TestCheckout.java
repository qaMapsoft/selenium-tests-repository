package by.mapsoft.qa.les11;

import org.testng.annotations.Test;

/**
 *  Created by alex on 20.01.2017..
 */
public class TestCheckout extends DriverBase {
    private CheckoutPage newCheckoutPage;
    private MainPage newMainPage;
    private ProductPage newProductPage;

    @Test
    public void testCart() throws InterruptedException {

        newMainPage = new MainPage(getDriver());
        newProductPage = new ProductPage(getDriver());
        newCheckoutPage = new CheckoutPage(getDriver());

        for (int i = 0; i < 3; i++) {
            newMainPage.goLiteCart();
            newMainPage.selectProduct(i);
            newProductPage.addNewProductCheckout(i);
        }
        newMainPage.goCheckOut();
        newCheckoutPage.deleteProductsCart();

    }

}
