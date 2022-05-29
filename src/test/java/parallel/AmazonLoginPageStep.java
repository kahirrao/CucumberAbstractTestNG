package parallel;

import org.junit.Assert;

import com.pages.AmazonLoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonLoginPageStep {

	private AmazonLoginPage loginpage = new AmazonLoginPage(DriverFactory.getDriver());

	public static String title;

	@Given("User is on Amazon web page")
	public void user_is_on_amazon_web_page() throws InterruptedException {

		DriverFactory.getDriver().get("https://www.amazon.in/");
		Thread.sleep(2000);
	}

	@When("User gets the title of page")
	public void user_gets_the_title_of_amazon_web_page() throws Exception {

		title = loginpage.loginPageTitle();
		System.out.println("Login Page Title is: " + title);
	}

	@Then("Page title should be {string}")
	public void amazon_page_title_should_be(String expectedTitleName) {

		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("User clicks on Sign in")
	public void user_clicks_on_sign_in() throws InterruptedException {

		loginpage.clickSignIn();
		Thread.sleep(1000);
	}

	@When("User enters email or phone no as username {string}")
	public void user_enters_email_or_phone_no_as_username(String username) {
		loginpage.enterUserName(username);
		loginpage.clickContinue();
	}

	@When("User enters a password {string}")
	public void user_enters_a_password(String pwd) {
		loginpage.enterPassword(pwd);

	}

	@When("User clicks on Sign-In button")
	public void user_clicks_on_sign_in_button() {
		loginpage.clickOnSubmit();
	}

	@Then("user clicks on signOut")
	public void user_clicks_on_sign_out() throws InterruptedException {

		loginpage.clickSignOut();

	}

}
