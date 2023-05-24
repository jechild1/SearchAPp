package testCases.SmokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageFactories.SearchPageFactory;
import pageFactories.SearchResultsPageFactory;
import testCases.SearchBaseTestScriptConfig;
import testCases.ModularTests.LoginMod;
import testCases.ModularTests.SearchMod;

/**
 * Test to login to the system and to ensure that the left menus exist and are
 * clickable.
 * 
 * @author Jesse Childress
 *
 */
public class LeftMenusSmoke extends SearchBaseTestScriptConfig {

	@Test(invocationCount = 1)
	public void leftMenusSmoke() {

		// Login to the system
		LoginMod loginMod = new LoginMod();
		loginMod.login("jesse.childress@aretecinc.com", "football3");

		SearchPageFactory spPF = new SearchPageFactory();

		// Perform a simple search
		spPF.unselectAllDomains();

		SearchMod search = new SearchMod();

		// A search is necessary to pull back the page.
		search.search("What can Aretec help me do? Give me a bulleted list", "DEFAULT", "Proposals");

		SearchResultsPageFactory srPF = new SearchResultsPageFactory();

		// This section was removed
//		System.out.println(srPF.getSearchResults().readResults());
//		System.out.println(srPF.getSearchResults().readFindings());
//		System.out.println(srPF.getSearchResults().readTopics());

		/*
		 * Assert that the left links are present
		 */
		Assert.assertEquals(srPF.isSearchResultsPresent(), true, "Left Links - Search Results");

		Assert.assertEquals(srPF.isEvaluationYearPresent(), true, "Left Links - Evaluation Year");
		srPF.clickEvaluationYear();

		Assert.assertEquals(srPF.isTopicsPresent(), true, "Left Links - Topic(s)");
		srPF.clickTopics();

		Assert.assertEquals(srPF.isDocumentsPresent(), true, "Left Links - Document(s)");
		srPF.clickDocuments();

		Assert.assertEquals(srPF.isDomainsPresent(), true, "Left Links - Domain(s)");
		srPF.clickDomains();

		Assert.assertEquals(srPF.isHistoryPresent(), true, "Left Links - History");
		srPF.clickHistory();

	}

}
