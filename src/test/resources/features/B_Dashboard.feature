@Dashboard
Feature: Dashboard Page

  @Positive_01
  Scenario Outline: Verify after login  admin lands on manage program as dashboard page
     Given Admin is in Home Page
     When Admin enter valid credentials  and clicks login button  "<sheetname>" and <rownumber>
     Then Admin should see "<elements>" in dashboard page 
  
   Examples:
     | sheetname | rownumber |elements|
     | Login     |         1 |Manage Program|
     | Login     |         1 |LMS - Learning Management System|
  
  
  @Positive_02
  Scenario Outline: Validate alignment for navigation bar
     Given Admin is in Home Page
     When Admin enter valid credentials  and clicks login button  "<sheetname>" and <rownumber>
     Then Admin should see "<elements>" in the <number> of place
  
   Examples:
     | sheetname | rownumber |elements|number|
     | Login     |         1 |Program| 0|
     | Login     |         1 |Batch|1|
     | Login     |         1 |User|2|
     | Login     |         1 |Logout|3|
  
  
  @Positive_03
  Scenario Outline: Verify the response time
     Given Admin is in Home Page
     When Admin enter valid credentials & clicks login button  "<sheetname>" and <rownumber>
     Then Maximum navigation time in milliseconds, defaults to 30000 seconds
  
   Examples:
     | sheetname | rownumber |
     | Login     |         1 |
 
  @Positive_03
  Scenario Outline: Verify  LMS title alignment
     Given Admin is in Home Page
     When Admin enter valid credentials  and clicks login button  "<sheetname>" and <rownumber>
     Then LMS title should be on the top left corner of page
  
   Examples:
     | sheetname | rownumber |
     | Login     |         1 |
     
  @Positive_04
  Scenario Outline: Validate alignment for navigation bar
     Given Admin is in Home Page
     When Admin enter valid credentials  and clicks login button  "<sheetname>" and <rownumber>
     Then Admin should see the navigation bar text on the top right side
  
   Examples:
     | sheetname | rownumber |
     | Login     |         1 |