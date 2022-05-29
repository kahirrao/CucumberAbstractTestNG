package com.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonyourOrderPage {
	
	private WebDriver driver;
	private By orderSection = By.cssSelector("li[role='tab']");
	private By orderpagelink = By.xpath("//span[text()='& Orders']");

	
	public AmazonyourOrderPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void returnandOrder(){
		
		driver.findElement(orderpagelink).click();
	}
	
	public String getAmazonyourOrderPageTitle() {
		
		return driver.getTitle();
		
	}
	
	public int getYourOrderSectionCount() {
		return driver.findElements(orderSection).size();
				
	}
	
	public List<String> getYourOrderPageHeaderList() {
		
		List<String> orderList = new ArrayList<>();
		
		List<WebElement> ordersHeaderlist = driver.findElements(orderSection);
		
		for (WebElement e: ordersHeaderlist ) {
			String text= e.getText();
			System.out.println(text);
			orderList.add(text);
		} 
		return orderList;
	}
	
}
