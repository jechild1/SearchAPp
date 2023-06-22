package pageFactories;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

	}

	@FindBy(xpath = "//div[@class='flex-row display-flex header-title-div']/p[text()='Home']")
	WebElement homeLink;

	/**
	 * Clicks the <i>Home</i> link in the top menu.
	 */
	public void clickHomeTopLink() {
		AutomationHelper.printMethodName();
		homeLink.click();
	}

	/**
	 * Returns a boolean to if the <b>Home Link</b> is present.
	 * 
	 * @return boolean
	 */
	public boolean isHomeLinkPresent() {
		AutomationHelper.printMethodName();
		return isWebElementPresent("//div[@class='flex-row display-flex header-title-div']/p[text()='Home']");
	}

	@FindBy(xpath = "//div[@class='flex-row display-flex header-title-div']/p[text()='Documents']")
	WebElement documentsLinkTopMenu;

	/**
	 * Clicks the <i>Documents</i> link in the top menu.
	 */
	public void clickDocumentsTopLink() {
		AutomationHelper.printMethodName();
		documentsLinkTopMenu.click();
	}

	/**
	 * Returns a boolean to if the <b>Document(s)</b> is present. This is for the
	 * top link
	 * 
	 * @return boolean
	 */
	public boolean isDocumentsTopLinkPresent() {
		AutomationHelper.printMethodName();
		return isWebElementPresent("//div[@class='flex-row display-flex header-title-div']/p[text()='Documents']");
	}

	@FindBy(xpath = "//div[@class='flex-row display-flex header-title-div']/p[text()='About']")
	WebElement aboutLink;

	/**
	 * Clicks the <i>About</i> link in the top menu.
	 */
	public void clickAboutLink() {
		AutomationHelper.printMethodName();
		aboutLink.click();
	}

	/**
	 * Returns a boolean to if the <b>About</b> is present. This is for the top link
	 * 
	 * @return boolean
	 */
	public boolean isAboutLinkPresent() {
		AutomationHelper.printMethodName();
		return isWebElementPresent("//div[@class='flex-row display-flex header-title-div']/p[text()='About']");
	}

	// This is the icon of the person where the Settings and Logout are present
	// The OR in the xpath is because the object type changes inside the settings
	// menus.
//	@FindBy(xpath = "//p[@class='ant-dropdown-trigger header-title'][2] | //p[@class='ant-dropdown-trigger header-title active-header'] | //p[@class='ant-dropdown-trigger header-title ant-dropdown-open']")
	@FindBy(xpath = "//p[@class='ant-dropdown-trigger header-title'] | //p[@class='ant-dropdown-trigger header-title active-header'] | //p[@class='ant-dropdown-trigger header-title ant-dropdown-open']")
	WebElement profileMenu;

	/**
	 * Clicks the Profile Menu
	 */
	public void clickProfileMenu() {

		// We must see if the profile menu is already open before we click it.

		// Try to get a reference to the expanded menu
		// Wait for the Sub-menu to appear
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));

		// If this xpath is found, it means that the menu is already open and we will
		// not need to perform the click
		String subMenuContainerXpath = "//div[@class = 'ant-dropdown ant-dropdown-show-arrow ant-dropdown-placement-bottomRight']";
		List<WebElement> subMenuElements = driver.findElements(By.xpath(subMenuContainerXpath));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(NORMAL_TIMEOUT));

		// If there is a hidden menu found, the size will be 1, and this will evaluate
		// to true, and the click will happen in the IF statement.
		boolean clickNeeded = subMenuElements.size() > 0;

		// If click is NOT needed
		if (!clickNeeded) {
			profileMenu.click();
		}

	}

	/**
	 * Click the Settings menu
	 */
	public void clickSettings() {
		AutomationHelper.printMethodName();

		clickProfileMenu();

		// Wait for the Sub-menu to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SHORT_TIMEOUT));

		String settingsXpath = "//p[text()='Settings']";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(settingsXpath)));

		// Once the above menu is present, then we can click the sub menus.
		WebElement settingsLink = driver.findElement(By.xpath(settingsXpath));

		settingsLink.click();
	}

	/**
	 * Returns a boolean to if the <b>Settings</b> is present. This is for the top
	 * menu and under the person icon
	 * 
	 * @return boolean
	 */
	public boolean isSettingsLinkPresent() {
		AutomationHelper.printMethodName();

		clickProfileMenu();

		// Wait for the Sub-menu to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SHORT_TIMEOUT));

		String settingsXpath = "//p[text()='Settings']";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(settingsXpath)));

		return isWebElementPresent(settingsXpath);
	}

	/**
	 * Click the Logout menu
	 */
	public void clickLogout() {
		AutomationHelper.printMethodName();

		clickProfileMenu();

		// Wait for the Sub-menu to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SHORT_TIMEOUT));

		String logoutXpath = "//p[contains(text(),'Logout')]";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(logoutXpath)));

		// Once the above menu is present, then we can click the sub menus.
		WebElement logoutLink = driver.findElement(By.xpath(logoutXpath));

		logoutLink.click();
	}

	/**
	 * Returns a boolean to if the <b>Settings</b> is present. This is for the top
	 * menu and under the person icon
	 * 
	 * @return boolean
	 */
	public boolean isLogoutLinkPresent() {
		AutomationHelper.printMethodName();

		clickProfileMenu();

		// Wait for the Sub-menu to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SHORT_TIMEOUT));

		String logoutXpath = "//p[contains(text(),'Logout')]";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(logoutXpath)));

		return isWebElementPresent(logoutXpath);
	}

	/*
	 * The following methods check to see if the objects are present on a page for
	 * the left menu
	 * 
	 */
	public String xpathSearchResults = "//div[@class = 'search_result_top bdr_btm searchResult']";
	public String xpathEvaluationYearLink = "//span[text()='Evaluation year']";
	public String xpathDocumentsLink = "//span[text()='Document(s)']";
	public String xpathCategoryLink = "//span[text()='Category']";
	public String xpathDomainsLink = "//span[text()='Domain(s)']";
	public String xpathHistoryLink = "//span[text()='History']";

	/**
	 * Checks for the presence of the <b>Search Results</b> DIV.
	 * 
	 * @return boolean
	 */
	public boolean isSearchResultsPresent() {
		AutomationHelper.printMethodName();
		return isWebElementPresent(xpathSearchResults);
	}

	/**
	 * Checks for the presence of the <b>EVALUATION YEAR</b> DIV.
	 * 
	 * @return boolean
	 */
	public boolean isEvaluationYearPresent() {
		AutomationHelper.printMethodName();
		return isWebElementPresent(xpathEvaluationYearLink);
	}

	/**
	 * Clicks the <b>EVALUATION YEAR</b> left hand link to display the sub-objects
	 */
	public void clickEvaluationYear() {
		AutomationHelper.printMethodName();

		// The following xpath contains an expanded property (the two .. go up two
		// levels). We must pull attribute property
		String xpanderDiv = xpathEvaluationYearLink + "/../../div[@class='ant-collapse-header']";
		WebElement evaluationYear = driver.findElement(By.xpath(xpanderDiv));

		boolean expandProperty = Boolean.valueOf(evaluationYear.getAttribute("aria-expanded"));

		if (!expandProperty) {
			// Click the button
			WebElement evaluationYearLink = driver.findElement(By.xpath(xpathEvaluationYearLink));

			// Because elements consistently move as they're being expanded, we must move to
			// it as to not have click interceptions.
			moveToElement(evaluationYear);

			evaluationYearLink.click();
		}
	}

	/**
	 * Checks for the presence of the <b>Category</b> DIV.
	 * 
	 * @return boolean
	 */
	public boolean isCategoryPresent() {
		AutomationHelper.printMethodName();
		return isWebElementPresent(xpathCategoryLink);
	}

	/**
	 * Clicks the <b>Category</b> left hand link to display the sub-objects
	 */
	public void clickCategory() {
		AutomationHelper.printMethodName();

		// The following xpath contains an expanded property (the two .. go up two
		// levels). We must pull attribute property
		String xpanderDiv = xpathCategoryLink + "/../../div[@class='ant-collapse-header']";
		WebElement topics = driver.findElement(By.xpath(xpanderDiv));

		boolean expandProperty = Boolean.valueOf(topics.getAttribute("aria-expanded"));

		if (!expandProperty) {
			// Click the button
			WebElement categoryLink = driver.findElement(By.xpath(xpathCategoryLink));

			// Because elements consistently move as they're being expanded, we must move to
			// it as to not have click interceptions.
			moveToElement(categoryLink);

			categoryLink.click();
		}
	}

	private void moveToElement(WebElement elementToMoveTo) {
//		WebElement element = driver.findElement(By.id("header-account"));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementToMoveTo).click().build().perform();
	}

	/**
	 * Checks for the presence of the <b>DOCUMENTS(s)</b> DIV.
	 * 
	 * @return boolean
	 */
	public boolean isDocumentsPresent() {
		AutomationHelper.printMethodName();
		return isWebElementPresent(xpathDocumentsLink);
	}

	/**
	 * Clicks the <b>DOCUMENTS</b> left hand link to display the sub-objects
	 */
	public void clickDocuments() {
		AutomationHelper.printMethodName();

		// The following xpath contains an expanded property (the two .. go up two
		// levels). We must pull attribute property
		String xpanderDiv = xpathDocumentsLink + "/../../div[@class='ant-collapse-header']";
		WebElement documents = driver.findElement(By.xpath(xpanderDiv));

		boolean expandProperty = Boolean.valueOf(documents.getAttribute("aria-expanded"));

		if (!expandProperty) {
			// Click the button
			WebElement documentsLink = driver.findElement(By.xpath(xpathDocumentsLink));

			// Because elements consistently move as they're being expanded, we must move to
			// it as to not have click interceptions.
			moveToElement(documentsLink);

			documentsLink.click();
		}
	}

	/**
	 * Checks for the presence of the <b>DOMAINS(s)</b> DIV.
	 * 
	 * @return boolean
	 */
	public boolean isDomainsPresent() {
		AutomationHelper.printMethodName();
		return isWebElementPresent(xpathDomainsLink);
	}

	/**
	 * Clicks the <b>DOMAIN(S)</b> left hand link to display the sub-objects
	 */
	public void clickDomains() {
		AutomationHelper.printMethodName();

		// The following xpath contains an expanded property (the two .. go up two
		// levels). We must pull attribute property
		String xpanderDiv = xpathDomainsLink + "/../../div[@class='ant-collapse-header']";
		WebElement domains = driver.findElement(By.xpath(xpanderDiv));

		boolean expandProperty = Boolean.valueOf(domains.getAttribute("aria-expanded"));

		if (!expandProperty) {
			// Click the button
			WebElement domainsLink = driver.findElement(By.xpath(xpanderDiv));

//			// Because elements consistently move as they're being expanded, we must move to
//			// it as to not have click interceptions.
//			moveToElement(domainsLink);

			domainsLink.click();
		}
	}

	/**
	 * Checks for the presence of the <b>HISTORY</b> DIV.
	 * 
	 * @return boolean
	 */
	public boolean isHistoryPresent() {
		AutomationHelper.printMethodName();
		return isWebElementPresent(xpathHistoryLink);
	}

	/**
	 * Clicks the <b>HISTORY</b> left hand link to display the sub-objects
	 */
	public void clickHistory() {
		AutomationHelper.printMethodName();

		// The following xpath contains an expanded property (the two .. go up two
		// levels). We must pull attribute property
		String xpanderDiv = xpathHistoryLink + "/../../div[@class='ant-collapse-header']";
		WebElement domains = driver.findElement(By.xpath(xpanderDiv));

		boolean expandProperty = Boolean.valueOf(domains.getAttribute("aria-expanded"));

		if (!expandProperty) {
			// Click the button
			WebElement historyLink = driver.findElement(By.xpath(xpathHistoryLink));

			// Because elements consistently move as they're being expanded, we must move to
			// it as to not have click interceptions.
			moveToElement(historyLink);

			historyLink.click();
		}
	}

	/**
	 * Getter reference for Search Results objects
	 * 
	 * @return SearchResults
	 */
	public SearchResults getSearchResults() {
		return new SearchResults();
	}

	/**
	 * Class to handle the creation of Search Result objects. Note this has
	 * temporary been done away with.
	 * 
	 * @author Jesse Childress
	 *
	 */
	public class SearchResults {

		// Grabs the parent div for the search results to reduce scope
		WebElement parentSearchResultsDiv = driver
				.findElement(By.xpath("//div[@class = 'search_result_top bdr_btm searchResult']"));

		/**
		 * Reads the <b>Results</b> count from the Search Results section.
		 * 
		 * @return String
		 */
		public String readResults() {
			AutomationHelper.printMethodName();
			WebElement resultsText = parentSearchResultsDiv.findElement(By.xpath("//p[@class = 'search_res_p'][1]"));
			return AutomationHelper.getText(resultsText);
		}

		/**
		 * Reads the <b>Findings</b> count from the Search Results section.
		 * 
		 * @return String
		 */
		public String readFindings() {
			AutomationHelper.printMethodName();
			WebElement resultsText = parentSearchResultsDiv.findElement(By.xpath("//p[@class = 'search_res_p'][2]"));
			return AutomationHelper.getText(resultsText);
		}

		/**
		 * Reads the <b>Topics</b> count from the Search Results section.
		 * 
		 * @return String
		 */
		public String readTopics() {
			AutomationHelper.printMethodName();
			WebElement resultsText = parentSearchResultsDiv.findElement(By.xpath("//p[@class = 'search_res_p'][3]"));
			return AutomationHelper.getText(resultsText);
		}

		// Answer section
		/**
		 * Reads the <b>Answer</b> section of the search results.
		 * 
		 * @return String
		 */
		public String readAnswer() {
			AutomationHelper.printMethodName();

			WebElement answer = driver.findElement(By.xpath("//div[@class = 'content mgBt_10 bullet']"));

			return AutomationHelper.getText(answer);
		}

		String xpath = "//span[text()='Reference(s)']";

		/**
		 * Clicks the <b>Open References</b> button on the Search Results page. Note: If
		 * the References window is already open, nothing happens.
		 */
		public void clickOpenReferences() {
			AutomationHelper.printMethodName();

			// If open references is NOT open, then click it
			// This is an WebElement to the grandparent, which is a div that has properties
			// to show if it is expanded.

			WebElement expanderDiv = driver.findElement(By.xpath("//span[text()='Reference(s)']/../div/../div"));

			boolean expandProperty = Boolean.valueOf(expanderDiv.getAttribute("aria-expanded"));

			if (!expandProperty) {
				// Click the button
				WebElement references = driver.findElement(By.xpath(xpath));
				references.click();
			}

		}

		public String readReferences() {
			AutomationHelper.printMethodName();
			clickOpenReferences();
			return "";
		}

	}

	/**
	 * Getter reference for Domain objects in the left hand menu.
	 * 
	 * @return SearchResults
	 */
	public Domains getDomains() {
		return new Domains();
	}

	/**
	 * Class to handle objects in the Domain(s) left hand menu of a given page.
	 * 
	 * @author Jesse Childress
	 *
	 */
	public class Domains {
		
		
		/**
		 * Method to check for the visible presence of the Domain(s) pop out. If the
		 * "Add Domain(s)" button was clicked, this menu should appear.
		 * 
		 * @return boolean
		 */
		private boolean isDomainMenuVisible() {

			// Adjust Timeout Temporarily
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));

			List<WebElement> domainMenu = driver.findElements(By.xpath("//div[@class = 'ant-popover-inner-content']"));

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(NORMAL_TIMEOUT));

			if (domainMenu.size() > 0) {
				return true;
			} else {
				return false;
			}

		}

		/**
		 * Returns a list of Domains from the Domain list. Only prints to the console.
		 * Note: Only returns top level domains and not sub-domains.
		 * 
		 */
		public void readDomainList() {

			// First, click the Domain(s) button
			clickDomains();

			String xpath = "//div[@class='ant-popover ant-popover-placement-bottomLeft ']//span[@class = 'ant-tree-title']";

			List<WebElement> domainList = driver.findElements(By.xpath(xpath));

			for (WebElement currentListItem : domainList) {
				System.out.println(currentListItem.getText());
			}

		}

		/**
		 * Method to select the domains / sub-domains that are needed in the search.
		 * This method takes a String or String array. Note: Case must be correct
		 * 
		 * @param domains
		 */
		public void selectDomain(String... domains) {

			AutomationHelper.printMethodName();

			clickDomains();

			// First, open all of the closed domains
			openClosedDomains();

			// Second, uncheck ALL domains. This is necessary to get a clean slate.
			// Find a list of checked domains

			// Find the Domains Menu - Used to reduce scope.
			WebElement domainMenu = driver.findElement(By.xpath("//div[@class = 'ant-tree-list-holder-inner']"));

			// Find all of the elements that are currently checked. This is surrounded by
			// time managers as to reduce wait time.
			long startTime = System.nanoTime();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

			List<WebElement> checkedDomains = domainMenu
					.findElements(By.xpath("//span[@class = 'ant-tree-checkbox ant-tree-checkbox-checked']"));

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(NORMAL_TIMEOUT));

			long endTime = System.nanoTime();
			System.out.println("Select Domain > Finding Checked Domains took: "
					+ TimeUnit.SECONDS.convert(Duration.ofNanos(endTime - startTime)));

			// Loop through all of the checked domains and click them to uncheck them. The
			// wait allows time for object to adjust as to not have misplaced clicks.
			for (WebElement currentCheckedDomain : checkedDomains) {
				currentCheckedDomain.click();
				AutomationHelper.waitMillis(50);
			}

			// Take in the passed domain string and cycle through, selecting each
			// one.
			for (String currentDomain : domains) {

				// Build the xpath of the current checkbox, based on the passed in string
				String domainXpath = "//span[text()= '" + currentDomain
						+ "']/ancestor::div/span[@class = 'ant-tree-checkbox']";

				// Grab a WebElement of the checkbox
				WebElement currentCheckBox = driver.findElement(By.xpath(domainXpath));

				// Check the checkbox
				currentCheckBox.click();
			}

		}

		/**
		 * Method to unselect the passed in Domain values. The passed in text is case
		 * sensitive. This method will accept a string or a string array or items to
		 * unselect. Note: Case must be correct
		 * 
		 * @param domains
		 */
		public void unselectDomain(String... domains) {

			clickDomains();

			// First, open all of the closed domains
			openClosedDomains();

			// Second, uncheck ALL domains. This is necessary to get a clean slate.
			// Find a list of checked domains
			List<WebElement> checkedDomains = driver.findElements(
					By.xpath("//span[@class = 'ant-tree-checkbox ant-tree-checkbox-checked']/following-sibling::span"));

			// Cycle through the list of check domains. If the domain text matches what is
			// in the domains String[], uncheck it
			for (WebElement currentCheckedDomain : checkedDomains) {

				String domainText = currentCheckedDomain.getText().trim();

				for (String currentDomainText : domains) {

					if (currentDomainText.equals(domainText)) {
						currentCheckedDomain.click();
					}
				}

			}

		}
		
		/**
		 * Method to unselect all currently selected domains
		 */
		public void unselectAllDomains() {
			
			clickDomains();

			// First, open all of the closed domains
			openClosedDomains();

			// Second, uncheck ALL domains. This is necessary to get a clean slate.
			// Find a list of checked domains
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
			List<WebElement> checkedDomains = driver.findElements(
					By.xpath("//span[@class = 'ant-tree-checkbox ant-tree-checkbox-checked']/following-sibling::span"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(NORMAL_TIMEOUT));

			for(WebElement currentCheckedDomain : checkedDomains) {
				currentCheckedDomain.click();
				AutomationHelper.waitMillis(100);
			}
			
		}

		@FindBy(xpath = "//button[@class='ant-btn ant-btn-default ant-btn-lg upl_btn_icon']")
		WebElement uploadDocumentsButton;

		/**
		 * Clicks the <b>Upload Documents</b> button.
		 */
		public void clickUploadDocuments() {
			AutomationHelper.printMethodName();
			uploadDocumentsButton.click();
		}

		/**
		 * Utility method to open all of the Closed Domains. This means clicking the
		 * triangle to expand the list. This needs to happen because until the list is
		 * expanded, the object properties are not predictable.
		 */
		private void openClosedDomains() {

			AutomationHelper.printMethodName();

			//Adjust time outs 

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

			//Grab a list of all of the triangle expanders
			List<WebElement> closedDomainGroups = driver
					.findElements(By.xpath("//span[@class = 'ant-tree-switcher ant-tree-switcher_close']"));
				
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(NORMAL_TIMEOUT));

			for (WebElement currentDomainGroup : closedDomainGroups) {

				//TODO - Click interception can happen here.
				currentDomainGroup.click();

				AutomationHelper.waitMillis(300);

			}

		}
		
		/**
		 * Clicks the Search Domains button in the left hand menu. Note: Will wait for the page to load.
		 */
		public void clickSearchDomains() {
			AutomationHelper.printMethodName();
			
			WebElement searchButton = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary']"));
			
			searchButton.click();
			waitForPageToLoad();
		}
		
		
		
		
		
		
		
		
		

	}
}
