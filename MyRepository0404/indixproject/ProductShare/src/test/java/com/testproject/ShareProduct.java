package com.testproject;

/*
 * Test to search a product and share to self account in amazon.in
 */
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ShareProduct {

	
	@Test
	public void shareBoseProduct() throws Exception{
		
		// Instantiate FF driver
		RemoteWebDriver driver=new FirefoxDriver(); 
		driver.manage().window().maximize();
		//login to amazon.in
	    driver.get(Constants.loginUrL);
	    driver.findElementById("ap_email").clear();
	    driver.findElementById("ap_email").sendKeys(Constants.userID);
	    driver.findElementById("ap_password").clear();
	    driver.findElementById("ap_password").sendKeys(Constants.PWD);
	    driver.findElementById("signInSubmit-input").click();
	    Thread.sleep(5000);
	    //search for product bose
	    driver.findElementById("twotabsearchtextbox").click();
	    driver.findElementById("twotabsearchtextbox").clear();
	    driver.findElementById("twotabsearchtextbox").sendKeys(Constants.prodSearchTxt);
	    driver.findElementByCssSelector("input.nav-submit-input").click();
	    
	    // click on the first listed search
	    List<WebElement> searchElements = driver.findElements(By.xpath("//ul[@id='s-results-list-atf']/li")); 
	    searchElements.get(Constants.prodIndex).findElement(By.tagName("a")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    //share via email
	    String shareUrl=driver.findElementById("swfText").getAttribute("href");
	    driver.get(shareUrl);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElementById("swfRecTextarea").clear();
	    driver.findElementById("swfRecTextarea").sendKeys(Constants.userID);
	    driver.findElementById("swfSubmitButton-announce").click();
	    //close the driver
	    driver.close();


	}
}
