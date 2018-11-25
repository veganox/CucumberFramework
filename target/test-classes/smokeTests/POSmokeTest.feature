@smoke
Feature: PO Bean Smoke Test
Description: smoke test for beanworks


Background:
	Given user is on homepage
	
Scenario: Purchase Order Creator should be able to create PO
	Given user enters his credentials
		| qbopocreator@pod101.com | Test1234& |
	And user has successfully login
	And user is on Purchase Order creation page
	
	When user selects legalentity "US_NO_MULTI_CURRENCY" 
	And user selects vendor "Books by Bessie"
	And user enters "Cucumber Test" under header description
	And user sets Billable to "Yes"
	And user sets Customer to "Bill's Windsurf Shop"
	And user sets Total to "34.5"
	And user selects save
	Then purchase order should be created 
	And image buttons should appear
	

	  