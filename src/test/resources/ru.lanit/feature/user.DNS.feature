Feature: User bug red register user feature

  Scenario: Positive find phone by specified parameters
    Given I open DNS website
    When I choose mobil phone category
    And I filter catalog for samsung and 256 ГБ inner memory
    And I sort result of my choose to expensive first
    And I click to first card in phone's list
    Then in charateristice in phone card I see what model Of phone is samsung and memory is 256 ГБ


#  Scenario: Positive user registration custom cucumber expression
#    Given I open User Bug Red Registration page
#    When I register random user in Registration section on the Registration page
#    Then displayed username should be equal generated username in header on the Index page
#
#  Scenario Outline: Positive user registration data-driven
#    Given I open User Bug Red Registration page
#    When I enter '<username>' into username text field in Registration section on the Registration page
#    And I enter '<email>' into email text field in Registration section on the Registration page
#    And I enter '<password>' into password text field in Registration section on the Registration page
#    And I click on register button in Registration section on the Registration page
#    Then displayed username should be equal '<username>' in header on the Index page
#
#    Examples:
#      | username           | email                      | password |
#      | username1234561213 | username1234512312@mail.ru | 123456   |
#      | username7645434    | username7645434@mail.ru    | 123456   |
#      | username09876543   | username09876543@mail.ru   | 123456   |
#
#
#  Scenario: Positive user registration
#    Given I open User Bug Red Registration page
#    When I enter 'username12345611' into username text field in Registration section on the Registration page
#    And I enter 'username12345116@mail.ru' into email text field in Registration section on the Registration page
#    And I enter '123456' into password text field in Registration section on the Registration page
##    Then I check that all field filled correctly in Registration section on the Registration page не может быть проверки в серединие сценария
#    When I click on register button in Registration section on the Registration page
#    Then displayed username should be equal 'username12345611' in header on the Index page
#
#  Scenario:
#    Given I enter 'jdshdhshd' into password text field in Registration section on the Registration page
#    When I open User Bug Red Registration page
#    Then displayed username should be equal {string} in header on the Index page
