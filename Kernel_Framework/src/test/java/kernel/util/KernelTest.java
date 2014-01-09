package kernel.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KernelTest {	
	
	public static final Logger logger = LoggerFactory.getLogger(KernelTest.class);

	public WebDriver getBrowser() {			
		WebDriver driver=null;
		String browserName = KernelConfiguration.getInstance().getProperty(KernelConfiguration.BROWSER_NAME);
		switch (browserName) {
			case "firefox":
				driver = new FirefoxDriver();
				logger.info("Firefox Driver instaciated");
				break;
			case "chrome":
				logger.info("Chrome Driver path: {}",KernelConfiguration.CHROME_DRIVER_PATH);
				System.setProperty("webdriver.chrome.driver",
						KernelConfiguration.getInstance().getProperty(KernelConfiguration.CHROME_DRIVER_PATH));
				driver = new ChromeDriver();
				logger.info("Chrome Driver instaciated");
				break;
			case "ie":
				//TODO
				break;
		}
		return driver;		
	}

}
