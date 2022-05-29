package parallel;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.pages.AmazonLoginPage;
import com.pages.AmazonyourOrderPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AmazonOrderStep {

	private AmazonLoginPage loginpage = new AmazonLoginPage(DriverFactory.getDriver());
	private AmazonyourOrderPage orderpage;
	private String expString;
	private String actString;

	@Given(": User is already login to Amazon application")
	public void user_is_already_login_to_amazon_application(DataTable credTable) throws Exception {
		List<Map<String, String>> credList = credTable.asMaps();
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		DriverFactory.getDriver().get("https://www.amazon.in/");
		orderpage = loginpage.doLogin(username, password);
		Thread.sleep(2000);

	}

	@Given("User is on Your order page")
	public void user_is_on_your_order_page() {

		orderpage.returnandOrder();
		orderpage.getAmazonyourOrderPageTitle();
	}

	@Then("User get your order section list")
	public void user_get_your_order_section_list(DataTable sectionTable) {

		List<String> expectedAccountSectionList = sectionTable.asList();
		System.out.println("Expected accout section list:" + expectedAccountSectionList);

		List<String> actualAccountSectionList = orderpage.getYourOrderPageHeaderList();
		System.out.println("Actual accout section list Before:" + actualAccountSectionList);
		actualAccountSectionList.remove(0);
		System.out.println("Actual accout section list After:" + actualAccountSectionList);
		
		Assert.assertEquals(actualAccountSectionList, expectedAccountSectionList);
	}

	@Then("Amazon order section count is {int}")
	public void amazon_order_section_count_is(Integer expectedsectioncount) {

		Assert.assertTrue(orderpage.getYourOrderSectionCount() == expectedsectioncount);
	}

}
