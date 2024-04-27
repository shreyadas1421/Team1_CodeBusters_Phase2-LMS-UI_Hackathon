@LogInPage
Feature: Home Page Verification

  @Positive_01
  Scenario Outline: Verify admin is able to land on home page
  Given Admin launch the browser
  When Admin gives the correct LMS portal URL
  Then Admin should land on the home page with all "<elements>"
   
   Examples:
    | elements        |
    | pageTittle      |
    | logo            |
    | LoginText       |
    | countofTxtField |
   	|Login|
		|User|
		|Password|     
  
 # Scenario: Verify admin is able to land on home page with invalid URL
 # Given Admin launch the browser
 # When Admin gives the invalid LMS portal URL
 # Then Admin should recieve 404 page not found error 
   
  
  #@Positive_02 
   #Scenario Outline: Verify the alignment of the login button
   #Given Admin launch the browser
   #When Admin gives the correct LMS portal URL
   #Then Admin should see "<elements>" on the centre of the page 
    
   #Examples:
    #| elements|
    #| Login      |  
    #| TextFields |
   
  #@Positive_03
  #Scenario Outline: Validate login with valid credentials
   # Given Admin is in Home Page
    #When Admin enter valid credentials  and clicks login button  "<sheetname>" and <rownumber>
    #Then Admin should land on dashboard page
  
   #Examples:
    # | sheetname | rownumber |
     #| Login     |         1 |
  
  #@Positive_04
 	#	Scenario Outline: verify login button action through keyboard
  #	Given Admin is in Home Page
  #  When Admin enter valid credentials  and clicks login button through keyboard "<sheetname>" and <rownumber>
 	#	Then Admin should land on dashboard page
   
  #  Examples:
  #   | sheetname | rownumber |
  #   | Login     |         1 |
  
 # @Positive_05  
  # Scenario Outline: verify login button action through mouse
  	#Given Admin is in Home Page
    #When Admin enter valid credentials  and clicks login button through mouse "<sheetname>" and <rownumber>
 		#Then Admin should land on dashboard page
 		
 		#Examples:
     #| sheetname | rownumber |
     #| Login     |         1 |
 		
   #@Negative_01
   #Scenario Outline: Validate login with invalid credentials
   #Given Admin is in Home Page
   #When Admin enter invalid credentials  and clicks login button   "<sheetname>" and <rownumber>
 	 #Then Validate "<Errormessage>" in login failure please check username/password
     
    #Examples:
     #  | sheetname | rownumber |Errormessage|
     # | Login     |         2 |please check username/password|
 
  #@Negative_02
  #Scenario Outline: Validate login credentials with null username
   # Given Admin is in Home Page
    #When Admin enter value only in password and clicks login button   "<sheetname>" and <rownumber>
    #Then Validate "<Errormessage>" in login failure please check username/password

    #Examples: 
     # | sheetname | rownumber | Errormessage|
      #| Login     |         3 | Please enter your user name|

  #@Negative_03
  #Scenario Outline: Validate login credentials with null password
   #Given Admin is in Home Page
   #When Admin enter value only in username and clicks login button   "<sheetname>" and <rownumber>
   #Then Validate "<Errormessage>" in login failure please check username/password

   #Examples: 
    #  | sheetname | rownumber |Errormessage|
     # | Login     |         4 ||
