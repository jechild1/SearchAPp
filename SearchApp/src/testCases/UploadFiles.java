package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageFactories.DocumentsPageFactory;
import pageFactories.SearchPageFactory;
import pageFactories.diSearchBase.UploadDocuments;
import testCases.ModularTests.LoginMod;

/**
 * Test to perform a a file upload and assert they're present.
 * 
 * @author Jesse Childress
 *
 */
public class UploadFiles extends SearchBaseTestScriptConfig {

	@Test(invocationCount = 1)
	public void uploadFiles() {
		
		String domain = "SQA Testing";
		
		String file1 = "SQA Test A - Software Testing Overview.pdf";
		String file2 = "SQA Test B - Selenium.pdf";
		String file3 = "SQA Test C - Jira.pdf";
		String file4 = "SQA Test D - Test Automation.pdf";
		String file5 = "SQA Test E - Java.pdf";
		
		//First, login
		//Modular Script for Login
		LoginMod login = new LoginMod();
		login.login(USER_NAME, PASSWORD);
		
		
		//Delete the files if they exist already
		//Search Page
		SearchPageFactory searchPF = new SearchPageFactory();
		
		searchPF.clickDocumentsTopLink();
		
		//Documents page
		DocumentsPageFactory documentsPF = new DocumentsPageFactory();
		
		//Select the domain from the left hand side
		documentsPF.getUploadDocuments().selectDomain(domain);

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		searchPF.clickUploadDocuments();
		
		//The modal is now displayed
		searchPF.getUploadDocuments().clickSelectDomainButton();
		
		
		//Select the domain for the file to be attached to
		searchPF.getUploadDocuments().selectDomain("SQA Testing");
		
		

		
		
			

		
		searchPF.getUploadDocuments().uploadFile(file1 + "," + file2  + "," + file3  + "," + file4  + "," + file5);
		
		Assert.assertEquals(true, searchPF.getUploadDocuments().isFileInUploadList(file1), "Assert File 1 present");
		Assert.assertEquals(true, searchPF.getUploadDocuments().isFileInUploadList(file2), "Assert File 2 present");
		Assert.assertEquals(true, searchPF.getUploadDocuments().isFileInUploadList(file3), "Assert File 3 present");
		Assert.assertEquals(true, searchPF.getUploadDocuments().isFileInUploadList(file4), "Assert File 4 present");
		Assert.assertEquals(true, searchPF.getUploadDocuments().isFileInUploadList(file5), "Assert File 5 present");
		
		searchPF.getUploadDocuments().clickUpload();
		
		
	
		
		
		

		
		
		
		//Check for file names
		


	}

}