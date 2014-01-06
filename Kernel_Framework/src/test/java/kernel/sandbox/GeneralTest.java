package kernel.sandbox;

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
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GeneralTest{	
	
	public WebDriver browser = new KernelTest().getBrowser();
	
	
	 @After
	 public void tearDown(){		
		 this.browser.quit();
	 }

	 @SuppressWarnings("unused")
	@Test
     public void test() throws InterruptedException {
           browser.get("http://localhost:8080/dist/#login");
           browser.findElement(By.id("emailField")).sendKeys("2@gmail.com");
           browser.findElement(By.id("passwordField")).sendKeys("2@gmail.com");
           browser.findElement(By.id("signUp")).click();
           String message ="!!!!You entered a wrong username or password combination. Try again, or click the Forgot Password link.";
           try{
	           WebElement errorMessage = (new WebDriverWait(this.browser, 30)
				.until(ExpectedConditions.presenceOfElementLocated(By
						.xpath("//*[@class='mod-modal-wrapper error']//*[text()='"
								+ message + "']"))));
           }
           catch(TimeoutException e){
        	   System.out.println(e.getMessage());
        	   System.exit(0);
        	   
           }
           
           
           Thread.sleep(10000);
           
             
     }	
     
     
}

