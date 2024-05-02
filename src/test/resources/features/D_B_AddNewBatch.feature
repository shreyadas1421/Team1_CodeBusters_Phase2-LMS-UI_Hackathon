
Feature: Add New Batch

Background: Logged on the LMS portal

Scenario: Check if the fields exist in pop1
Given Admin is on dashboard page after Login01
When Admin clicks Batch from navigation bar
Then Admin clicks + A New Batch button

 Scenario: Check if the fields exist in pop
 Then The pop up should include fields like Name Number of classes Description Status and Program Name in Mangage Batch
 

  
Scenario Outline: Check if the program details are added in data table
When Click on save after filling all the fields with valid values on batch details "<sheetname>" and <rownumber>
Then The newly added batch should be present in the data table in Manage Batch page
    Examples: 
   						|sheetname|rownumber|
              |Batch|1|
              #|Batch|2|
              #|Batch|3|
              #|Batch|4|
              #|Batch|5|
              #|Batch|6|
              #|Batch|7|
              #|Batch|8|
              #|Batch|9|

