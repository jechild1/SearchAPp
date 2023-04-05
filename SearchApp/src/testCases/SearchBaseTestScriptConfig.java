package testCases;

import java.io.File;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import configuration.SearchConfig;
import utilities.AutomationHelper;

public abstract class SearchBaseTestScriptConfig extends SearchConfig {

	// TestNG documentation
	/**
	 * After class method that will run the clean up finish test methods at the end
	 * of all tests in a given class
	 */
	@AfterClass
	public void afterClass() {
		AutomationHelper.finishTest();
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss");

		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenshotOnFailure screenshot = new ScreenshotOnFailure();
			screenshot.captureScreenshot(driver,
					result.getName() + " - " + formatter.format(java.time.LocalDateTime.now()));
		}

	}

	/**
	 * Class to capture screenshots when an error occurs.
	 */
	public class ScreenshotOnFailure {
		public void captureScreenshot(WebDriver driver, String screenshotName) {

			try {
				TakesScreenshot ts = (TakesScreenshot) driver;

				File source = ts.getScreenshotAs(OutputType.FILE);
//				FileHandler.copy(source, new File(DEFAULT_FILE_PATH_FOR_SCREENSHOTS + screenshotName + ".png"));
				System.out.println("Screenshot taken");
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}

		}
	}

}
