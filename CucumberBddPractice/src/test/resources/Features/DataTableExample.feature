Feature: User Registration

  Scenario: User Registers with given details
    Given User is on Registration Page
    When User Enters following details
      | Sai Srinivas | automation | sai@gmail.com   |  22223 | Hyderabad |
      | Ravi Kiran   | Devlopment | ravi@gmail.com  | 994656 | Chennai   |
      | Krishna Rao  | HR         | kiran@gmail.com | 216564 | Banglore  |
    Then I validate the outcomes

  Scenario: User Registers with data coloumns
    Given User is on Registration Page
    When User Enters following details with colomns
      | firstname    | role       | emailid         | phonenumber | city      |
      | Sai Srinivas | automation | sai@gmail.com   |       22223 | Hyderabad |
      | Ravi Kiran   | Devlopment | ravi@gmail.com  |      994656 | Chennai   |
      | Krishna Rao  | HR         | kiran@gmail.com |      216564 | Banglore  |
    Then I validate the outcomes
