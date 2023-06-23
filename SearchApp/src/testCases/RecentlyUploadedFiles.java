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
		searchPF.clickDocumentsTopLink();

		// Documents page displayed
		DocumentsPageFactory documentsPF = new DocumentsPageFactory();
//		documentsPF.getDomains().selectDomain("Health and Fitness");
//		documentsPF.getDomains().selectDomain("Proposals");

//		documentsPF.getDomains().clickSearchDomains();
		
		//Purposely do not scope the domain down so that pagination is tested.
		Assert.assertEquals(documentsPF.getDocumentsTable().isRowInTableByValue("File Name(s)", fileWithPDF), true, "TEST");
		
		
		//If it is good
		
		
		
		

		/*
		 * Upload the file new
		 */

		/*
		 * Wait on the new file to be processed
		 */

		/*
		 * Check the login page to see if the file exists there
		 */

	}

}
