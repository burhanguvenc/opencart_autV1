package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002_LoginTest extends BaseClass {

	@Test(groups= {"Sanity","Master"})
	public void test_login() {

		try {
			logger.info("**** Starting TC_002_LoginTest ******* ");
			HomePage hp = new HomePage(driver);

			hp.clickMyAccount();
			logger.info("**** Clicked on My Account ******* ");

			hp.clickLogin();
			logger.info("**** Clicked on Login ******* ");

			LoginPage lp = new LoginPage(driver);
			logger.info("**** Providing Login Details ******* ");
			lp.setEmail(rb.getString("email"));
			lp.setPassword(rb.getString("password"));

			lp.clickLogin();
			logger.info("**** Clicked on Login Button ******* ");

			MyAccountPage mp = new MyAccountPage(driver);
			boolean targetpage = mp.isMyAccountExists();
			Assert.assertEquals(targetpage, true, "Invalid login data");
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail();
			logger.info("Test failed");

		}

		logger.info("**** Finished TC_002_LoginTest *******");

	}

}
