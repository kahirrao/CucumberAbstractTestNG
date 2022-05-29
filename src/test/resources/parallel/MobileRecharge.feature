Feature: Amazon Mobile recharge Feature

Background: 
Given : User is already login to Amazon application
|username|password|
|9594037701|Kalpesh@90|


Scenario: Pay Mobile Recharge Bill
Given User clicks on Pay Utility Bills link	
And  User gets the title of page
Then Page title should be "Amazon Pay"
When User clicks on Mobile recharge link
When User enters Mobile phone number "9594037701"
And User clicks on Edit option to select operator/circle
And User selects operator Jio
And User selects state Mumbai
And User clicks on Rechanrge Amount
And User selects plan
And user clicks on signOut