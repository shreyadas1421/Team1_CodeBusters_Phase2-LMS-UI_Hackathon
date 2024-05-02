
Feature: Edit Batch Details

  Background: Logged on the LMS portal
      Scenario: Click Search icon on batch page 
    Given Admin is on Manage User Page11
    When Admin clicks Batch from navigation bar
    Then Admin clicks on the Search icon on batch page if it is enabled
    
    Scenario: Enter Batch Name in Search input field
    When Admin Enter Batch name in search input field and Click on edit icon
    Then A new pop up with "Batch details" appears to edit
    
    Scenario Outline: Check if the fields are updated
    When Click save after updating the batch detail fields with valid values "<sheetname>" and <rownumber>
    Then The updated batch details should appear on the data table

    
       Examples: 
   						|sheetname|rownumber|
              |Batch|1|
              #|Batch|2|
              #|Batch|3|
              #|Batch|4|
              #|Batch|5|
       
    
    
    
    
    
  
  
  
      
      
      
      
