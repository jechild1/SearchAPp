package testCases.Login;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageFactories.LoginPageFactory;
import pageFactories.SearchPageFactory;
import testCases.SearchBaseTestScriptConfig;
import utilities.AutomationHelper;

public class Login extends SearchBaseTestScriptConfig{

		@Test
		public void loginTest() {
		LoginPageFactory loginPageFactory = new LoginPageFactory();
		
		loginPageFactory.loadPage();
		
		//set fields
		loginPageFactory.setEmail("jesse.childress@aretecinc.com");
		loginPageFactory.setPassword("football3");
		
		System.out.println("Email Address: " + loginPageFactory.readEmail());
		
		loginPageFactory.clickLogin();
		
		SearchPageFactory searchPF = new SearchPageFactory();
		AutomationHelper.waitSeconds(3);

		searchPF.setSearchField("What is selenium?");
//		searchPF.clickSearch();
		searchPF.hitEnter();
		
		AutomationHelper.waitSeconds(3);
		

		}
}
