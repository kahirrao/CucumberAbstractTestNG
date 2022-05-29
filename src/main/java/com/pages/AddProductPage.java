package com.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AddProductPage {

	WebDriver driver;

	private By serchTextBox = By.id("twotabsearchtextbox");
	private By historyOfWorld = By.xpath(
			"(//span[@class='a-size-medium a-color-base a-text-normal'][normalize-space()='A Short History of the World'])[1]");
	private By warandPeace = By.xpath("//span[text()='War & Peace']");
	private By thePrince = By.xpath("//span[text()='The Prince']");
	private By addCart = By.id("add-to-cart-button");
	private By shoppingCart = By.xpath("(//span[@class = 'nav-line-2'])[3]");
	private By itemInshoppingcart = By.xpath("(//h1[normalize-space()='Shopping Cart'])[1]");

	public AddProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchText(String historyBook) {

		driver.findElement(serchTextBox).sendKeys(historyBook);

		driver.findElement(serchTextBox).sendKeys(Keys.ENTER);
	}

	public void selectHistoryBook(String selBook) {

		driver.findElement(historyOfWorld).click();
		
		driver.findElement(warandPeace).click();
	

	}

	public void addBookToCart() {

		String partentWindow = driver.getWindowHandle();
		System.out.println("Parent Window ID : " + partentWindow);

		Set st = driver.getWindowHandles();

		Iterator it = st.iterator();

		while (it.hasNext()) {

			String childWindow = (String) it.next();

			if (!partentWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println("Child Window:" + driver.getWindowHandle());
				driver.findElement(addCart).click();
				driver.close();
			}
		}
		driver.switchTo().window(partentWindow);
		driver.navigate().refresh();
		driver.findElement(shoppingCart).click();
	
	}

	public void checkshoppingcartDetails() {

	String pagesource = driver.getPageSource();
	
	String textToCheck = "Shopping Cart";
	
	boolean isTextPresent = pagesource.contains(textToCheck);
	
	System.out.println("Result:" + isTextPresent);
	}

}
