package testCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageFactories.DocumentsPageFactory;
import pageFactories.SearchPageFactory;
import pageFactories.SearchResultsPageFactory;
import testCases.ModularTests.LoginMod;
import testCases.ModularTests.SearchMod;
import utilities.AutomationHelper;

/**
 * Test to ensure that the recently uploaded files appear on the main page.
 * 
 * @author Jesse Childress
 *
 */
public class RecentlyUploadedFiles extends SearchBaseTestScriptConfig {

	@Test(invocationCount = 1)
	public void validateRecntlyUploadedFiles() {

		Reporter.log("Beginning test for Recently Uploaded Files search...", true);

		String file = "SQA Test - TEMP UPLOAD.txt";
		String fileWithPDF = "SQA Test - TEMP UPLOAD.pdf";
		String domain = "SQA Testing";

		// Login to the system
		LoginMod loginMod = new LoginMod();
		loginMod.login(USER_NAME, PASSWORD);

		/*
		 * First, we check to see if we can DELETE a previously uploaded file
		 */

		// Land on the Search page
		SearchPageFactory searchPF = new SearchPageFactory();
		searchPF.clickDocumentsSlideMenuLink();

		// Documents page displayed
		DocumentsPageFactory documentsPF = new DocumentsPageFactory();

		// Purposely do not scope the domain down so that pagination is tested.
		// If the file is there, delete it.

//		Assert.assertEquals(documentsPF.getDocumentsTable().isRowInTableByValue("File Name(s)", fileWithPDF), true, "TEST");

		// Navigate back to the Serach page
		documentsPF.clickHomeSlideMenuLink();

		searchPF = new SearchPageFactory();

		/*
		 * Upload the file new
		 */

//		searchPF.clickUploadFiles();

		// TODO - The domain list does not have a scroll bar, and is unusable when the
		// list gets long. We cannot expand all of these items in order to work with
		// them. There is a current defect in for this.
//		searchPF.getUploadFiles().selectDomain(domain);
//		searchPF.getUploadFiles().uploadFile(file); // TXT version
//
//		// Click the upload button
//		searchPF.getUploadFiles().clickUpload();

		/*
		 * Wait on the new file to be processed
		 */
		
		//TODO

		/*
		 * Check the login page to see if the file exists there
		 */
		Assert.assertEquals(searchPF.isFileInRecentlyUploaded("What-can-machine-learning-do-Science.pdf"), true, "Recently uploaded File");
	}

}
