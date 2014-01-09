package kernel.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class KernelLoginPage extends KernelPage<KernelLoginPage> {

	public final static String AUTHENTICATION_ERROR_MESSAGE = "You entered a wrong username or password combination. "
			+ "Try again, or click the Forgot Password link.";

	@FindBy(id = "emailField")
	public WebElement emailTextField;

	@FindBy(id = "passwordField")
	public WebElement passwordTextField;

	@FindBy(id = "signUp")
	public WebElement signInButton;

	@FindBy(xpath = "//*[text()='Forgot Password']")
	public WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//*[@class='mod-modal-wrapper error']//*[text()='"
			+ KernelLoginPage.AUTHENTICATION_ERROR_MESSAGE + "']")
	public WebElement authenticationErrorMessageWebElement;

	public KernelLoginPage(WebDriver browser) {
		super(browser);
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(forgotPasswordLink);
	}

	@Override
	public String getPageUrl() {
		return "/#login";
	}

	public KernelLoginPage visit() {
		return new KernelLoginPage(this.browser).open(KernelLoginPage.class);
	}

	public KernelDashboardPage authenticate(String type, String email,
			String password) {
		logger.info("Doing <authenticate>");
		emailTextField.clear();
		emailTextField.sendKeys(email);
		passwordTextField.clear();
		passwordTextField.sendKeys(password);
		signInButton.click();

		KernelDashboardPage result = null;
		switch (type) {
		case "correct":
			result = new KernelDashboardPage(this.browser)
					.init(KernelDashboardPage.class);
			break;
		case "incorrect":
			break;
		}
		return result;
	}

	// TODO
	public boolean isLoginError() {
		return false;
	}

	public boolean isLoginErrorMessageDisplayed() {
		logger.info("Doing <isLoginErrorMessageDisplayed>");
		this.waitFor(ExpectedConditions.visibilityOf(authenticationErrorMessageWebElement));

		return true;
	}

}
