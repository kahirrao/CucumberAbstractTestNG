package parallel;

import org.testng.Assert;

import com.pages.AddProductPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddPrdoduct {

	private AddProductPage productPage = new AddProductPage(DriverFactory.getDriver());

	@Given("User enters {string} in search field and press enter")
    public void user_searches_for(String historyBook) {
	    
		productPage.searchText(historyBook);
		
	}
		
		@When("User searches for a {string} and selects the book")
		public void user_searches_for_a_and_selects_the_book(String selFirstBook) {

		System.out.println("Book Name:" + selFirstBook);
		productPage.selectHistoryBook(selFirstBook);
		
	}
		
		@When("User adds book to shopping cart")
		public void user_adds_book_to_shopping_cart() {
		   
			productPage.addBookToCart();
}

		@Then("User should see the book in my shopping cart")
		public void user_should_see_the_book_in_my_shopping_cart() {
		   
			productPage.checkshoppingcartDetails();
	
		}


}