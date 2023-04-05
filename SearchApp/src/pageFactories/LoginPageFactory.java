package pageFactories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AutomationHelper;

public class LoginPageFactory extends SearchBase {

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page and
	 * instantiates the elements on the page.
	 */
	public LoginPageFactory() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Register_email")
	WebElement email;
	
	/**
	 * Set the Email field with the passed in text
	 */
	public void setEmail(String emailText) {
		AutomationHelper.printMethodName();
		AutomationHelper.setTextField(email, emailText);
	}
	
	/**
	 * Reads the text inside the email field
	 */
	public String readEmail() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getText(email);
	}
	
	@FindBy (id = "Register_password")
	WebElement password;
	
	/**
	 * Set the Password field with the passed in text
	 */
	public void setPassword(String password) {
		AutomationHelper.printMethodName();
		AutomationHelper.setTextField(this.password, password);
	}
	

	
	@FindBy(xpath = "//button/span[text()='Login']")
	WebElement loginButton;
	
	/**
	 * Clicks the login button
	 */
	public void clickLogin(){
		loginButton.click();
	}
}
