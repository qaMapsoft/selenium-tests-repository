package by.mapsoft.qa.les6;

import org.testng.annotations.Test;

/**
 * Created by Alex on 28.12.2016.
 */
public class TestAddNewUser extends TestBaseAll {
	private UserPage newUserPage;

	@Test
	public void testAddProducts() {

		goLiteCart();
		goAddNewAccount();
		newUserPage = new UserPage(driver);
		newUserPage.createNewUser().checkAddNewUser();
	}

}
