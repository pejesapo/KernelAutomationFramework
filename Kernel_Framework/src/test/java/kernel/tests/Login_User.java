package kernel.tests;

import static org.junit.Assert.assertTrue;
import kernel.pageObjects.KernelDashboardPage;
import kernel.pageObjects.KernelHomePage;
import kernel.pageObjects.KernelLoginPage;
import kernel.setup.KernelTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Login_User{	
	
	static final Logger logger = LoggerFactory.getLogger(Login_User.class);
	public WebDriver browser = new KernelTest().getBrowser();
	
	@Rule
	public TestRule watcher = new TestWatcher() {
	    public void starting(Description description) {
	    	logger.info("Starting test: " + description.getMethodName());
	    }
	    public void succeeded(Description description) {
	    	logger.info("Test {} succeeded.", description.getMethodName());
	    }
	    public void failed(Throwable e, Description description) {
	    	logger.error("Test {} failed with {}.", description.getMethodName(), e);
	    }
	};
	 
	 @Before
	 public void setUp(){
		 
	 }
	 
	 @After
	 public void tearDown(){
		 logger.trace("Shutting down Selenium-Webdriver");
		 this.browser.quit();
	 }

	 @Test
     public void should_logging_with_correct_credentials() {
             logger.info("Given I'm in Kernel's Home Page");
             KernelLoginPage loginPage = new KernelHomePage(this.browser).open().goToLoginPage();
             
             logger.info("When I enter an email and password");
             loginPage.enterEmailAndPassword("wt.delacruz@gmail.com", "mollendo");
             
             logger.info("And I login to the system");
             KernelDashboardPage dashboardPage = loginPage.login();
             
             logger.info("Then I should be redirected to my personal Dashboard ");
             assertTrue(dashboardPage.isFullyLoaded);
             
     }
	 
	 @Test
     public void an_error_message_should_display_when_logging_in_with_inorrect_credentials() {
			logger.info("Given I'm in Kernel's Home Page");
			KernelLoginPage loginPage = new KernelHomePage(this.browser).open().goToLoginPage();
             
             logger.info("When I enter an incorrect email and password");
             loginPage.enterEmailAndPassword("wrongEmail@gmail.com", "wrongPassword");
             
             logger.info("And I try to login to the system");
             loginPage.signInButton.click();
             
             logger.info("Then a popup message error should be displayed with the text: You entered a wrong username or password combination. Try again, or click the Forgot Password link.");
             
     }
     
     
}
