package testCases.SmokeTests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import testCases.SearchBaseTestScriptConfig;
import testCases.ModularTests.LoginMod;

/**
 * Test to perform a successful login.
 * 
 * @author Jesse Childress
 *
 */
public class LoginSmoke extends SearchBaseTestScriptConfig {

	@Test
	public void loginSmokeTest() {

		Reporter.log("Beginning Login Smoke Test...", true);

		// Login to the system
		LoginMod loginMod = new LoginMod();
		loginMod.login("jesse.childress@aretecinc.com", "football3");	

	}

}
