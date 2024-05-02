
Feature: Delete Batch

  Background: Logged on the LMS portal
  Scenario: Click on delet icon
    Given Admin is on dashboard page after Login
    When Admin clicks Batch from navigation bar
    Then Admin clicks on the delete icon on batch page if it is enabled
#
  #Scenario: Validate row level delete icon to check Yes button
    #When Admin clicks Batch from navigation bar and clicks yes for delete batch
    #Then Verify if batch deleted scuccessfully
#
  #Scenario: Admin clicks delete icon to check No botton
    #When Admin click No Otion to delete batch
    #Then Batch delete popup should disappear
    #
