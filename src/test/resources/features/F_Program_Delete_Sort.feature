 @Program2Page
Feature: program2 Page
	
  @Positive
  
  
  Scenario: verify Next page link
Given  Admin is on Manage Program Page12
When Admin clicks Next page link on the program table 
Then Admin should see the Pagination has "Next" active link


Scenario: Verify Last page link
Given Admin is on Manage Program Page12
When Admin clicks Last page link
Then Admin should see the last page record on the table with Next page link are disabled


Scenario: Verify First page link
Given Admin is on last page of Program table
When Admin clicks First page link
Then Admin should see the previous page record on the table with pagination has previous page link

Scenario: Verify Start page link
Given Admin is on Previous Program page 
When Admin clicks Start page link
Then Admin should see the very first page record on the table with Previous page link are disabled
  
  
  Scenario: Validates Sorting(assending order of program name) on the Program Data table
Given Admin is on Manage Program Page12
When Admin clicks the sort icon of program name column
Then The data get sorted on the table based on the program name column values in ascending order

Then The data get sorted on the table based on the program name column values in descending order

Scenario: Validates Sorting(assending order of program desc) on the Program Data table
Given Admin is on Manage Program Page12
When Admin clicks the sort icon of program Desc column
Then The data get sorted on the table based on the program description column values in ascending order
Then The data get sorted on the table based on the program description column values in descending order


Scenario: Validates Sorting(descending order of program Status) on the Program Data table
Given Admin is on Manage Program Page12
When Admin clicks the sort icon of program status column
Then The data get sorted on the table based on the program status column values in ascending order
Then The data get sorted on the table based on the program status column values in descending order
  
  
  Scenario: Delete Feature
  Given  Admin is on Manage Program Page12 
  When Admin clicks <Delete> button on the data table for any row
  Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion
  
  Scenario: Validate details for Confirm Deletion form
  Given Admin is on Manage Program Page12 
  When Admin clicks <Delete> button on the data table for any row
  Then Admin should see a message "Are you sure you want to delete"
  
  Scenario: Click No on deletion window
  Given Admin is on Confirm Deletion alert
  When Admin clicks <NO> button on the alert
  Then Admin can see the deletion alert disappears without deleting
  
  Scenario: Validate Cancel/Close(X) icon on Confirm Deletion alert
  Given Admin click on delete button
  When Admin clicks Close(X) Icon on Deletion alert
  Then Admin can see the deletion alert disappears without deleting
  
  Scenario: Click Yes on deletion window
 	Given Admin click on delete button
  When Admin clicks <YES> button on the alert
  Then Admin gets a message "Program Deleted" alert and able to see that program deleted in the data table
  
  
 Scenario: Validate Common Delete button enabled after clicking on any checkbox
 Given  Admin is on Manage Program Page12
 When Admin clicks delete button under header after selecting the check box in the data table
 Then Admin should see common delete option enabled under header Manage Program
 
Scenario: Validate multiple program deletion by selecting Single checkbox and click on No
Given Admin is on Confirm Deletion alert by click on delete all button
When Admin clicks <NO> button on the alert
Then Admin should land on Manage Program page and can see the selected program is not deleted from the data table

Scenario: Validate multiple program deletion by selecting Single checkbox and click on Yes
Given Admin is on Confirm Deletion alert by ofter click on delete all button
When Admin clicks <YES> button on the alert
Then Admin should land on Manage Program page and can see the selected program is deleted from the data table


Scenario: Validate multiple program deletion by selecting multiple check boxes and click on No
Given Admin is on Confirm Deletion alert ofter selecting multiple programs and by click on delete all button
When Admin clicks <NO> button on the alert 
Then Admin should land on Manage Program page and can see the selected programs are not deleted from the data table

Scenario: Validate multiple program deletion by selecting multiple check boxes and click on Yes
Given Admin is on Confirm Deletion alert ofter selecting multiple programs and click on multiple  delete button 
When Admin clicks <YES> button on the alert
Then Admin should land on Manage Program page and can see the selected programs are deleted from the data table


Scenario: Batch link on navigation bar
Given  Admin is on Manage Program Page12
When Admin clicks on Batch link on Manage Program page
Then Admin is re-directed to Batch page

Scenario: User link on navigation bar
Given  Admin is on Manage Program Page12
When Admin clicks on User link on Manage Program page
Then Admin is re-directed to User page

#Scenario: Logout link on navigation bar
#Given Admin is on Manage Program Page12
#When Admin clicks on Logout link on Manage Program page
#Then Admin is re-directed to Login page



#
#
 
 
 
 
 
 
 
 
 
 