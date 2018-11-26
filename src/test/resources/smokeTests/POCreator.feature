@po
Feature: PO Bean Smoke Test
  Description: smoke test for beanworks

  Background: 
    Given user is on signinPage
    And pocreator enters his credentials
      | qbopocreator@pod101.com | Test1234& |

  Scenario Outline: Purchase Order Creator should be able to create PO
    Given POcreator has successfully login
    And user is on Purchase Order creation page
    When pocreator enters the value for "<legalentity>", "<vendor>", "<description>" in header
    And pocreator enters "<account>","<customer>", "<item>" and "<total>" in lineitem
    And user selects save po
    Then purchase order should be created

    Examples: 
      | legalentity          | vendor          | description   | account     | customer  | item          | total |
      | US_NO_MULTI_CURRENCY | Books by Bessie | Cucumber Test | Advertising | Cool Cars |               |  33.3 |
      | US_NO_MULTI_CURRENCY | Books by Bessie | Cucumber Test |             | Cool Cars | Rock Fountain |  33.3 |
