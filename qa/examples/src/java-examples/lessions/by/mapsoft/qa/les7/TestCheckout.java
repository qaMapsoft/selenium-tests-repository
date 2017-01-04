package by.mapsoft.qa.les7;

import org.testng.annotations.Test;

/**
 * Created by agembitsky on 04.01.2017.
 */
public class TestCheckout extends DriverBase {
    private CheckoutPage newCheckoutPage;

    @Test
    public void testCart() throws InterruptedException {

        newCheckoutPage = new CheckoutPage(getDriver());
        newCheckoutPage.goLiteCart();
        for(int i=0; i<3; i++) {
            newCheckoutPage.addNewProductCheckout(i);
        }
        newCheckoutPage.goCheckOut();
        newCheckoutPage.deleteProductsCart();

    }

}
