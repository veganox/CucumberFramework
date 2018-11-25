@invoice
Feature: Invoice Test
Description: invoice users login 


Scenario Outline: Valid users should be able to login and logout from beanworks
	Given user is on signinPage
 	When user enters "<username>" and "<password>"
 	Then user logins to "<userpage>" successfully
 	And user can logout successfully

 	Examples:
 	| username 												| password 	| userpage 			|
 	| invoicecreator@smoke.bean 			| pwd 			| invoice 			|
 	| invoiceapprover@smoke.bean 			| pwd 			| invoice 			|
 	