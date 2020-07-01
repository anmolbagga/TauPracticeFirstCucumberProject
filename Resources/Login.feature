Feature: Login Functionality 

	In order to do internet banking
	As a valid Para Bank customer
	I want to login unsuccessfully

# Scenario Example
@Login	
Scenario: Login Unsuccessful

Given I am in the login page of the Para Bank Application
When I enter invalid credentials
Then I see the error message