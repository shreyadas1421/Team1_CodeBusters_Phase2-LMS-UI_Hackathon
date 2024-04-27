@Dashboard
Feature: Dashboard Page

 # @Positive_01
 # Scenario Outline: Verify after login  admin lands on manage program as dashboard page
 #    Given Admin is in Home Page
 #    When Admin enter valid credentials  and clicks login button  "<sheetname>" and <rownumber>
 #    Then Admin should see "<elements>" in dashboard page 
  
 #  Examples:
 #    | sheetname | rownumber |elements|
 #    | Login     |         1 |Manage Program|
 #    | Login     |         1 |LMS - Learning Management System|
  
  
  @Positive_01
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
  