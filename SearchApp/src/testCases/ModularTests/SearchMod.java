package testCases.ModularTests;

import org.testng.Assert;
import org.testng.Reporter;

import pageFactories.SearchPageFactory;
import testCases.SearchBaseTestScriptConfig;

/**
 * Modular script to perform the search function on the Main search page.
 * @author Jesse Childress
 *
 */
public class SearchMod extends SearchBaseTestScriptConfig {

	public void search(String searchText) {

		Reporter.log("Beginning Search Modular Test..." + System.lineSeparator()
				+ "This is for the main search page from login...", true);
		

		SearchPageFactory searchPF = new SearchPageFactory();
		

		searchPF.setSearchField(searchText);
		
		//Ensure that the text is in the field
		Assert.assertEquals(searchPF.readSearchField(), searchText);
		
		searchPF.clickSearchMagnifyingGlass();
//		searchPF.hitEnter();

	}
}
