@invoice
Feature: Invoice Test
Description: invoice users login 

Background:
	Given user is on signinPage

Scenario: Invoice creator should be able to create new invoice
	Given user login to "invoice" successfully
	When user creates a new invoice 
	Then user should be able to submit the invoice for approval
	