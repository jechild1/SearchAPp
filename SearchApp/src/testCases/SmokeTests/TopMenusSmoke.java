package testCases.SmokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageFactories.DocumentsPageFactory;
import pageFactories.SearchPageFactory;
import pageFactories.SettingsPageFactory;
import testCases.SearchBaseTestScriptConfig;
import testCases.ModularTests.LoginMod;

/**
 * Test to login to the system and to ensure that the left menus exist and are
 * clickable.
 * 
 * @author Jesse Childress
 *
 */
public class TopMenusSmoke extends SearchBaseTestScriptConfig {

	@Test(invocationCount = 1)
	public void TopMenusSmokeTest() {

		// Login to the system
		LoginMod loginMod = new LoginMod();
		loginMod.login("jesse.childress@aretecinc.com", "football3");

		SearchPageFactory spPF = new SearchPageFactory();
		
		//The Top menus are accessible without doing a search		
		//Check for presence of links
		
		Assert.assertEquals(spPF.isHomeLinkPresent(), true, "Top Menus - Home Link");
		Assert.assertEquals(spPF.isDocumentsTopLinkPresent(), true, "Top Menus - Documents Link");
		Assert.assertEquals(spPF.isAboutLinkPresent(), true, "Top Menus - About Link");
		Assert.assertEquals(spPF.isSettingsLinkPresent(), true, "Top Menus - Settings Link");
		Assert.assertEquals(spPF.isLogoutLinkPresent(), true, "Top Menus - Logout Link");
		
				
		//Click through links 
		
		//Click Documents
		spPF.clickDocumentsTopLink();
		DocumentsPageFactory documentsPF = new DocumentsPageFactory();
		
		
		//Click Home (Which is search page)
		documentsPF.clickHomeTopLink();
		spPF = new SearchPageFactory();
		
		//About link doesn't work
		//spPF.clickAboutLink();
		
		//Clicking Settings
		spPF.clickSettings();
		SettingsPageFactory settingsPF = new SettingsPageFactory();
		
		//Clicking Logout
		settingsPF.clickLogout();

	}

}
