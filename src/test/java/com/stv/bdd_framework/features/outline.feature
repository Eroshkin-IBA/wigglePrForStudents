Feature: home work

  Scenario Outline: incorrect auth
    Given opened mainPage
    And go to login page
    When customer enters incorrect email "<email_address>"
    And enters incorrect password "<password>"
    And clicks "Sign in securely"
    Then error message appears

    Examples:
      | email_address        | password |
      | incorrect_email@gmail.com | dasfasfdasfd   |

  Scenario: Successful Customer's authentication
    Given login page
    When customer enters correct email and password
    And clicks "Sign in securely"
    Then account page is opened
    And logout