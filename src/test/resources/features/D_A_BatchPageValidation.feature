Feature: Batch Page Validation

  Background: Logged on the LMS portal

  Scenario: User login with valid credentials
    Given Admin is on dashboard page after Login01
    When Admin clicks Batch from navigation bar
    Then Admin should see the "Manage Batch" in the Header of manage batch page

  Scenario: Validate landing in Batch page
    Given Admin is on dashboard page after Login01
    When Admin clicks Batch from navigation bar
    Then Admin should see the "Manage Batch" in the Header of manage batch

  Scenario: Validate pagination in the Batch Page
    Given Admin is on dashboard page after Login01
    When Admin clicks Batch from navigation bar
    Then Admin should see the pagination controls under the data table on manage batch page

  #
  #validateDataTableHeader
  Scenario Outline: Validate data table headers in the Batch Page
    Given Admin is on dashboard page after Login01
    When Admin clicks Batch from navigation bar
    Then Admin Should see the data table on manage batch

  #Validate Delete button in Batch Page
  Scenario: Validate Delete button in data table of Manage batch
    Then Data table should have a delete icon that is enabled on manage batch

#Validate "+ A New batch" in Batch Page
Scenario: Validate "+ A New batch" in Batch Page
Then Admin should be able to see the + A New batch button on manage batch

#
#Validate data rows -ValidateCheckBox
Scenario: Validate checkbox in data table of Manage batch
Then Data table should have a checkbox on manage batch

#Validate data rows -ValidateEditButton
#Scenario: Validate Edit button in data table of Manage batch
#Then Data table should have a edit icon that is enabled on manage batch
#
#Validate data rows-ValidateDeleteButton
#Scenario: Validate Delete button in data table of Manage batch
#Then Data table should have a delete icon that is enabled on manage batch
#
#Validate pop up for adding batch
#Scenario: Validate pop up for adding batch
#When Admin clicks + A New Batch button
#Then A new pop up with "Batch Details" appears
#
#
#
#
#
#
