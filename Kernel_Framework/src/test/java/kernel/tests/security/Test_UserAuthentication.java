package kernel.tests.security;

import static org.junit.Assert.assertTrue;
import kernel.pageObjects.KernelDashboardPage;
import kernel.pageObjects.KernelHomePage;
import kernel.pageObjects.KernelLoginPage;
import kernel.util.KernelTest;

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

public class Test_UserAuthentication {

	static final Logger logger = LoggerFactory.getLogger(Test_UserAuthentication.class);
	public WebDriver browser = new KernelTest().getBrowser();

	@Rule
	public TestRule watcher = new TestWatcher() {
		public void starting(Description description) {
			logger.info("<<<Starting test: {}>>>", description.getMethodName());
		}

		public void succeeded(Description description) {
			logger.info("<<<Test {} succeeded.>>>", description.getMethodName());
		}

		public void failed(Throwable e, Description description) {
			logger.error("<<<Test {} failed with {}.>>>",
					description.getMethodName(), e);
		}
	};

	@Before
	public void setUp() {

	}

	@After
	public void tearDown() {
		logger.info("Shutting down Selenium-Webdriver");
		this.browser.quit();
	}

	@Test
	public void should_authenticate_with_correct_credentials() {
		logger.info("Given I'm in Kernel's Login Page");
		KernelLoginPage loginPage = new KernelHomePage(this.browser).visit().navigateToLoginPage();
		
		logger.info("And I authenticate with /correct/ credentials");
		KernelDashboardPage dashboardPage = loginPage.authenticate("correct", "wt.delacruz@gmail.com", "mollendo");
		
		logger.info("Then I should be redirected to Dashboard page");
		assertTrue(dashboardPage.isFullyLoaded);
	}

	@Test
	public void an_error_message_should_be_displayed_when_authenticating_with_incorret_credentials() {		
		logger.info("Given I'm in Kernel's Login Page");
		KernelLoginPage loginPage = new KernelHomePage(this.browser).visit().navigateToLoginPage();
		
		logger.info("And I authenticate with /incorrect/ credentials");
		loginPage.authenticate("incorrect", "wrongmail@gmail.com", "mollendo");
		
		logger.info("Then a popup message error should be displayed");
		assertTrue(loginPage.isLoginErrorMessageDisplayed());		
	}

	//TODO
	@Test
	public void should_authenticate_with_a_valid_Google_Account(){
		
	}
	
	//TODO
	@Test
	public void should_be_able_to_recover_forgotten_password(){
		
	}
}
