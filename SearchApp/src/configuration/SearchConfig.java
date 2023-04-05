
package configuration;

import CoreConfig.CoreConfig;

public abstract class SearchConfig extends CoreConfig {

	// Environment URL
	protected static final String BASE_URL = "https://aretec-search-2my7afm7yq-ue.a.run.app/login";

	// Constructor
	public SearchConfig() {
		super(BASE_URL);
	}
	
	


}
