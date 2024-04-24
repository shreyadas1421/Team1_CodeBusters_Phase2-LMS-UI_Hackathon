@LogInPage
Feature: LogInPage

  @Positive
  Scenario Outline: User login with valid credentials
    Given user navigate to the login page 
    When user enter valid user id & password "<sheetname>" and <rownumber> 
    Then user should be in home page

 Examples:
						|sheetname|rownumber|
						|Login|1|