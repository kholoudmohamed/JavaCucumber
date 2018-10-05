Feature: Login Feature
  This feature deals with login functionality of the application

  Scenario Outline: Login with invalid username and password
    Given I navigated to Login Page
    When I enter invalid <Username> and <Password>
    And I click on login button
    Then Login Error message should be displayed
    And Error message text is correct
    And Username and Password Icons changed to Error Mode
    And User should be directed to Login Error Page

    Examples:
    | Username                | Password      |
    | invalid                 | invalid       |
    | invalid@test.com        | invalid       |
    | invalid123              | invalid$$12   |