Feature: Amazon Login Page Feature

Scenario: Amazon Login Page Title
Given User is on Amazon web page	
When  User gets the title of page
Then Page title should be "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"
And  User clicks on Sign in

Scenario: Amazon Login with correct credentials
Given User is on Amazon web page
And User clicks on Sign in
When User enters email or phone no as username "9594037701"
And 	User enters a password "Kalpesh@90"
And 	User clicks on Sign-In button
Then  User gets the title of page
And   Page title should be "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"
And user clicks on signOut