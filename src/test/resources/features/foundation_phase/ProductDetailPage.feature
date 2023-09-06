@search-and-browse @smoke-search-and-browse
Feature: [UI] NLSF-252 Add Selenium tests to run against the storefont
  As a user
  I want to open Pdp page
  So that I can check the page elements

  Background: User is on pdp page:
    Given user navigates to pdppage page on uk site

  Scenario: Test Case 001 Check pdp page details
    Then Page has the product details