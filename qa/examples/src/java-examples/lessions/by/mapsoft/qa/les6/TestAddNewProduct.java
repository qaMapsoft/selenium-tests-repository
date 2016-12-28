package by.mapsoft.qa.les6;

import org.testng.annotations.Test;
/**
 * Created by Alex on 28.12.2016.
 */
public class TestAddNewProduct extends TestBaseAll {
	private ProductPage newProductPage;

	@Test
	public void testAddProducts() {

		loginLitecart();
		goMenu("Catalog");
		goAddNewProduct();
		newProductPage = new ProductPage(driver);
		newProductPage.createNewProduct();
		newProductPage.checkAddNewProduct();
	}

}
