Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initialize the chrome browser
And Navigate to "http://qaclickacademy.com" Site
And Click on Login lnk in home page to land on Secure sign in page
When User enters <username> and <password> and logs in
Then Verify that user is successfully logged in
And close browsers

Examples:
|username	        |password	|
|test99@gmail.com	|123456	    |
|test123@gmail.com	|12345		|
