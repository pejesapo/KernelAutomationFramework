package kernel.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KernelTest {	
	
	public static final Logger logger = LoggerFactory.getLogger(KernelTest.class);

	public WebDriver getBrowser() {	
		logger.info("Creating Selenium Webdriver instance");
		WebDriver driver=null;
		String browserName = KernelConfiguration.getInstance().getProperty(KernelConfiguration.BROWSER_NAME);
		switch (browserName) {
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver",
						KernelConfiguration.getInstance().getProperty(KernelConfiguration.CHROME_DRIVER_PATH));
				driver = new ChromeDriver();
				break;
			case "ie":
				//TODO
				break;
		}
		return driver;		
	}

}
