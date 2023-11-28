package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	WebDriver driver;

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	// Elements
	@FindBy(name = "firstname")
	WebElement txtFirstname;

	@FindBy(name = "lastname")
	WebElement txtLastname;

	@FindBy(name = "email")
	WebElement txtEmail;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkdPolicy;

	@FindBy(id= "input-newsletter")
	WebElement radioYes;

	@FindBy(css = "button[type='submit']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	// Action Methods
	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastname.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void checkNewsletter() {
		radioYes.click();
	}

	public void setPrivacyPolicy() {
		chkdPolicy.click();
	}

	public void clickContinue() {
		btnContinue.click();
	}

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}
