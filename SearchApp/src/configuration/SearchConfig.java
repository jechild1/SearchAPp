
package configuration;

import CoreConfig.CoreConfig;

public abstract class SearchConfig extends CoreConfig {

	// Environment URL
	protected static final String BASE_URL = "https://test-search-2my7afm7yq-ue.a.run.app/";

	//Production URL
//	protected static final String BASE_URL = "https://aretec-search-2my7afm7yq-ue.a.run.app/";
	
	//Default Locations
	protected static String DEFAULT_FILE_PATH_FOR_SCREENSHOTS = System.getenv("Eclipse-ScreenshotsLocation");

	// Constructor
	public SearchConfig() {
		super(BASE_URL);
	}

	/**
	 * Returns the Current URL of the page.
	 * 
	 * @return String
	 */
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

}
