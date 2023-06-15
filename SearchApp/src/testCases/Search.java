package testCases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import pageFactories.SearchResultsPageFactory;
import testCases.ModularTests.LoginMod;
import testCases.ModularTests.SearchMod;
import utilities.AutomationHelper;

/**
 * Test to perform a simple search.
 * 
 * @author Jesse Childress
 *
 */
public class Search extends SearchBaseTestScriptConfig {

	@Test (invocationCount = 1)
	public void loginSmokeTest() {

		Reporter.log("Beginning test for simple search...", true);

		// Login to the system
		LoginMod loginMod = new LoginMod();
		loginMod.login("jesse.childress@aretecinc.com", "football3");	
		
		//Search Page
		SearchMod search = new SearchMod();
		search.search("How can Aretec save money on taxes?", "DEFAULT", "Proposals");
		
		//Search Results
		SearchResultsPageFactory searchResultsPF = new SearchResultsPageFactory();
		System.out.println(searchResultsPF.readAnswer());	
		
		AutomationHelper.waitSeconds(15);
		
		
		

	}

}
