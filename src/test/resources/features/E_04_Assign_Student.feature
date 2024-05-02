@User_AssignStudent
Feature: Assign Student

  Background: 
    Given Admin is on dashboard page after Login and clicks User on the navigation bar

  @StudentAssign_01
  Scenario: Validate Assign Student Popup window
    Given Admin is on Manage User Page
    When Admin clicks "Assign Student" button
    Then Admin should see a pop up open for assign student

  @StudentAssign_02
  Scenario: Validate input fields and their text boxes in Assign Student form
    Given Admin is on Manage User Page
    When Admin clicks "Assign Student" button
    Then Admin should see User Role as R03,and other fields Student Email id,Program Name,Batch Name and Status with respective input boxes.

  @StudentAssign_03
  Scenario: Validate Dropdown in Assign Student Form
    Given Admin is on Manage User Page
    When Admin clicks "Assign Student" button
    Then Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name

  @StudentAssign_04
  Scenario: Validate radio button in Assign Student Form
    Given Admin is on Manage User Page
    When Admin clicks "Assign Student" button
    Then Admin should see two radio button for Status
   
   @StudentAssign_05
  Scenario: Empty Form Submission
    Given Admin is in Assign Student details pop up page
    When Admin clicks "Save" button with entering any data
    Then Admin gets a Error message alert1	
    
    #@StudentAssign_06
  #Scenario: Validate the Assign Student form page without giving Student Email id
    #Given Admin is in Assign Student details pop up page
    #When Admin clicks "Save" button without entering Student Email id
    #Then Admin gets a Error message alert as "Student Email id is required"
    #@StudentAssign_07
  #Scenario: Validate the Assign Student form page without selecting Program
    #Given Admin is in Assign Student details pop up page
    #When Admin clicks "Save" button without selecting program
    #Then Admin gets a Error message alert as "Program Name is required."
    #
     #@StudentAssign_08
  #Scenario: Validate the Assign Student form page without selecting batch
    #Given Admin is in Assign Student details pop up page
    #When Admin clicks "Save" button without selecting batch
    #Then Admin gets a Error message alert as "Batch Name is required."
    #
     #@StudentAssign_09
  #Scenario: Validate the Assign Student form page without giving Status
    #Given Admin is in Assign Student details pop up page
    #When Admin clicks "Save" button without giving status
    #Then Admin gets a Error message alert as "Status is required."
    #
    #@StudentAssign_10
  #Scenario: Validate Cancel/Close(X) icon on Assign Student form
    #Given Admin is in Assign Student details pop up page
    #When Admin clicks Close Icon on User Details form
    #Then Assign Student popup window should be closed without saving
    #
     #@StudentAssign_11
  #Scenario: Validate Save button on Assign Student form
    #Given Admin is in Assign Student details pop up page
    #When Enter all the required fields with valid values and click Save button1
    #Then Admin gets a message "User has been successfully assigned/Updated to Program/Batch(es)" alert
    #
    #@StudentAssign_12
  #Scenario: Validate Cancel button on Assign Student form
    #Given Admin is in Assign Student details pop up page
    #When Admin clicks Cancel button 
    #Then Admin can see the Assign Student popup disappears without assigning 
    
    
