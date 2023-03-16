Feature: As a user, I should be able to change profile info settings under the Profile module

  Scenario: as a user I should be able to see full name email phone number
    Given user is on the sign in page and type username and password
    And user is on the dashboard and user clicks settings
    Then user should see Full name Email Phone Number

  Scenario: as a user I should be able to change my username
    Given user is on the sign in page and type username and password
    And user is on the dashboard and user clicks settings
    Then user should be able to change full name to something else

  Scenario: as a user I should be able to make phone number as private
      Given user is on the sign in page and type username and password
      And user is on the dashboard and user clicks settings
      Then user should click phone number and pick the private


  Scenario: as a user I should be able to see local time under local dropdown
    Given user is on the sign in page and type username and password
    And user is on the dashboard and user clicks settings
    Then user should be able to see loca time