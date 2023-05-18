package testCases.SmokeTests;

import org.testng.annotations.Test;

import pageFactories.SearchPageFactory;
import pageFactories.SearchResultsPageFactory;
import pageFactories.SettingsPageFactory;
import testCases.SearchBaseTestScriptConfig;
import testCases.ModularTests.LoginMod;
import testCases.ModularTests.SearchMod;
import utilities.AutomationHelper;

/**
 * @author Jesse Childress
 *
 */
public class LeftMenusSmoke extends SearchBaseTestScriptConfig {

	@Test(invocationCount = 1)
	public void leftMenusSmoke() {

		// Login to the system
		LoginMod loginMod = new LoginMod();
		loginMod.login("jesse.childress@aretecinc.com", "football3");
		
		
		SearchPageFactory spPF= new SearchPageFactory();
//		spPF.readDomainList();
		
		spPF.selectDomain("Health and Fitness", "RDTS", "LMN");
		
		
//		AutomationHelper.waitSeconds(3);
		
		spPF.unselectDomain("Health and Fitness", "LMN");
		
//		AutomationHelper.waitSeconds(3);

		
//		spPF.readDomainAndSubDomainList();
		
//		spPF.clickUploadDocuments();
		
		
//		spPF.getUploadDocuments().uploadFile("Aretec - Test A.pdf");
		
		AutomationHelper.waitSeconds(10);
		
		
		

//		//TODO - Uncomment below
//		// Perform a search
//		SearchMod searchMod = new SearchMod();
//		searchMod.search("What does aretec do?");
//
//		/*
//		 * The Menu Navigation links are in their own abstract classes.
//		 */
//
//		SearchResultsPageFactory searchResultsPF = new SearchResultsPageFactory();
//		searchResultsPF.clickSettings();
//
//		// Settings Page
//		SettingsPageFactory settingsPF = new SettingsPageFactory();
//
//		settingsPF.clickLogout();

	}

}
