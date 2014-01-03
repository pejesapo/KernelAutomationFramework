package kernel.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class KernelLoginPage extends KernelPage<KernelLoginPage> {
	
	//private final WebDriver browser;

	@FindBy(id = "emailField")
	WebElement emailTextField;

	@FindBy(id = "passwordField")
	WebElement passwordTextField;

	@FindBy(id = "signUp")
	WebElement signInButton;
	
	@FindBy(xpath = "//*[text()='Forgot Password']")
	WebElement forgotPasswordLink;	
	

	public KernelLoginPage(WebDriver browser) {
		super(browser);
		//this.browser = browser;
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(forgotPasswordLink);
	}

	@Override
	public String getPageUrl() {
		return "/#login";
	}

	public KernelDashboardPage login(String email, String password) {
		logger.info("Doing <login>");
		emailTextField.clear();
		emailTextField.sendKeys(email);
		passwordTextField.clear();
		passwordTextField.sendKeys(password);
		signInButton.click();
		return new KernelDashboardPage(this.browser).initPage(KernelDashboardPage.class);
	}

	//ToDo
	public boolean isLoginError() {
		return false;
	}
	
	//ToDo
	public String getErrorMessage() {
		return "";
	}

}
