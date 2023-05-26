package pageFactories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import configuration.SearchConfig;
import utilities.AutomationHelper;

public abstract class diSearchBase extends SearchConfig {

	/*
	 * Initialize elements of a given page factory
	 */
	public void initializeElements() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Getter method to return a class object for Upload Documents
	 * 
	 * @return UploadDocuments
	 */
	public UploadDocuments getUploadDocuments() {
		return new UploadDocuments();
	}
	
	/**
	 * Private utility method that checks for the presence of a WebElement by a
	 * passed in XPATH.
	 * 
	 * @param xPath
	 * @return
	 */
	protected boolean isWebElementPresent(String xPath) {

		// Long startTime = System.currentTimeMillis();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		boolean isElementPresent = driver.findElements(By.xpath(xPath)).size() > 0;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(NORMAL_TIMEOUT));
		// Long endTime = System.currentTimeMillis();

		// System.out.println("Time for check for xpath " + xPath + ": " + (endTime -
		// startTime) / 1000);

		return isElementPresent;
	}

	/**
	 * Class that will contain methods that handle the uploading of documents
	 * 
	 * @author Jesse Childress
	 *
	 */
	public class UploadDocuments {

		@FindBy(xpath = "//button/span[text() = 'Select Domain']")
		WebElement selectDomainButton;

		/**
		 * Clicks the Select Domain button on the Upload Documents modal
		 */
		public void clickSelectDomain() {
			AutomationHelper.printMethodName();
			selectDomainButton.click();
		}

		@FindBy(xpath = "//button/span[text() = 'Browse Files']")
		WebElement browseFilesButton;

		/**
		 * Clicks the Browse Files button on the Upload Documents modal
		 */
		public void clickBrowseFiles() {
			AutomationHelper.printMethodName();
			browseFilesButton.click();
		}

		/**
		 * Method to upload a file (or multiple files, as indicated by a comma between
		 * each file name.)
		 * 
		 * @param filesToUpload
		 */
		public void uploadFile(String filesToUpload) {

			// First, see if the data has multiple files, as separated by a comma.
			String[] files = filesToUpload.split(",");
			// Remove the white space from before and after each separate file name
			for (int i = 0; i < files.length; i++) {
				files[i] = files[i].trim();
			}

			// Loop through each item in the array and perform an upload

			for (String currentFile : files) {

				String xpath = "//input[@type='file'][@multiple = '']";
				WebElement fileUploadObject = driver.findElement(By.xpath(xpath));

				String filePath = generateFullFileNameAndPath(currentFile);
				// Good to print in the log
				Reporter.log("File Uploaded: " + filePath, true);

				fileUploadObject.sendKeys(filePath);

			}
		}

	}

}
