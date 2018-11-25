@test
Feature: Invoice Creation
Description: Invoice creator can create and submit invoice for approval

Background: 
	Given user is on signin page
 	And user enters "invoicecreator@smoke.bean" and "pwd"
 	And user logins to "invoice" successfully
 	

Scenario: Invoice Creator should be able to create and submit an invoice
	Given user is on invoice page	
	When user uploads the image
	And codes that invoice with "<legalentity>", "<vendor>", "<date>", "<item>", "<total>"
	And submits it for approval
	Then status of invoice is "PendingApproval"

#After:
#logout the user
