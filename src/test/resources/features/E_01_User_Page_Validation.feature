
Feature: User page validation

Background: 
    Given Logged on the LMS portal as admin


Scenario: Validate landing in User page
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar
    Then Admin should see the "Manage User" in the URL
    
Scenario: Validate the heading
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar
    Then Admin should see a heading with text "Manage User" on the page    

Scenario: Validate the text and pagination icon below the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar
    Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon below the table. 

Scenario: Validate data table headers in the User Page
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar
    Then Admin Should see the data table with column names Id, Name, location, Phone Number, Edit/Delete
    
Scenario: Validating the default state of Delete button
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar
    Then Admin should see a Delete button on the top left hand side as Disabled
    
Scenario: Validate "+ Add New user" button in User Page
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar
    Then Admin should be able to see the "+ Add New User" button above the data table

Scenario: Validate "+ Assign staff"  button in User page
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar
    Then Admin should be able to see the "+ Assign Staff" button above the data table

Scenario: Validate "+ Assign Student"  button in User page
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar
    Then Admin should be able to see the "+ Assign Student" button above the data table
    
Scenario: Validate search box in User page
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar
    Then Admin should be able to see the search text box above the data table
    
Scenario: Validate number of data rows in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar
    Then Admin should see two  records displayed on the data table
    
Scenario: Verify Check box on the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar
    Then Each row in the data table should have a checkbox
    
Scenario: Verify edit icon on the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar
    Then Each row in the data table should have a edit icon that is enabled
    
Scenario: Verify  delete icon on the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar
    Then Each row in the data table should have a delete icon that is enabled
    
Scenario: search user by name
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar
    When Admin enters user name into search box.
    Then Admin should see user displayed with the entered name
    
Scenario: Validating the Search with unrelated keyword
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar
    When Admin enters the keywords not present in the data table on the Search box
    Then Admin should see zero entries on the data table                                 
                