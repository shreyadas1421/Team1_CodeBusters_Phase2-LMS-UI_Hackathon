@Dashboard
Feature: Dashboard Page

  @Positive_01
  Scenario Outline: Verify after login  admin lands on manage program as dashboard page
     #Given Admin is in Home Page
     #When Admin enter valid credentials  and clicks login button  "<sheetname>" and <rownumber>
     Then Admin should see elements in dashboard page
     And LMS title should be on the top left corner of page
     And Admin should see the navigation bar text on the top right side
     And Admin should see elements in the number of place
       
   Examples:
     | sheetname | rownumber |
     | Login     |         1 |
   

  
  #@Positive_03
  #Scenario Outline: Verify the response time
     #Given Admin is in Home Page
     #When Admin enter valid credentials & clicks login button  "<sheetname>" and <rownumber>
     #Then Maximum navigation time in milliseconds, defaults to 30000 seconds
  #
   #Examples:
     #| sheetname | rownumber |
     #| Login     |         1 |
 #
  