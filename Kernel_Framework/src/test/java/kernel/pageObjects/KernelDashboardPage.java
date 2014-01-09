package kernel.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class KernelDashboardPage extends KernelPage<KernelDashboardPage> {
	
	public KernelDashboardPage(WebDriver browser) {
		super(browser);
		//this.browser = browser;
	}

	@FindBy(linkText = "Create a request")
    WebElement createRequestLink;
	
	@FindBy(id = "kernelMenuTrigger")
	WebElement kernelLogoButton;
	
	@FindBy(xpath = "//*[@id='kernelMenuBody']/*[text()='Create Request']")
	WebElement createRequestButton;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(kernelLogoButton);
	}

	@Override
	public String getPageUrl() {
		return "#home/active";
	}
	
	public KernelCreateRequestPage goToCreateRequest(){
		logger.info("Doing <goToCreateRequest>");
		kernelLogoButton.click();
		createRequestButton.click();
		return new KernelCreateRequestPage(this.browser).init(KernelCreateRequestPage.class);
	}

}
