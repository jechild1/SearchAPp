package testCases.SmokeTests;

import org.testng.annotations.Test;

import pageFactories.SearchPageFactory;
import testCases.SearchBaseTestScriptConfig;
import testCases.ModularTests.LoginMod;
import testCases.ModularTests.SearchMod;

/**
 * @author Jesse Childress
 *
 */
public class LeftMenusSmoke extends SearchBaseTestScriptConfig {
	
	@Test
	public void leftMenusSmoke() {
		
		//Login to the system
		LoginMod loginMod = new LoginMod();
		loginMod.login("jesse.childress@aretecinc.com", "football3");	
		
		//Perform a search
		SearchMod searchMod = new SearchMod();
		searchMod.search("What does aretec do?");
		
		/*
		 * The Menu Navigation links are in their own abstract classes.
		 */
		
		
		
	}

	
	
}
