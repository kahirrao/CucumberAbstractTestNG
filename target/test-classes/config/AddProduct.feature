Feature: 
In order to purchase the books
User adds the book to the shopping cart


Background: 
Given : User is already login to Amazon application
|username|password|
|kalpeshahirrao10@gmail.com|Kalpesh@90|
And  User gets the title of page
Then Page title should be "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"

Scenario Outline: User can add multiple books to the shopping cart 
Given User enters "history book" in search field and press enter
And  User gets the title of page
And Page title should be "Amazon.in : history book"
When User searches for a "<Books>" and selects the book
And User adds book to shopping cart
Then User should see the book in my shopping cart
Examples:
|Books|
|A Short History of the World|
|War & Peace|

