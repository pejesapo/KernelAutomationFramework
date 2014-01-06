package kernel.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KernelLoginPage extends KernelPage<KernelLoginPage> {

	// private final WebDriver browser;

	@FindBy(id = "emailField")
	public WebElement emailTextField;

	@FindBy(id = "passwordField")
	public WebElement passwordTextField;

	@FindBy(id = "signUp")
	public WebElement signInButton;

	@FindBy(xpath = "//*[text()='Forgot Password']")
	public WebElement forgotPasswordLink;

	public KernelLoginPage(WebDriver browser) {
		super(browser);
		// this.browser = browser;
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(forgotPasswordLink);
	}

	@Override
	public String getPageUrl() {
		return "/#login";
	}

	public KernelDashboardPage login() {
		logger.info("Doing <login>");
		signInButton.click();
		return new KernelDashboardPage(this.browser)
				.initPage(KernelDashboardPage.class);
	}

	public void enterEmailAndPassword(String email, String password) {
		logger.info("Doing <enterEmailAndPassword>");
		emailTextField.clear();
		emailTextField.sendKeys(email);
		passwordTextField.clear();
		passwordTextField.sendKeys(password);
	}

	// ToDo
	public boolean isLoginError() {
		return false;
	}

	public boolean isLoginErrorMessageDisplayed(String message) {
		logger.info("Doing <isLoginErrorMessageDisplayed>");
		this.waitFor(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//*[@class='mod-modal-wrapper error']//*[text()='"
						+ message + "']")));

		return true;
	}

}
