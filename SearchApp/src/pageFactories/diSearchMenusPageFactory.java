package pageFactories;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import utilities.AutomationHelper;

/**
 * All pages with menus should extend this page. This allows access to methods
 * that allow the user to interact with menus.
 * 
 * @author jesse.childress
 *
 */
public abstract class diSearchMenusPageFactory extends diSearchBase {

	/**
	 * Constructor
	 * <p>
	 * Initializes elements on the page and then waits for the page to load. Asserts
	 * that it has loaded prior to proceeding.
	 * 
	 * @param regexURL
	 */
	public diSearchMenusPageFactory(String regexURL) {
		
		waitForPageToLoad();

		// Because each page factory extends this, we can initialize the elements here.
		PageFactory.initElements(driver, this);

		// Waits for a specified amount of time until the URL matches. After timeout,
		// assertion happens.
		new WebDriverWait(driver, Duration.ofSeconds(NORMAL_TIMEOUT)).until(ExpectedConditions.urlMatches(regexURL));

		
		Reporter.log("Expected URL: " + regexURL, true);
		Reporter.log("Current URL : " + this.getCurrentUrl(), true);
		

		assertTrue(this.getCurrentUrl().matches(regexURL), "Validate URL Changed to " + regexURL);
		
		}
	
	
	
	
	@FindBy (xpath = "//div[@class='flex-row display-flex header-title-div']/p[text()='Home']")
	WebElement homeLink;
	
	/**
	 * Clicks the <i>Home</i> link in the top menu.
	 */
	public void clickHomeTopLink() {
		AutomationHelper.printMethodName();
		homeLink.click();
	}
	
	@FindBy (xpath = "//div[@class='flex-row display-flex header-title-div']/p[text()='Documents']")
	WebElement documentsLinkTopMenu;
	
	/**
	 * Clicks the <i>Documents</i> link in the top menu.
	 */
	public void clickDocumentsTopLink() {
		AutomationHelper.printMethodName();
		documentsLinkTopMenu.click();
	}
	
	@FindBy (xpath = "//div[@class='flex-row display-flex header-title-div']/p[text()='About']")
	WebElement aboutLink;
	
	/**
	 * Clicks the <i>About</i> link in the top menu.
	 */
	public void clickAboutLink() {
		AutomationHelper.printMethodName();
		aboutLink.click();
	}
	
	//This is the icon of the person where the Settings and Logout are present
	@FindBy (xpath = "//p[@class='ant-dropdown-trigger header-title']")
	WebElement settingsMenu;
	
	/**
	 * Click the Settings menu
	 */
	public void clickSettings() {
		AutomationHelper.printMethodName();
		
		settingsMenu.click();
		
		//Wait for the Sub-menu to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SHORT_TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-dropdown ant-dropdown-show-arrow ant-dropdown-placement-bottomRight']")));
		
		//Once the above menu is present, then we can click the sub menus.
		
		WebElement settingsLink = driver.findElement(By.xpath("//div[@class='ant-dropdown ant-dropdown-show-arrow ant-dropdown-placement-bottomRight']//p[text() = 'Settings']"));
		
		settingsLink.click();
	}
}
