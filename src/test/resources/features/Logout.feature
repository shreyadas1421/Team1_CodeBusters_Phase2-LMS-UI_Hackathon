@Logout
Feature: LogOut

Background: Admin  is in dashboard page after logged in

 @Positive_01
 Scenario Outline: Verify Logout button function
     #Given Admin is in Home Page
     #When Admin enter valid credentials  and clicks login button  "<sheetname>" and <rownumber>
     When Admin click Logout button on navigation bar
     Then Admin should land on login in page 
     
     Examples:
     | sheetname | rownumber |
     | Login     |         1 |