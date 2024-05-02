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
        |1|User Updated Successfully|
        |2|User Updated Successfully|
        |3|User Updated Successfully|
        |4|User Updated Successfully|
        |5|User Updated Successfully|
        |6|User Updated Successfully|

Scenario Outline: Check if the fields are updated with invalid values
    Given Admin is on Manage User Page
    When Update the fields with invalid values and click submit by reading from excel with <rowNumber>
    Then Admin gets "<expectedStatusCode>"
    
        Examples:
        |rowNumber|expectedStatusCode|
        |7|Enter phone no in this format (CountryCode)(PhoneNo)|
        |8|userLinkedinUrlmust contain www.linkedin.com|
        |9|Cannot deserialize value of type `long` from String|
        |10|Failed to update user, as 'TimeZone' is invalid !!|
        |11|Enter phone no in this format (CountryCode)(PhoneNo)|             

Scenario Outline: Check if the mandatory fields are updated with valid data
    Given Admin is on Manage User Page
    When Update the mandatory fields with valid values and click submit by reading from excel with <rowNumber>
    Then Admin gets "<expectedStatusCode>"
    
        Examples:
        |rowNumber|expectedStatusCode|
        |12|User Updated Successfully| 
        
Scenario Outline: Check if the optional fields are updated with valid data
    Given Admin is on Manage User Page
    When Update the optional fields with valid values and click submit by reading from excel with <rowNumber>
    Then Admin gets "<expectedStatusCode>"
    
        Examples:
        |rowNumber|expectedStatusCode|
        |13|User Updated Successfully|
        
Scenario Outline: Validate invalid values in the text fields
    Given Admin is on Manage User Page
    When Admin enters only numbers or special char in the text fields and click submit by reading from excel with <rowNumber>
    Then Admin gets "<expectedStatusCode>"
    
        Examples:
        |rowNumber|expectedStatusCode|
        |14|userFirstName must contain two or more alphabets only|
        |15|userFirstName must contain two or more alphabets only| 
        |16|userMiddleName must contain one or more alphabets only| 
        |17|userMiddleName must contain one or more alphabets only|
        |18|userLastName must contain one or more alphabets only|
        |19|userLastName must contain one or more alphabets only| 
        |20|Cannot deserialize value of type `long` from String| 
        |21|userLinkedinUrlmust contain www.linkedin.com|
        |22|userLinkedinUrlmust contain www.linkedin.com| 
        |23|userEduUg must begin with alphabet and can contain only alphanumeric characters| 
        |24|userEduPgmust begin with alphabet and can contain only alphanumeric characters|
        |25|Failed to update user, as 'TimeZone' is invalid !!| 
        |26|userComments must begin with alphabet and can contain only alphanumeric characters|
        
         
Scenario: Validate Cancel button on Edit popup
    Given Admin is on Manage User Page
    When Admin clicks Cancel button on edit popup
    Then Admin can see the User details popup disappears and can see nothing changed for particular User        
                            