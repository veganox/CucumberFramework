@Login
Feature: Login Logout Test
Description: login logout test for beanworks


Scenario Outline: Valid users should be able to login and logout from beanworks
	Given user is on signin page
 	When user enters "<username>" and "<password>"
 	Then user logins to "<userpage>" successfully
 	And user can logout successfully

 	Examples:
 	| username 									| password 	| userpage |
 	| invoicecreator@smoke.bean | pwd 			| invoicemodule |
 	| pocreator@smoke.bean 			| pwd 			| pomodule |
 	| paymentcreator@smoke.bean | pwd 			| paymentmodule |
 	