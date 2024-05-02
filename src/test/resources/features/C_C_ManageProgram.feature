Feature: Edit Program Details

  Background:
    Given Admin is on Manage Program Page after clicks Program on the navigation bar

  Scenario:  Validate Edit Feature
    Given  Admin is on Manage Program Page
    When  Admin clicks Edit button on the data table for any row
    Then  Admin should see a popup open for Program details to edit

  Scenario:  Edit Program Name
    Given  Admin is on Program Details Popup window to Edit
    When  Admin edits the Name column and clicks save button
    Then  Admin gets a message Successful Program Updated alert and able to see the updated name in the table for the particular program

  Scenario:  Edit Program description
    Given  Admin is on Program Details Popup window to Edit
    When  Admin edits the Description column and clicks save button
    Then  Admin gets a message Successful Program Updated alert and able to see the updated description in the table for the particular program

  Scenario:  Change Program Status
    Given  Admin is on Program Details Popup window to Edit
    When  Admin changes the Status and clicks save button
    Then  Admin gets a message Successful Program Updated alert and able to see the updated status in the table for the particular program

  Scenario:  Validate invalid values on the text column
    Given  Admin is on Program Details Popup window to Edit
    When  Admin enters only numbers or special char in name and desc column
    Then  Admin gets a Error message alert

  #Scenario:  Validate Cancel button on Edit popup
    #Given  Admin is on Program Details Popup window to Edit
    #When  Admin clicks Cancel button on edit popup
    #Then  Admin can see the Program details popup disappears and can see nothing changed for particular program
#
  #Scenario:  Validate Save button on Edit popup
    #Given  Admin is on Program Details Popup window to Edit
    #When  Admin clicks Save button on edit popup
    #Then  Admin gets a message Successful Program Updated alert and able to see the updated details in the table for the particular program
