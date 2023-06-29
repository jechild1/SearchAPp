package pageFactories;

/**
 * Page Factory Class to contain methods that interact with objects on the
 * <b>Q&A Page</b>
 * 
 * @author Jesse Childress
 *
 */
public class QandAPageFactory extends diSearchMenusPageFactory {
	
	public static String regexURL = BASE_URL + "q-and-a";
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page and
	 * instantiates the elements on the page.
	 */
	public QandAPageFactory() {
		super(regexURL);
		waitForPageToLoad();
	}
	
	
	
	
	

}
