Feature: Folder view functionality

  User story :As a user, I should be able to change folder
  view order by using Name/Size/Modified buttons

Background: User should log in
  Given  user is on Meetsky log in page and click tasks
  And user is on the all files list page



  @MEETS10-352
  Scenario:User can change folder view order by Name
    And user clicks on Name button
    Then user sees folder files in alphabetic order

  @MEETS10-355
  Scenario: User can change folder view order by Size
    Then user click size button and sees folder files in order based on their size

  @MEETS10-356
  Scenario: User can change folder view order by Modified
    Then user clicks on Modified button and user sees folder files in order based on their date

  @MEETS10-357
  Scenario: User can change the folder view
    When the user clicks the toggle-view button
    Then the folder view should change to grid view


  @MEETS10-358
  Scenario: Selecting all files and viewing total values
    When the user clicks on the select all checkbox
    Then all files in the list are selected
    And the total values of all selected files are displayed in the first line
