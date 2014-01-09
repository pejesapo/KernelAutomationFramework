package kernel.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;

public class KernelHomePage extends KernelPage<KernelHomePage> {

		
	public KernelHomePage(WebDriver browser) {
		super(browser);
		//this.browser = browser;
	}
	
	@FindBy(linkText = "Existing user? Sign In")
    WebElement loginLink;
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(loginLink);
	}

	@Override
	public String getPageUrl() {
		return "";
	}

	public KernelHomePage visit() {		
		return new KernelHomePage(this.browser).open(KernelHomePage.class);
	}

	public KernelLoginPage navigateToLoginPage(){
		logger.info("Doing <{}.navigateToLoginPage>",this.getClass().toString());
		loginLink.click();
		return new KernelLoginPage(this.browser).init(KernelLoginPage.class);
	}
	
}
