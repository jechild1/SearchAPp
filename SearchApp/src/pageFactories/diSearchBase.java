package pageFactories;

import org.openqa.selenium.support.PageFactory;

import configuration.SearchConfig;

public abstract class diSearchBase extends SearchConfig {
	
	/*
	 * Initialize elements of a given page factory
	 */
	public void initializeElements() {
		PageFactory.initElements(driver, this);
	}
	


}
