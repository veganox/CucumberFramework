@login
Feature: Login Logout Test
Description: login logout test for beanworks


Scenario Outline: Valid users should be able to login and logout from beanworks
	Given user is on signinPage
 	When user enters "<username>" and "<password>"
 	Then user should login to "<userpage>" successfully
 	And user can logout successfully

 	Examples:
 	| username 									| password 	| userpage 			|
 	| invoicecreator@smoke.bean | pwd 			| invoice 			|
 	| pocreator@smoke.bean 			| pwd 			| purchaseorder |
 	| paymentcreator@smoke.bean | pwd 			| payment 			|
 	