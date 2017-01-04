package by.mapsoft.qa.les6;

import org.testng.annotations.Test;

/**
 * Created by Alex on 28.12.2016.
 */
public class TestAddNewUser extends DriverInst {
	private UserPage newUserPage;

	@Test
	public void testAddUsers() throws InterruptedException {

		newUserPage = new UserPage(getDriver());
		newUserPage.goLiteCart();
		newUserPage.goAddNewAccount();
		newUserPage.createNewUser();
		newUserPage.checkAddNewUser();
	}

}
