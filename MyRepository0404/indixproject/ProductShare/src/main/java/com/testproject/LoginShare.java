package com.testproject;

import java.io.FileInputStream;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class LoginShare {
	Properties obj1=null;
	RemoteWebDriver driver=null;
	public LoginShare(){
		
	
	
	 obj1 = new Properties();
	 driver=new FirefoxDriver();
	}
	//private String loginUrL;
	
	
	public void ShareDetails () throws Exception{
	//Create Object of Properties Class.
	    
	  
	  //Create Object of FileInputStream Class. Pass file path.
	  FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\conf.properties");
	  
	  //Pass object reference OBJ file to load method of Properties object.
	  obj1.load(objfile);
	  
		// Instantiate FF driver
		
		driver.manage().window().maximize();
	}
	//login to amazon.in

public void login() throws Exception  {
ShareDetails();
  driver.get(Constants.loginUrL);
  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  driver.findElementById("ap_email").clear();
  driver.findElementById("ap_email").sendKeys(obj1.getProperty("userID"));
  driver.findElementById("ap_password").clear();
  driver.findElementById("ap_password").sendKeys(obj1.getProperty("PWD"));
  driver.findElementById("signInSubmit-input").click();
  Thread.sleep(5000);
} 
  
// click on the first listed search and mail the product 

public void Share(String prodSearchTxt)  {
  //search for product BOSE Product
  driver.findElementById("twotabsearchtextbox").click();
  driver.findElementById("twotabsearchtextbox").clear();
  driver.findElementById("twotabsearchtextbox").sendKeys(obj1.getProperty("prodSearchTxt"));
  driver.findElementByCssSelector("input.nav-submit-input").click();
  List<WebElement> searchElements = driver.findElements(By.xpath("//ul[@id='s-results-list-atf']/li")); 
  searchElements.get(Constants.prodIndex).findElement(By.tagName("a")).click();
  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  String shareUrl=driver.findElementById("swfText").getAttribute("href");
  driver.get(shareUrl);
  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  driver.findElementById("swfRecTextarea").clear();
  driver.findElementById("swfRecTextarea").sendKeys(obj1.getProperty("userID"));
  driver.findElementById("swfSubmitButton-announce").submit();
  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  //close the driver
  driver.close();
}

	}


