package pageFactories;

import org.openqa.selenium.support.PageFactory;
/**
 * Page Factory Class to contain methods that interact with objects on the
 * <b>Documents Page</b>
 * 
 * @author Jesse Childress
 *
 */
public class DocumentsPageFactory extends diSearchMenusPageFactory {

	public static String regexURL = BASE_URL + "documents";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page and
	 * instantiates the elements on the page.
	 */
	public DocumentsPageFactory() {

		super(regexURL);
		PageFactory.initElements(driver, this);

	}



}
