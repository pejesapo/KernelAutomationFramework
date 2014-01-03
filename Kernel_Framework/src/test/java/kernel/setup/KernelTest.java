package kernel.setup;

import kernel.tests.Login_User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KernelTest {	
	
	public static final Logger logger = LoggerFactory.getLogger(Login_User.class);

	public WebDriver getBrowser() {
		logger.info("Creating Selenium Webdriver instance");
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				"C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

}
