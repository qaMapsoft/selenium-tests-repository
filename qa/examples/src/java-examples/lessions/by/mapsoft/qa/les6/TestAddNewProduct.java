package by.mapsoft.qa.les6;

import org.testng.annotations.Test;
/**
 * Created by Alex on 28.12.2016.
 */
public class TestAddNewProduct extends DriverInst {
	private ProductPage newProductPage;

	@Test
	public void testAddProducts() {
		newProductPage = new ProductPage(getDriver());
		newProductPage.loginLitecart();
		newProductPage.goMenu("Catalog");
		newProductPage.goAddNewProduct();
		newProductPage.createNewProduct();
		newProductPage.checkAddNewProduct();
	}

}
