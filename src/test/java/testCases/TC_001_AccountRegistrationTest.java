package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test
	void test_account_Registration() {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();

		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString() + "@gmail.com");
		regpage.setPassword(randomAlphaNumeric());
		regpage.checkNewsletter();
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		String confmsg = regpage.getConfirmationMsg();
		try {
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		} catch (Exception e) {
			Assert.fail();
		}

	}

}
