package by.mapsoft.qa.les10;

import org.testng.annotations.Test;

/**
 * Created by Alex on 28.12.2016.
 */
public class TestProduct extends DriverInst {
	private ProductPage newProductPage;

	@Test
	public void testProducts() {
		newProductPage = new ProductPage(getDriver());
		newProductPage.loginLitecart();
		newProductPage.goMenu("Catalog");
		newProductPage.goCategory("Rubber Ducks");
		newProductPage.goProducts();



	}

}
