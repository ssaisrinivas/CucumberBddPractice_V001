Feature: OrangeHRMLogin Feature

  @sanity
  Scenario: Logo present on OrangeHRM home page
    Given I launch Chrome browser
    When I open orange hrm homepage
    Then I verify that logo present on the home page
    And Close browser

  @smoke
  Scenario: Successfully Login into OrangeHRM with Valid Credentials
    Given User launch chrome browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enters UserName as "Admin" and Password as "admin123"
    And Click on login
    Then Index page CurrentURL should be "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
    When User Click on logout link
    Then Login page CurrentURL Should be "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And close browser

  @regression
  Scenario Outline: Login into OrangeHRM with Valid Credentials By Data Driven
    Given User launch chrome browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enters UserName as "<email>" and Password as "<password>"
    And Click on login
    Then Index page CurrentURL should be "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
    When User Click on logout link
    Then Login page CurrentURL Should be "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And close browser

    Examples: 
      | email | password |
      | Admin | admin123 |
      | Admin | admin123 |
