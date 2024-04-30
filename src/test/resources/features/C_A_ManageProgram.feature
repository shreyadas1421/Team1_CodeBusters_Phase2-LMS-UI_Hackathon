Feature: Manage Program Validation
#  Background: Logged on the LMS portal asProgram Module Admin
#    Given Logged on the LMS portal asProgram Module Admin
#    When User submits userName and password
#    Then User lands on dashboard page

 Background:
 Given Logged on the LMS portal as admin

  Scenario: Validate landing in Program page
    Given Program Module Admin is on dashboard page after Login
    When Program Module Admin clicks program link on the navigation bar
    Then Program Module Admin should see URL with Manage Program

#  Scenario: Validate the heading
#    Given Program Module Admin is on dashboard page after Login
#    When Program Module Admin clicks program link on the navigation bar
#    Then Program Module Admin should see a heading with text Manage Program on the page
#
#  Scenario: Validate the text and pagination icon below the data table
#    Given Program Module Admin is on dashboard page after Login
#    When Program Module Admin clicks program link on the navigation bar
#    Then Program Module Admin should see the text as Showing x to y of z entries along with Pagination icon below the table.x- starting record number on that page.y-ending record number on that page.z-Total number of records
## Tobe tested
##  Scenario: Validate the footer
##    Given Program Module Admin is on dashboard page after Login
##    When Program Module Admin clicks program link on the navigation bar
##    Then Program Module Admin should see the footer as "In total there are z programs".z- Total number of records
##
#  Scenario: Validating the default state of Delete button
#    Given Program Module Admin is on dashboard page after Login
#    When Program Module Admin clicks program link on the navigation bar
#    Then Program Module Admin should see a Delete button on the top left hand side as Disabled
#
#  Scenario: Validate Add New Program
#    Given Program Module Admin is on dashboard page after Login
#    When Program Module Admin clicks program link on the navigation bar
#    Then Program Module Admin should see a +A New Program button on the program page above the data table
#
#  Scenario: Validate that number of records (rows of data in the table) displayed
#    Given Program Module Admin is on dashboard page after Login
#    When Program Module Admin clicks program link on the navigation bar
#    Then Program Module Admin should see the number of records (rows of data in the table) displayed on the page are 5
##
#  Scenario: Verify data table on the Program page
#    Given Program Module Admin is on dashboard page after Login
#    When Program Module Admin clicks program link on the navigation bar
#    Then Program Module Admin should see data table on the Manage Program Page with following column headers (Program Name, Program Description, Program Status, Edit,Delete)
#
#  Scenario: Verify Sort arrow icon on the data table
#    Given Program Module Admin is on dashboard page after Login
#    When Program Module Admin clicks Program on the navigation bar
#    Then Program Module Admin should see the sort arrow icon beside to each column header except Edit and Delete
