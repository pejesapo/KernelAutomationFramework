package kernel.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KernelTest {	
	
	public static final Logger logger = LoggerFactory.getLogger(KernelTest.class);

	public WebDriver getBrowser() {		
		KernelConfiguration.getInstance().getProperty(KernelConfiguration.CONFIG_FILE_NAME);
		logger.info("Creating Selenium Webdriver instance");
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				"C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

}
