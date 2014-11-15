package com.testproject;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ShareProduct {

	
	@Test
	public void shareBoseProduct() throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		RemoteWebDriver driver=new ChromeDriver(); 
	    driver.get("http://www.amazon.in" + "/ap/signin?_encoding=UTF8&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fcss%2Fhomepage.html%3Fie%3DUTF8%26ref_%3Dnav_yam_ya");
	    driver.findElementById("ap_email").clear();
	    driver.findElementById("ap_email").sendKeys("simonnicholas0404@gmail.com");
	    driver.findElementById("ap_password").clear();
	    driver.findElementById("ap_password").sendKeys("nicholas0404");
	    driver.findElementById("signInSubmit-input").click();
	 
	    driver.findElementById("signInSubmit-input").click();
	    driver.findElementById("twotabsearchtextbox").click();
	    driver.findElementById("twotabsearchtextbox").clear();
	    driver.findElementById("twotabsearchtextbox").sendKeys("bose");
	   
	   driver.findElementByCssSelector("input.nav-submit-input").click();
	   driver.findElementById("result_0").click();
	    //driver.findElementById("swfText").click();
	    driver.findElementById("swfRecTextarea").clear();
	    driver.findElementById("swfRecTextarea").sendKeys("simonnicholas0404@gmail.com");
	    driver.findElementById("swfSubmitButton-announce").click();


	}
}
