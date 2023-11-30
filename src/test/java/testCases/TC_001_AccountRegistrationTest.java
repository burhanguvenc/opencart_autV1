package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Regression","Master"})
	void test_account_Registration() {

		try {
			logger.debug("Application Logs .........");
			logger.info("***    Starting TC_001_AccountRegistrationTest    ****");
			HomePage hp = new HomePage(driver);

			hp.clickMyAccount();
			logger.info("Clicked on my account link");

			hp.clickRegister();
			logger.info("Clicked on register link");


			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			logger.info("Providing customer data");


			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());
			regpage.setEmail(randomString() + "@gmail.com");
			regpage.setPassword(randomAlphaNumeric());
			regpage.checkNewsletter();
			regpage.setPrivacyPolicy();
			regpage.clickContinue();

			logger.info("Clicked on continue");


			String confmsg = regpage.getConfirmationMsg();

			logger.info("Validating expected message");
			Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Test failed");
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("***    Finished TC_001_AccountRegistrationTest    ****");
	}

}
