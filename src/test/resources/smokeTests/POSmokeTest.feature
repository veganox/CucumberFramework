@smoke
Feature: PO Bean Smoke Test
Description: smoke test for beanworks


Background:
	Given user is on homepage
	And user enters his credentials
		| qbopocreator@pod101.com | Test1234& |
	And user has successfully login
	
Scenario: Purchase Order Creator should be able to create PO
	Given user is on Purchase Order creation page
	When user selects legalentity "US_NO_MULTI_CURRENCY" 
	And user selects vendor "Books by Bessie"
	And user enters "34.5"
	And user selects save
	Then purchase order should be created 
	And image buttons should appear
	
	

	  