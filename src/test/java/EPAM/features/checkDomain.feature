Feature:  Check if expected domain present on first 5 pages of search results

  Scenario: Check domain on pages 1-5 in google search

    Given Open https://www.google.com/
    When Enter text 'automation' in text Input
    And Click on search button in Google
    Then Expected domain 'testautomationday.com' should be present on pages 1-5