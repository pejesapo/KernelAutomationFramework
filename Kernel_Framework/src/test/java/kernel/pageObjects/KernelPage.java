package kernel.pageObjects;

import java.util.concurrent.TimeUnit;

import kernel.tests.Login_User;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class KernelPage<T> {

	protected final WebDriver browser;

	private static final String BASE_URL = "http://localhost:8080/dist/";
	private static final int LOAD_TIMEOUT = 30;
	private static final int REFRESH_RATE = 1;
	public boolean isFullyLoaded = false;
	public static final Logger logger = LoggerFactory
			.getLogger(Login_User.class);

	public KernelPage(WebDriver browser) {
		this.browser = browser;
	}

	public T openPage(Class<T> clazz) {
		T page = PageFactory.initElements(this.browser, clazz);
		this.browser.get(BASE_URL + getPageUrl());
		ExpectedCondition pageLoadCondition = ((KernelPage) page)
				.getPageLoadCondition();
		logger.info("Waiting for {} page to get fully loaded...",
				clazz.toString());
		waitForPageToLoad(pageLoadCondition);
		((KernelPage) page).isFullyLoaded = true;
		logger.info("Page {} fully loaded.", clazz.toString());
		return page;
	}

	public T initPage(Class<T> clazz) {
		T page = PageFactory.initElements(browser, clazz);
		ExpectedCondition pageLoadCondition = ((KernelPage) page)
				.getPageLoadCondition();
		logger.info("Waiting for {} page to get fully loaded...",
				clazz.toString());
		waitForPageToLoad(pageLoadCondition);
		((KernelPage) page).isFullyLoaded = true;
		logger.info("Page {} fully loaded.", clazz.toString());
		return page;
	}

	private void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
		Wait wait = new FluentWait(this.browser)
				.withTimeout(LOAD_TIMEOUT, TimeUnit.SECONDS)
				.pollingEvery(REFRESH_RATE, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		;

		wait.until(pageLoadCondition);
	}

	protected WebElement waitFor(ExpectedCondition condition) {
		WebElement webElement = (new WebDriverWait(this.browser, LOAD_TIMEOUT)
				.until(condition));
		return webElement;

	}

	/**
	 * Provides condition when page can be considered as fully loaded.
	 * 
	 * @return
	 */
	protected abstract ExpectedCondition getPageLoadCondition();

	/**
	 * Provides page relative URL/
	 * 
	 * @return
	 */
	public abstract String getPageUrl();

}
