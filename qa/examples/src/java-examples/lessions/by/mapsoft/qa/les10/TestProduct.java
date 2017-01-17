package by.mapsoft.qa.les10;

import org.testng.annotations.Test;

/**
 * Created by Alex on 17.01.2017
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
