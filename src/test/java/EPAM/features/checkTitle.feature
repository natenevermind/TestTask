Feature: Check if title on first opened page equals expected title

  Scenario: Check title of first link opened in google search

    Given Open https://www.google.com/
    When Enter text 'automation' in text Input
    And Click on search button
    And Open first link in search
    Then Title should contain word 'automation'
