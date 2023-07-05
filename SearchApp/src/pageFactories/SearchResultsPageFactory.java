package pageFactories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import utilities.AutomationHelper;

/**
 * Page Factory Class to contain methods that interact with objects on the
 * <b>Search Results Page</b>
 * 
 * @author jesse.childress
 *
 */
public class SearchResultsPageFactory extends diSearchMenusPageFactory {

	public static String regexURL = BASE_URL + "search-result" + ".*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page and
	 * instantiates the elements on the page.
	 */
	public SearchResultsPageFactory() {
		super(regexURL);
		waitForPageToLoad();
	}

	/**
	 * This method will wait for the Answer text to finished and completed before it
	 * allows the script to continue.
	 */
	private void waitForAnswerGeneration() {
		AutomationHelper.printMethodName();

		// Grab the xpath of the Answer paragraph:
		String xpathOfAnswer = "//div[@class = 'content mgBt_10 bullet']/p";

		// Variables to be used in the do/while loop
		int initialCharacterCount = 0;
		int waitCharacterCount = 0;
		int loopCounter = 0;

		do {

			// Grab a reference to the WebElement
			WebElement answerParagraph = driver.findElement(By.xpath(xpathOfAnswer));

			// Grab the current text of the answer paragraph
			String initialParagraphText = AutomationHelper.getText(answerParagraph);

			// Count the initial characters in the paragraph
			initialCharacterCount = initialParagraphText.length();

			// Force the script to wait one second before grabbing a new reference.
			AutomationHelper.waitSeconds(1);

			// Get new references to objects after a wait so we can compare in the WHILE
			// below
			answerParagraph = driver.findElement(By.xpath(xpathOfAnswer));
			String waitedParagraphText = AutomationHelper.getText(answerParagraph);
			waitCharacterCount = waitedParagraphText.length();

			loopCounter++;

		} while (initialCharacterCount != waitCharacterCount);

		Reporter.log("Waited on Answer text for: " + loopCounter + " seconds.", true);

	}

	/**
	 * Method to read the Answer text from the Search Results page.
	 * <p>
	 * Because the Answer text is automatically generated, it will require that we
	 * wait until the text is completed. This method calls waitForAnswerGeneration()
	 * to ensure the answer is finished before it proceeds to read it.
	 * 
	 * @return String
	 */
	public String readAnswer() {
		AutomationHelper.printMethodName();

		// We must wait for the answer to be dynamically generated.
		waitForAnswerGeneration();

		String xpathOfAnswer = "//div[@class = 'content mgBt_10 bullet']/p";

		WebElement answerWebElement = driver.findElement(By.xpath(xpathOfAnswer));

		return AutomationHelper.getText(answerWebElement);

	}

	/**
	 * Getter method for References objects
	 * 
	 * @return References
	 */
	public References getReferences() {
		return new References();
	}

	/**
	 * Sub-class that contains methods for interacting with objects in the
	 * References section
	 * 
	 * @author Jesse Childress
	 *
	 */
	public class References {

		// Expand references section

		/**
		 * Utility method to expand the references section, if not already expanded.
		 */
		private void expandReferencesSection() {
			// Ensure that it is not already open
			WebElement referencesSection = driver
					.findElement(By.xpath("//div[@class='ant-collapse-header']/span[text() = 'Reference(s)']"));

			boolean expanded = Boolean.valueOf(referencesSection.getAttribute("aria-disabled"));

			// If it is NOT already open, open it
			if (!expanded) {
				referencesSection.click();
			}
		}

		WebElement referencesContainer = driver.findElement(By.xpath(
				"//div[@class='ant-collapse-header'][1]/span[text() = 'Reference(s)']//ancestor::div[@class = 'ant-collapse-item ant-collapse-item-active ref']"));

		/**
		 * Reads the <b>File Name</b> in the References section
		 * 
		 * @return String
		 */
		public String readFileName() {
			AutomationHelper.printMethodName();

			expandReferencesSection();

			String fileName = AutomationHelper
					.getText(referencesContainer.findElement(By.xpath("//p[@class='name space_0']/parent::span")));

			return fileName;
		}

		/**
		 * Returns the <b>Upload Date</b> in the References section. Note: this only
		 * returns the date.
		 * 
		 * @return String
		 */
		public String readUploadDate() {
			AutomationHelper.printMethodName();

			expandReferencesSection();

			String completeText = AutomationHelper
					.getText(referencesContainer.findElement(By.xpath("//p[@class = 'space_0']")));

			// String looks like "Upload Text: 2023-07-04"
			completeText = completeText.substring(completeText.lastIndexOf(" "), completeText.length()).trim();

			return completeText;

		}

	}

}
