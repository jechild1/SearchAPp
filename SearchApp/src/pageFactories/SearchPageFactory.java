package pageFactories;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.AutomationHelper;

public class SearchPageFactory extends diSearchMenusPageFactory {

	public static String regexURL = BASE_URL;

	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page and
	 * instantiates the elements on the page.
	 */
	public SearchPageFactory() {
		super(regexURL);
		waitForPageToLoad();
	}

	@FindBy(xpath = "//input[@placeholder='What would you like to search?']")
	WebElement searchField;

	/**
	 * Sets the search text field with the passed in text.
	 * 
	 * @param searchText
	 */
	public void setSearchField(String searchText) {
		AutomationHelper.printMethodName();
		AutomationHelper.setTextField(searchField, searchText);
		
//		searchField.sendKeys(Keys.TAB);
//		
//		int counter = 1;
//		do {
//			if(!searchField.getText().equals(searchText)) {
//				AutomationHelper.waitSeconds(1);
//				System.out.println("Waiting on Serach Field " + counter);
//				counter ++;
//			}
//		}while (counter < 20);
//		
		
		
	}

	/**
	 * Reads the text that is currently in the search field.
	 * 
	 * @return String
	 */
	public String readSearchField() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getText(searchField);
	}

	@FindBy(xpath = "//span[@aria-label= 'search']")
	WebElement searchIcon;

	/**
	 * Clicks the search magnifying glass icon.
	 */
	public void clickSearchMagnifyingGlass() {
		searchIcon.click();
	}
	
	/**
	 * Hits the Enter key on the Search object
	 */
	public void hitEnter() {
		AutomationHelper.hitEnter(searchField);
	}

	/**
	 * Reads the value of the Company Name, e.g. Aretec
	 * 
	 * @return String
	 */
	public String readCompanyName() {
		AutomationHelper.printMethodName();
		WebElement h1Tag = driver.findElement(By.xpath("//h1[@class='search-title']"));
		return AutomationHelper.getText(h1Tag);
	}

	/**
	 * Reads the value of the Sub-Title on the search page.
	 * 
	 * @return
	 */
	public String readSubTitle() {
		AutomationHelper.printMethodName();
		WebElement h2Tag = driver.findElement(By.xpath("//h2[@class='search-sub-title']"));
		return AutomationHelper.getText(h2Tag);
	}
	
	

}
