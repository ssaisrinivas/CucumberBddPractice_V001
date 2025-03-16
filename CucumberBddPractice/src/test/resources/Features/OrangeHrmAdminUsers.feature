Feature: OrangeHRM-Admin-User

  Background: Below are the common steps for each scenario
    Given User launch chrome browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enters UserName as "Admin" and Password as "admin123"
    And Click on login
    Then User Can view DashBoard "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
    When User Click on the Admin Menu

  @sanity
  Scenario: Add a New Admin User
    And Click on the Add User
    Then User can view "https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser" Add new Admin users
    When Enter the Admin user info
    And click on save button
    Then User Can view the confirmation message
    And close browser

  @regression
  Scenario: Search Admin User by Username
    And Enter Admin user UserName
    When Click on the search button
    Then User Should found in the search table
    And close browser
