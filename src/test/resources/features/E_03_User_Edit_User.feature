Feature: Add new user

Background: 
    Given Admin is on dashboard page after Login and clicks User on the navigation bar


Scenario: Validate row level edit icon
    Given Admin is on Manage User Page
    When Admin clicks on the edit icon
    Then A new pop up with User details appears
    
Scenario Outline: Check if the fields are updated with valid data
    Given Admin is on Manage User Page
    When Update the fields with valid data and click submit by reading from excel with <rowNumber>
    Then Admin gets message "<expectedStatusCode>" and see the updated values in data table
    
        Examples:
        |rowNumber|expectedStatusCode|
        |1|User updated Successfully|
             
    