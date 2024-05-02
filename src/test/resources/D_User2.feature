@User2Page
Feature: User Delete  Page

Scenario: Validate row level delete icon
Given Admin is on Manage User Page
When Admin clicks the delete icon
Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion

Scenario: Click No on deletion window
Given  Admin is on Confirm Deletion alert in user
When Admin clicks <NO> button on the alert in User
Then Admin can see the deletion alert disappears without deleting

Scenario: Validate Close(X) icon on Confirm Deletion alert
Given Admin is on Confirm Deletion alert in user
When Admin clicks Close(X) Icon on Deletion alert
Then Admin can see the deletion alert disappears without deleting

Scenario: Click Yes on deletion window
Given Admin is on Confirm Deletion alert in user
When Admin clicks <YES> button on the alert
Then Admin gets a message "User Deleted" alert and do not see that user in the data table in user

Scenario: Validate Common Delete button enabled after clicking on any checkbox
Given Admin is on Manage User Page
When Admin clicks any checkbox in the data table in User page
Then Admin should see common delete option enabled under header Manage Program

Scenario: Validate multiple user deletion by selecting Single checkbox
Given Admin is on Confirm Deletion alert by click on delete all button in User
When Admin clicks <NO> button on the alert in User
Then Admin should land on Manage User page and can see the selected user is not deleted from the data table

Scenario: Validate multiple user deletion by selecting Single checkbox
Given Admin is on Confirm Deletion alert by click on delete all button
When Admin clicks <YES> button on the alert
Then Admin should land on Manage User page and can see the selected users are deleted from the data table


Scenario: Validate multiple user deletion by selecting multiple check boxes
Given Admin is on Confirm Deletion alert by click on delete all button in User ofter selecting multiple user
When Admin clicks <NO> button on the alert in User
Then Admin should land on Manage User page and can see the selected user is not deleted from the data table


Scenario: Validate multiple user deletion by selecting multiple check boxes
Given Admin is on Confirm Deletion alert by click on delete all button in User ofter selecting multiple user
When Admin clicks <YES> button on the alert
Then Admin should land on Manage User page and can see the selected users are deleted from the data table


Scenario: Sort user by id
Given Admin is on Manage User Page
When Admin clicks on ID sort icon
Then Admin should see User details are sorted by id

Scenario: Sort user by name
Given Admin is on Manage User Page
When Admin clicks on name sort icon
Then Admin should see User details are sorted by name

Scenario: Sort user by Location
Given Admin is on Manage User Page
When Admin clicks on Location sort icon
Then Admin should see User details are sorted by Location

Scenario:Sort user by Phone number
Given Admin is on Manage User Page
When Admin clicks on Phone number sort icon
Then Admin should see User details are sorted by Phone number










