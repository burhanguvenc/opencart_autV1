package testCases;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	void test_loginDDT(String email, String password) {

			logger.info("**** Starting TC_003_LoginDDT ******* ");
			HomePage hp = new HomePage(driver);

			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);

			lp.setEmail(email);
			lp.setPassword(rb.getString(password));
			lp.clickLogin();

			MyAccountPage mp = new MyAccountPage(driver);
			boolean targetpage = mp.isMyAccountExists();
	}
}
