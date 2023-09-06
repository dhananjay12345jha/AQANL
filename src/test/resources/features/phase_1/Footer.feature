Feature: [UI] Footer
AS A Customer
I WANT to see social media and app icons \ links in the footer
SO THAT I can follow New Look's social media activity based on the New Look site or download the New Look app

  @NLSF-595 @NLSF-622 @desktop @mobile @tablet @samsung @mac
  Scenario Outline: NLSF-595-AC1 - Desktop Social Links NLSF-622-AC1,AC3 - Footer Content Payment Types
    Given user navigates to my-account page on <site> site
    Then the footer links and icons are displayed
    And Payment types are in an order in the footer
    And the key copyright content is displayed
    Examples:
      | site |
      | uk   |
      | fr   |
      | de   |
      | row  |

  @NLSF-613 @NLSF-612 @NLSF-616 @NLSF-1439 @desktop @mobile @tablet @iphone @mac
  Scenario Outline: NLSF-612-AC1,AC2,AC4 NLSF-613-AC1,AC2,AC3,AC4,AC5 NLSF-616-AC1,AC2,AC3 - Delivery Country Selector
    Given user navigates to my-account page
    And I get pageoffset
    And verify Top Countries list in Delivery Country field
    When switch to <countrycode> Delivery Country
    Then verify user on the <country> site
    And verify the footer country change to <countrycode>
    And verify pageoffset
    Examples:
      | countrycode | country       |
      | fr          | fr/my-account |
      | gb          | uk/my-account |
#    | de          |

  @NLSF-612 @desktop @mobile @tablet @samsung @mac
  Scenario: NLSF-612-AC3,AC5 - Delivery Country Selector - close
    Given user navigates to my-account page
    When I open and close delivery country footer popup by clicking outside the popup
    Then the delivery country remains same
    When I open and close delivery country footer popup by clicking close popup
    Then the delivery country remains same

  @NLSF-614
  Scenario: NLSF-614-AC1,AC4,C2 - Delivery Country Search Input Results
    Given user navigates to my-account page
    When I open delivery country popup and search
    And I add character 'z' to the country search box
    Then 5 countries are displayed in the country results
    When I append character 'g' to the country search box
    Then 0 countries are displayed in the country results

  @NLSF-594 @desktop @mobile @tablet @iphone @mac @aaa
  Scenario: NLSF-594-AC1-AC2-AC3 - Footer Links
    Given user navigates to my-account page
    Then verify the footer links under vertical alignments/columns
    Then verify the bottom footer links

  @NLSF-616 @desktop @mobile @tablet @samsung
  Scenario: NLSF-616-AC4 - Delivery Country Selector – Do Not Confirm
    Given user navigates to my-account page
    When I open delivery country popup and search
    And I get pageoffset
    And select country fr from drop down list
    Then close Delivery Country Selector without confirming
    And verify user on the uk/my-account site
    And verify pageoffset

  @desktop @mobile @tablet @footer @NLSF-596 @NLSF-1266 @iphone
  Scenario Outline: NLSF-596-AC1,AC2,AC3,AC4,AC5,AC6 : check footer for sign up Newsletter
    Given user navigates to my-account page on <site> site
    Then I see a Newsletter sign-up section in the Footer
    And I am not able to enter the invalid email address and getting error message
    And The data layer error event is populated with the formError variables
    And I am able to enter my valid email address and clicked on signup button successfully
    Examples:
      | site |
      | uk   |
      | fr   |
      | de   |
      | row  |
    
  @desktop @NLSF-1439
  Scenario Outline: NLSF-1439 - Footer Country-Language Info - translations
   Given user navigates to <page> page on <site> site
   Then I see the language info displaying
   And I open delivery country popup and search 
   And I add character 'zyx' to the country search box
   And 0 countries are displayed in the country results  
   Examples:
      | site |page                      |
      | fr   |my-account-orders         |
      | fr   |orderDetails.homeDelivery |
      | fr   |orderDetails.collection   |
      | fr   |my-account                |
      | de   |my-account-orders         |
      | de   |orderDetails.homeDelivery |
      | de   |orderDetails.collection   |
      | de   |my-account                |
  
  @desktop @mobile @tablet @NLSF-1439 @samsung
  Scenario Outline: NLSF-1439 - Footer Country- Warning Message - translations
   When user navigates to <page> page on <site> site
   Then I see the warning message displaying
   Examples:
      | site |page                      |
      | fr   |my-account-orders         |
      | fr   |orderDetails.homeDelivery |
      | fr   |orderDetails.collection   |
      | fr   |my-account                |
      | de   |my-account-orders         |
      | de   |orderDetails.homeDelivery |
      | de   |orderDetails.collection   |
      | de   |my-account                |

  @desktop @mobile @tablet @footer @smoke @smoke-my-account @my-account @samsung
  Scenario Outline: [UI] Footer Smoke Test 1 : change delivery country on <countrycode> site by scrolling through the list
    Given user navigates to my-account page on uk site
    And Payment types are in an order in the footer
    And verify Top Countries list in Delivery Country field
    When switch to <countrycode> Delivery Country
    Then verify user on the <country> site
    And verify the footer country change to <countrycode>
    Examples:
      | countrycode | country       |
      | fr          | fr/my-account |
      | gb          | uk/my-account |

  @desktop @footer @smoke @smoke-my-account @my-account
  Scenario: [UI] Footer Smoke Test 2 : search delivery country on uk site
    Given user navigates to my-account page
    When I open delivery country popup and search
    And I add character 'G' to the country search box
    When I append character 'erm' to the country search box
    Then Germany country is displayed in the country search
    And I add character '' to the country search box
    Then all countries are displayed in the list