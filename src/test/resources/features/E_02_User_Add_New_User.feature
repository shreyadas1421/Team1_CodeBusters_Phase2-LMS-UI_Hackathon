Feature: Add new user

Background: 
    Given Admin is on dashboard page after Login and clicks User on the navigation bar


Scenario: Validate User Details Popup window
    Given Admin is on Manage User Page
    When Admin clicks "+ Add New User" button
    Then Admin should see pop up open for user details with First Name,Middle name, Last Name, Location, phone, email, linkedin url, User Role, Role status, visa status,Undergraduate, postgraduate,time zone ,user comments and user fields along with Cancel , Submit and close buttons
    Then Admin should see  text boxes for the fields First Name, Middle name, Last Name, Location,phone, email, linkedin url, Undergraduate, postgraduate,time zone ,user comments     
    Then Admin should see drop downs for the fields User Role,Role status, visa status on user details pop up

Scenario Outline: Check if user is created when only mandatory fields are entered with valid data
    Given Admin is on  User details pop up
    When Admin enters userdata in  fields in the create user form and clicks on submit button by rading from excel with <rowNumber>
    Then Admin gets "<expectedStatusCode>"   
    
   Examples:
						|rowNumber|expectedStatusCode|
						|1|User Added Successfully|
						|2|User Added Successfully|
						|3|User Added Successfully|
						|4|User Added Successfully|
						|5|User Added Successfully|
						|6|User Added Successfully|
						|7|User Added Successfully|
						|8|User Added Successfully|
						|9|User Added Successfully|
						|10|User Added Successfully|
						|11|User Added Successfully|
						|12|User Added Successfully|
						|13|User Added Successfully|
						
Scenario Outline: check if user is created when invalid data is entered in all of the fields
    Given Admin is on  User details pop up
    When Admin skips to add value in mandatory field in the create user form and clicks on submit button by rading from excel with <rowNumber>
    Then Admin should see error message below the test field and the field will be highlighed in red color
    Examples:
						|rowNumber|
						|14|
						
Scenario: Empty form submission
    Given Admin is on  User details pop up
    When Admin clicks on submit button without entering data 
    Then user won't be created and Admin gets error message
    
Scenario: Validate Cancel/Close(X) icon on User Details form
    Given Admin is on  User details pop up
    When Admin clicks Close Icon on User Details form 
    Then User Details popup window should be closed without saving
    
Scenario: Validate Cancel button on User Details form
    Given Admin is on  User details pop up
    When Admin clicks Cancel button  
    Then Admin can see the User details popup disappears without adding any user	
    
Scenario Outline: check if user is created when invalid data is entered in all of the fields
    Given Admin is on  User details pop up
    When Admin enters invalid data in all of the fields in the form and clicks on submit button by reading from excel with <rowNumber>
    Then Admin gets "<expectedStatusCode>"   
    
   Examples:
						|rowNumber|expectedStatusCode|
						|15|userFirstName must contain two or more alphabets only|
						|16|userMiddleName must contain one or more alphabets only|
						|17|userLastName must contain one or more alphabets only|
						|18|Cannot deserialize value of type `long` from String|
						|19|Enter phone no in this format (CountryCode)(PhoneNo)|
						|20|Enter phone no in this format (CountryCode)(PhoneNo)|
						|21|userLinkedinUrlmust contain www.linkedin.com|
						|22|userFirstName must contain two or more alphabets only|
						|23|userEduUg must begin with alphabet and can contain only alphanumeric characters|
						|24|userEduPgmust begin with alphabet and can contain only alphanumeric characters|
						|25|Failed to create user, as 'TimeZone' is invalid !!|
						|26|userComments must begin with alphabet and can contain only alphanumeric characters|
						|27|Failed to create user, as 'TimeZone' is invalid !!|
						
Scenario Outline:: Check if the user details are added in data table
    Given Admin is on  User details pop up
    When Fill in all the fields with valid values and click submit by reading from excel with <rowNumber> 
    Then The newly added user should be present in the data table in Manage User page						        	    						
    			Examples:
						|rowNumber|expectedStatusCode|
						|1|User Added Successfully|			