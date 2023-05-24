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

//		assertTrue(this.getCurrentUrl().matches(regexURL), "Validate URL Changed to " + regexURL);

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

	@FindBy(xpath = "//div[@class='flex-row display-flex header-title-div']/p[text()='Documents']")
	WebElement documentsLinkTopMenu;

	/**
	 * Clicks the <i>Documents</i> link in the top menu.
	 */
	public void clickDocumentsTopLink() {
		AutomationHelper.printMethodName();
		documentsLinkTopMenu.click();
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

	// This is the icon of the person where the Settings and Logout are present
	// The OR in the xpath is because the object type changes inside the settings
	// menus.
	@FindBy(xpath = "//p[@class='ant-dropdown-trigger header-title'] | //p[@class='ant-dropdown-trigger header-title active-header']")
	WebElement settingsMenu;

	/**
	 * Click the Settings menu
	 */
	public void clickSettings() {
		AutomationHelper.printMethodName();

		settingsMenu.click();

		// Wait for the Sub-menu to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SHORT_TIMEOUT));

		String settingsXpath = "//p[text()='Settings']";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(settingsXpath)));

		// Once the above menu is present, then we can click the sub menus.
		WebElement settingsLink = driver.findElement(By.xpath(settingsXpath));

		settingsLink.click();
	}

	/**
	 * Click the Logout menu
	 */
	public void clickLogout() {
		AutomationHelper.printMethodName();

		settingsMenu.click();

		// Wait for the Sub-menu to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SHORT_TIMEOUT));

		String logoutXpath = "//p[contains(text(),'Logout')]";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(logoutXpath)));

		// Once the above menu is present, then we can click the sub menus.
		WebElement logoutLink = driver.findElement(By.xpath(logoutXpath));

		logoutLink.click();
	}

	/*
	 * The following methods check to see if the objects are present on a page for
	 * the left menu
	 * 
	 */
	public String xpathSearchResults = "//div[@class = 'search_result_top bdr_btm searchResult']";
	public String xpathEvaluationYearLink = "//span[text()='EVALUATION YEAR']";
	public String xpathTopicsLink = "//span[text()='TOPIC(s)']";
	public String xpathDocumentsLink = "//span[text()='DOCUMENT(s)']";
	public String xpathDomainsLink = "//span[text()='DOMAIN(s)']";
	public String xpathHistoryLink = "//span[text()='HISTORY']";

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
			evaluationYearLink.click();
		}
	}

	/**
	 * Checks for the presence of the <b>TOPIC(s)</b> DIV.
	 * 
	 * @return boolean
	 */
	public boolean isTopicsPresent() {
		AutomationHelper.printMethodName();
		return isWebElementPresent(xpathTopicsLink);
	}
	
	/**
	 * Clicks the <b>TOPICS</b> left hand link to display the sub-objects
	 */
	public void clickTopics() {
		AutomationHelper.printMethodName();

		// The following xpath contains an expanded property (the two .. go up two
		// levels). We must pull attribute property
		String xpanderDiv = xpathTopicsLink + "/../../div[@class='ant-collapse-header']";
		WebElement topics = driver.findElement(By.xpath(xpanderDiv));

		boolean expandProperty = Boolean.valueOf(topics.getAttribute("aria-expanded"));

		if (!expandProperty) {
			// Click the button
			WebElement topicsLink = driver.findElement(By.xpath(xpathTopicsLink));
			topicsLink.click();
		}
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
			WebElement domainsLink = driver.findElement(By.xpath(xpathDomainsLink));
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
			historyLink.click();
		}
	}

	/**
	 * Private utility method that checks for the presence of a WebElement by a
	 * passed in XPATH.
	 * 
	 * @param xPath
	 * @return
	 */
	private boolean isWebElementPresent(String xPath) {

//		Long startTime = System.currentTimeMillis();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		boolean isElementPresent = driver.findElements(By.xpath(xPath)).size() > 0;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(NORMAL_TIMEOUT));
//		Long endTime = System.currentTimeMillis();

		// System.out.println("Time for check for xpath " + xPath + ": " + (endTime -
		// startTime) / 1000);

		return isElementPresent;
	}

	public SearchResults getSearchResults() {
		return new SearchResults();
	}

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
}
