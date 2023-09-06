@homepage @NLSF-255 @search-and-browse @smoke-search-and-browse
Feature: [UI] NLSF-255 Testing of navigation between country sites
  As a user
  I want to test navigation between country sites
  So that I can verify lang, localisation, routing and store config

  Background: verify home page
    Given user navigates to homepage page on uk site

  Scenario: Test Case 001 verify homepage elements
    Then verify the details on homepage

  Scenario: Test Case 002 language button change
    When User clicks on De button
    Then page language changes to de
    When User clicks on En button
    Then page language changes to en
