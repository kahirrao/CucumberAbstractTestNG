package parallel;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	/*
	 * -We are using hooks for preconding i.e before login to home page -we need to
	 * launch broswer & enter url we are using DriverFactory,ConfigReder class from
	 * com_qa_factory and com_qa_util packages
	 */
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReder;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		configReder = new ConfigReader();
		prop = configReder.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {

			String screenshotName = scenario.getName().replaceAll(" ", "_");
			File sourcepath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {
				FileUtils.copyFile(sourcepath, new File("./ScreenshotsFailure/" + screenshotName + ".png"));
			} catch (IOException e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
				e.printStackTrace();
			}
			;
		}

	}
}