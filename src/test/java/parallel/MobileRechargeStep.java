package parallel;


import com.pages.MobileRechargePage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.de.Wenn;
import io.cucumber.java.en.When; 

public class MobileRechargeStep {
	
	
	private MobileRechargePage mobirech = new MobileRechargePage(DriverFactory.getDriver());
	
	@When("User clicks on Pay Utility Bills link")
	public void User_clicks_on_Pay_Utility_Bills_link() throws Exception{
		Thread.sleep(500);
		mobirech.clickPayUtilityBillsFastandConveniently();
	}
	
	@When("User clicks on Mobile recharge link")
	public void user_clicks_on_mobile_recharge_link() throws Exception {
		mobirech.clickMobileRecharge();
	    
	}

	@When("User enters Mobile phone number {string}")
	public void user_enters_mobile_phone_number(String mobileno) {
	   mobirech.enterMobilePhoneNumber(mobileno);
	}

	@When("User clicks on Edit option to select operator\\/circle")
	public void user_clicks_on_edit_option_to_select_operator_circle() throws Exception  {
		mobirech.operatorCircle();
	}

	@When("User selects operator Jio")
	public void user_selects_operator() {
	   mobirech.selectOperator();
	}

	@When("User selects state Mumbai")
	public void user_selects_state() throws Exception {
		mobirech.selectState();
	}
	
	@When("User clicks on Rechanrge Amount")
	public void User_clicks_on_Rechanrge_Amount() throws Exception {
		mobirech.selectRechargeAmount();
	}
	
	@When("User selects plan")
	public void User_selects_plan() throws Exception {
		mobirech.selectPlan();
	}

}
 