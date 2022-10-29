Feature: final task

  Scenario: 0.1
    Given opened mainPage
    When go to road bikes page
    Then road bikes page is opened
    When choose any bike
    Then chosen bike is opened
    And increase quantity
    When add to basket
    Then error is displayed
    And return to main page