Feature: login site

  Scenario: 0.1
    Given opened mainPage
    And go to road bikes page
    Then road bikes page is opened
    And choose any bike
    Then chosen bike is opened
    And increase quantity
    And add to basket
    Then error is displayed
    And return to main page