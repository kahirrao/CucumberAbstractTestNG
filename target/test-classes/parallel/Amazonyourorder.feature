Feature: Amazon Your Order Feature

Background: 
Given : User is already login to Amazon application
|username|password|
|9594037701|Kalpesh@90|

Scenario: Your order page title
Given User is on Your order page
When User gets the title of page
Then Page title should be "Your Orders"
And user clicks on signOut


Scenario: Your order section count 
Given User is on Your order page
Then User get your order section list
|Orders|
|Buy Again|
|Not Yet Shipped|
|Cancelled Orders|
And Amazon order section count is 5
And user clicks on signOut