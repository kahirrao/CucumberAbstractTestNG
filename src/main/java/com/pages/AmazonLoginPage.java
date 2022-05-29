package com.pages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import net.sourceforge.tess4j.Tesseract;

public class AmazonLoginPage<ITesseract> {

	private WebDriver driver;

	private By signin = By.xpath("//a[@id='nav-link-accountList']");
	private By mobileno = By.xpath("//input[@id='ap_email']");
	private By password = By.xpath("//input[@id='ap_password']");
	private By cont = By.xpath("//input[@id='continue']");
	private By protectSignIn = By.xpath("//h1[normalize-space()='Sign-In']");
	private By submit = By.id("signInSubmit");
	private By captcha = By.id("auth-captcha-image");
	private By signout = By.xpath("//span[text()='Sign Out']");

	// WebElement accountandlist =
	// driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
//	WebElement signout = driver.findElement(By.xpath("//span[text()='Sign Out']"));

	public AmazonLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSignOut() throws InterruptedException {

		WebElement accountandlist = driver.findElement(signin);
		WebElement signoutlink = driver.findElement(signout);

		Actions act = new Actions(driver);

		act.moveToElement(accountandlist).build().perform();
		
		Thread.sleep(200);

		act.moveToElement(signoutlink).build().perform();

		signoutlink.click();
	}

	public void clickSignIn() {
		driver.findElement(signin).click();
	}

	public String loginPageTitle() throws Exception {

		Thread.sleep(3000);
		return driver.getTitle();
	}

	public void enterUserName(String username) {
		driver.findElement(mobileno).sendKeys(username);
	}

	public void clickContinue() {
		driver.findElement(cont).click();
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnSubmit() {
		driver.findElement(submit).click();
	}

	public AmazonyourOrderPage doLogin(String un, String pass) throws Exception {
		driver.findElement(signin).click();
		System.out.println(" Login with " + un + " and " + pass);
		driver.findElement(mobileno).sendKeys(un);
		driver.findElement(cont).click();
		driver.findElement(password).sendKeys(pass);
		driver.findElement(submit).click();
		
		 if(driver.findElements(protectSignIn) == null) 
			//  if(driver.findElements(protectSignIn).isEmpty())
			  {
		  driver.findElement(password).sendKeys(pass); Thread.sleep(2000);
		  try {
		  File src = driver.findElement(captcha).getScreenshotAs(OutputType.FILE);
		  String path = System.getProperty("user.dir") + "./screenshots/captcha.png";
		  FileHandler.copy(src, new File(path)); 
		  Tesseract image = new Tesseract();
		  String imageText=image.doOCR(new File(path));
		  System.out.println("Captcha Text :" + imageText);
		  driver.findElement(submit).click(); }
		  catch(Exception e) {
		  System.out.println("Captcha Security page is not found:"); 
		  }	  
		}
		 return new AmazonyourOrderPage(driver);
	}
}
