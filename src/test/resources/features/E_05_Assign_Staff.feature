@User_AssignStaff
Feature: Assign Student

  Background: 
    Given Admin is on dashboard page after Login and clicks User on the navigation bar

  @StaffAssign_01
  Scenario: Validate Assign Staff Popup window
    Given Admin is on Manage User Page
    When Admin clicks "Assign Staff" button
    Then Admin should see a pop up open for assign staff details with empty form along with Save and Cancel button and close (X) icon on the top right corner of the window
    
    @StaffAssign_02
  Scenario: Validate input fields and their text boxes in Assign Staff form 
    Given Admin is on Manage User Page
    When Admin clicks "Assign Staff" button
    Then Admin should see User Role as R02,and other fields Student Email id,Skill,Program Name,Batch Name and Status with respective input boxes.
    
     @StaffAssign_03
  Scenario: Validate Dropdown in Assign Staff Form
    Given Admin is on Manage User Page
    When Admin clicks "Assign Staff" button
    Then Admin should see drop down boxes with valid datas for Staff Email id,Program Name and Batch Name
     @StaffAssign_04
  Scenario: Validate radio button in Assign Staff Form
    Given Admin is on Manage User Page
    When Admin clicks "Assign Staff" button
    Then Admin should see two radio button for Status
    
    #@StaffAssign_05
  #Scenario: Empty Form Submission
    #Given Admin is in Assign Staff details pop up page
    #When Admin clicks "Save" button with entering any data
    #Then Admin gets a Error message alert for Staff
    #
     #@StaffAssign_06
  #Scenario: Validate the Assign Staff form page without giving Student Email id
    #Given Admin is in Assign Staff details pop up page
    #When Admin clicks "Save" button without entering Student Email id for Staff
    #Then Admin gets a Error message alert as "Staff Email id is required." for Staff
    #
    #@StaffAssign_07
  #Scenario: Validate the Assign Staff form page without giving Skill
    #Given Admin is in Assign Staff details pop up page
    #When Admin clicks "Save" button without entering Skill for Staff
    #Then Admin gets a Error message alert as "Skill is required" for Staff
    #
    #@StaffAssign_08
  #Scenario: Validate the Assign Staff form page without selecting Program
    #Given Admin is in Assign Staff details pop up page
    #When Admin clicks "Save" button without selecting program for Staff
    #Then Admin gets a Error message alert as "Program Name is required." for Staff
    #
    #@StaffAssign_09
  #Scenario: Validate the Assign Staff form page without selecting batch
    #Given Admin is in Assign Staff details pop up page
    #When Admin clicks "Save" button without selecting batch for Staff
    #Then Admin gets a Error message alert as "Batch Name is required." for Staff
    #
    #@StaffAssign_10
  #Scenario: Validate the Assign Staff form page without giving Status
    #Given Admin is in Assign Staff details pop up page
    #When Admin clicks "Save" button without giving status for Staff
    #Then Admin gets a Error message alert as "Status is required." for Staff
    #
     #@StaffAssign_11
  #Scenario: Validate Cancel/Close(X) icon on Assign Staff form
    #Given Admin is in Assign Staff details pop up page
    #When Admin clicks Close Icon on User Details form
    #Then Assign Staff popup window should be closed without saving
    #
    #@StaffAssign_12
  #Scenario: Validate Save button on Assign Staff form
    #Given Admin is in Assign Staff details pop up page
    #When Enter all the required fields with valid values and click Save button for staff
    #Then Admin gets a message "Successfully Staff Assigned" alert 
    #
    #@StaffAssign_13
  #Scenario: Validate Cancel button on Assign Staff form
    #Given Admin is in Assign Staff details pop up page
    #When Admin clicks Cancel button 
    #Then Admin can see the Assign Staff popup disappears without assigning  
