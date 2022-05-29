package com.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MobileRechargePage {

	private WebDriver driver;

	private By Billpaymenulink = By.xpath("(//a[contains(text(),'Explore more from Amazon Pay')])[1]");
	private By circleAndOperator = By.xpath("//a[@id='operatorCircleLink']");
	private By SelectOperatorName = By.xpath("//div[@class='a-modal-scroller a-declarative']//div[3]//label[1]//i[1]");
	private By selectState = By.xpath("(//i[@class='a-icon a-icon-radio'])[22]");
	private By mobileRecharge = By.xpath("//span[contains(text(),'Mobile Recharge')]");
	private By mobilePhoneNumber = By.name("phoneNumber");
	private By rechargeAmount = By.xpath("//a[@id='viewPlanTriggerId']");

	public MobileRechargePage(WebDriver driver) {

		this.driver = driver;
	}
	
	public void clickPayUtilityBillsFastandConveniently() throws Exception {

		
		Thread.sleep(500);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,300)", " ");
	
		driver.findElement(Billpaymenulink).click();
		/*
		 * WebElement amazonPay = driver.findElement(Billpaymenulink); Actions act = new
		 * Actions(driver); act.moveToElement(amazonPay).build().perform();
		 * act.click(amazonPay);
		 */

	}

	public void clickMobileRecharge() {
		driver.findElement(mobileRecharge).click();
	}

	public void enterMobilePhoneNumber(String mobileno) {

		driver.findElement(mobilePhoneNumber).sendKeys(mobileno);
	}

	public void operatorCircle() throws Exception {

		driver.findElement(circleAndOperator).click();
		Thread.sleep(500);

	}

	public void selectOperator() {

		Actions act = new Actions(driver);

		WebElement operator = driver.findElement(SelectOperatorName);

		act.moveToElement(operator).click().build().perform();

	}

	public void selectState() throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");
		WebElement state = driver.findElement(selectState);
		Actions act = new Actions(driver);
		act.moveToElement(state).click().build().perform();
		Thread.sleep(500);
	}

	public void selectRechargeAmount() throws Exception {
		driver.findElement(rechargeAmount).click();
		Thread.sleep(500);
	}
	
	public void selectPlan() throws Exception {
		Thread.sleep(200);
		WebElement clicketPack = driver.findElement(By.xpath("//a[normalize-space()='Popular']"));
		WebElement clickPrice = driver.findElement(By.xpath("//input[@value='Popular~239~NA~28 Days~1013276~KOMPARIFY']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(clicketPack).perform();
		
		Thread.sleep(500);
		
		clickPrice.click();
		
	}
}
