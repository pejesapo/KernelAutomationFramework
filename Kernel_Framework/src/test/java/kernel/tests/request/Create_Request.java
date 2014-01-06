package kernel.tests.request;

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

public class Create_Request {

	static final Logger logger = LoggerFactory.getLogger(Create_Request.class);
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
		logger.trace("Shutting down Selenium-Webdriver");
		this.browser.quit();
	}

	
}
