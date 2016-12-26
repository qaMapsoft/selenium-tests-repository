package by.mapsoft.qa.les5;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProductData extends TestBase{
    public String name, price, priceSale;
    public String priceFontSize, priceFontText, priceFontColor;
    public String priceSaleFontSize, priceSaleFontType, priceSaleFontColor;

	public void getDataMainProduct(WebElement product) {	
		name = findProductName(product).getText();
		price = findProductPrice(product).getText();
		priceFontSize = findProductPrice(product).getCssValue("font-size");
		priceFontText = findProductPrice(product).getCssValue("text-decoration-line");
		priceFontColor = findProductPrice(product).getCssValue("color");
		priceSale = findProductPriceSale(product).getText();
		priceSaleFontSize = findProductPriceSale(product).getCssValue("font-size");
		priceSaleFontType = findProductPriceSale(product).getCssValue("font-weight");            
		priceSaleFontColor = findProductPriceSale(product).getCssValue("color");
	}

	public void getDataLocalProduct() {
		name = findLocalProductName().getText();
		price = findLocalProductPrice().getText();
		priceSale = findLocalProductPriceSale().getText();
		priceFontSize = findLocalProductPrice().getCssValue("font-size");
		priceFontText = findLocalProductPrice().getCssValue("text-decoration-line");
		priceFontColor =findLocalProductPrice().getCssValue("color");
		priceSaleFontSize = findLocalProductPriceSale().getCssValue("font-size");
		priceSaleFontType = findLocalProductPriceSale().getCssValue("font-weight");            
		priceSaleFontColor = findLocalProductPriceSale().getCssValue("color");
	}

	public void fillTestData(String type) {
		if (type == "main") {
			priceFontSize = "14.4px";
			priceFontText = "line-through";
			priceFontColor = "rgba(119, 119, 119, 1)";
			priceSaleFontSize = "18px";
			priceSaleFontType = "bold";
			priceSaleFontColor = "rgba(204, 0, 0, 1)";
		}
		if (type == "local") {
			priceFontSize = "16px";
			priceFontText = "line-through";
			priceFontColor = "rgba(102, 102, 102, 1)";
			priceSaleFontSize = "22px";
			priceSaleFontType = "bold";
			priceSaleFontColor = "rgba(204, 0, 0, 1)";
		}
	}
	public void checkMainProduct(ProductData exceptedProduct) {
		Assert.assertEquals(priceFontSize, exceptedProduct.priceFontSize, "priceFontSize failed: "+priceFontSize);
		Assert.assertEquals(priceFontText, exceptedProduct.priceFontText,"productPriceFontText failed: "+priceFontText);
		Assert.assertEquals(priceFontColor, exceptedProduct.priceFontColor,"productPriceFontColor failed: "+priceFontColor);
		Assert.assertEquals(priceSaleFontSize, exceptedProduct.priceSaleFontSize,"priceSaleFontSize failed: "+priceSaleFontSize);
		Assert.assertEquals(priceSaleFontType, exceptedProduct.priceSaleFontType,"productpriceSaleFontType failed: "+priceSaleFontType);
		Assert.assertEquals(priceSaleFontColor, exceptedProduct.priceSaleFontColor,"priceSaleFontColor failed: "+priceSaleFontColor);
	}

	public void checkLocalToMainProduct(ProductData exceptedProduct) {
		Assert.assertEquals(name,exceptedProduct.name,"productName failed: "+name);
		Assert.assertEquals(price,exceptedProduct.price,"productPrice failed: "+price);
		Assert.assertEquals(priceSale,exceptedProduct.priceSale,"productPriceDiscount failed: "+priceSale);
	}

	public void checkLocalProduct(ProductData exceptedProduct) {
		Assert.assertEquals(priceFontSize, exceptedProduct.priceFontSize, "priceFontSize failed: "+priceFontSize);
		Assert.assertEquals(priceFontText,exceptedProduct.priceFontText,"productPriceFontText failed: "+priceFontText);
		Assert.assertEquals(priceFontColor,exceptedProduct.priceFontColor,"productPriceFontColor failed: "+priceFontColor);
		Assert.assertEquals(priceSaleFontSize,exceptedProduct.priceSaleFontSize,"priceSaleFontSize failed: "+priceSaleFontSize);
		Assert.assertEquals(priceSaleFontType,exceptedProduct.priceSaleFontType,"productPriceSaleFontType failed: "+priceSaleFontType);
		Assert.assertEquals(priceSaleFontColor,exceptedProduct.priceSaleFontColor,"priceSaleFontColor failed: "+priceSaleFontColor);
	}
}
