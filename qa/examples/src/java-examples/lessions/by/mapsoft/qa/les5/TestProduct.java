package by.mapsoft.qa.les5;


import org.testng.annotations.Test;

/**
 * Created by Alex on 26.12.2016.
 */
public class TestProduct extends TestBase{

	@Test
	public void testProducts() {

		goLitecart();
		product = findProductsCampaigns().get(0);

		mainProduct = new ProductData();
		mainProduct.getDataMainProduct(product);

		testProduct = new ProductData();
        testProduct.fillTestData("main");
		mainProduct.checkMainProduct(testProduct);

		product.click();
		waitPageMenu();

		localProduct = new ProductData();
		localProduct.getDataLocalProduct();

		testProduct.fillTestData("local");
		localProduct.checkLocalToMainProduct(mainProduct);
		localProduct.checkLocalProduct(testProduct);
	}

	

}

