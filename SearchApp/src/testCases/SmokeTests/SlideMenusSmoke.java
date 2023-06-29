package testCases.SmokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageFactories.DocumentsPageFactory;
import pageFactories.SearchPageFactory;
import testCases.SearchBaseTestScriptConfig;
import testCases.ModularTests.LoginMod;

/**
 * Test to login to the system and to ensure that the slide menus exist and are
 * clickable.
 * 
 * @author Jesse Childress
 *
 */
public class SlideMenusSmoke extends SearchBaseTestScriptConfig {

	@Test(invocationCount = 1)
	public void TopMenusSmokeTest() {

		// Login to the system
		LoginMod loginMod = new LoginMod();
		loginMod.login(USER_NAME, PASSWORD);

		SearchPageFactory spPF = new SearchPageFactory();

		// The Top menus are accessible without doing a search
		// Check for presence of links

		Assert.assertEquals(spPF.isHomeLinkPresent(), true, "Side Menus - Home Link");
		Assert.assertEquals(spPF.isDocumentsSlideLinkPresent(), true, "Side Menus - Documents Link");
		Assert.assertEquals(spPF.isQandASlideLinkPresent(), true, "Side Menus - Q&A Link");
		Assert.assertEquals(spPF.isAboutSlideLinkPresent(), true, "Side Menus - About Link");
		Assert.assertEquals(spPF.isLogoutSlideLinkPresent(), true, "Top Menus - Logout Link");

		// Click through links

		// Click Documents
		spPF.clickDocumentsSlideMenuLink();
		DocumentsPageFactory documentsPF = new DocumentsPageFactory();

		// Click Home (Which is search page)
		documentsPF.clickHomeSlideMenuLink();
		spPF = new SearchPageFactory();

		// Click Q&A
		spPF.clickQandASlideLink();
//		QandAPageFactory qaPF = new QandAPageFactory();

		// Go back home
		// TODO - There is something about this method that causes a stale reference
		// with it goes to Q&A Page.
//		qaPF.clickHomeSlideMenuLink();

		spPF = new SearchPageFactory();

		// Clicking Logout
		spPF.clickLogoutSlideLink();

	}

}
