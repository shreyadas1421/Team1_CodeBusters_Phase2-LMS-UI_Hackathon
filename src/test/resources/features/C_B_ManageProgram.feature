Feature: Add New Program

  Background:
    Given Admin is on dashboard page after Login and clicks Program on the navigation bar

  Scenario: Validate Program Details Popup window
    Given Admin is on Manage Program Page
    When Admin clicks A New Program button
    Then Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window
