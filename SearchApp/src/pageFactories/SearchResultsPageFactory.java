package pageFactories;

/**
 * Page Factory Class to contain methods that interact with objects on the
 * <b>Search Results Page</b>
 * 
 * @author jesse.childress
 *
 */
public class SearchResultsPageFactory extends diSearchMenusPageFactory{
	
	public static String regexURL = BASE_URL + "search-result" + ".*";
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page and
	 * instantiates the elements on the page.
	 */
	public SearchResultsPageFactory() {
		super(regexURL);
		waitForPageToLoad();
	}

}
