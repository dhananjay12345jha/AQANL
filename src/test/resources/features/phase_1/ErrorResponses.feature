@local-only # These tests depend on error/timeout responses from the site. These tests currently can run on local chrome browser only. BrowserStack does not support this yet.
@error-response
Feature: My Order Page Error Responses
  AS A Hard-Logged In Customer
  I WANT to be advised when there has been a delay or issue with loading my orders on the My Orders page
  SO THAT I know that there has been a delay or issue, and what my next steps are

  @NLSF-752 @NLSF-753 @NLSF-822 @NLSF-929 @NLSF-1266
  Scenario Outline: NLSF-752-822-753-929 AC1 - error
    When user navigates to <page> page
    But the site has issues with the order on page <page>
    Then structure of my <page> is not compromised
    Then user is informed of the error and a try again link is displayed
    And The data layer error event is populated with the apiError variables
    Then click try again link to pull page again
    Examples:
      | page                           |
      | my-account-orders              |
      | orderDetails.homeDelivery      |
      | orderDetails.collection        |
      | my-account-contact-preferences |

  @NLSF-752 @NLSF-753 @NLSF-822 @NLSF-929
  Scenario Outline: NLSF-752-822-753-929 AC2 - inflight
    When user navigates to <page> page with slow internet connection
    Then inflight animation skeleton is displayed
    Then structure of my <page> is not compromised
    Examples:
      | page                           |
      | my-account-orders              |
      | orderDetails.homeDelivery      |
      | orderDetails.collection        |
      | my-account-contact-preferences |

  @NLSF-929
  Scenario: NLSF-929-AC3 -My Contact Preferences – Failure to Save
    Given user navigates to my-account-contact-preferences page
    Then select different selection for user multipleOrders
    But the site has issues with the order on page my-account-contact-preferences
    Then click Save Preferences button
    Then structure of my <page> is not compromised
    Then user is informed of the error and a try again link is displayed
    Then click try again link to pull page again

  @NLSF-929
  Scenario: NLSF-929-AC4 -My Contact Preferences – In Flight Saving
    Given user navigates to my-account-contact-preferences page
    Then select different selection for user multipleOrders
    Then click Save Preferences button with slow internet connection
    Then inflight animation skeleton is displayed

  @NLSF-506
  Scenario: NLSF-506-AC6 - My account recent orders error
    Given user navigates to my-account page
    But the site has issues with the order on page my-account
    Then user is informed of the error and a try again link is displayed

  @NLSF-770 #@NLSF-506 is deprecated NLSF-506-AC7 - My account recent orders timeout
  Scenario: NLSF-770 - AC1 – Recent Orders – In Flight
    When user navigates to my-account page with slow internet connection
    Then inflight animation skeleton is displayed
    
  @NLSF-1439
  Scenario Outline: NLSF-1439 - Error Messages - translations
    Given user navigates to <page> page on <site> site
    But the site has issues with the order on page <page>
    Then user is informed of the error and a try again link is displayed
    Then click try again link to pull page again
   Examples:
      | site |page                      |
      | fr   |my-account-orders         |
      | fr   |orderDetails.homeDelivery |
      | fr   |orderDetails.collection   |
      | de   |my-account-orders         |
      | de   |orderDetails.homeDelivery |
      | de   |orderDetails.collection   |
      
  #@NLSF-616 
  # Bug 2289 raised, once resolved then we will modify the case and include in Local Job run
  @wip # Some failures due to translations. TODO: Enable once translation work is done.
  Scenario: NLSF-616-AC6 - Delivery Country Selector – “Change Settings” In-Flight
    When user navigates to my-account page with slow internet connection
    Then inflight animation skeleton is displayed
    Then structure of my my-account is not compromised
    When I open delivery country popup and search
    When try to change to fr Delivery Country
    Then check page loading CTA animation
    Then check page skeleton structure not compromised when page time out
    When I open delivery country popup
    Then check page skeleton structure not compromised
    
  #@NLSF-616 
  # Bug 2289 raised, once resolved then we will modify the case and include in Local Job run
  Scenario: NLSF-616-AC5 - Delivery Country Selector – “Change Settings” Failure
    Given user navigates to my-account page
    But the site has issues with change setting footer on page my-account
    When I open delivery country popup and search
    When I change my delivery country to fr
    Then verify error message display on page
    Then click try again link to updating my delivery country
    And I open delivery country popup
    Then check page skeleton structure not compromised when page has error
    Given user navigates to my-account page
    When I open delivery country popup
    Then check page skeleton structure not compromised
        
  @NLSF-930
  Scenario: NLSF-930 AC1 – My Payment Cards – Failure
    Given user navigates to my-account-payment-cards page on uk site
    But the site has payment cards page issue
    Then structure of my my-account-payment-cards is not compromised
    And user able to see security message and Payment title
    And user is informed of the error and a try again link is displayed
    And click try again link to pull page again

      
  @NLSF-930
  Scenario: NLSF-930 AC2 – My Payment Cards– In Flight
    When user navigates to my-account-payment-cards page with slow internet connection
    Then inflight animation skeleton is displayed
    And structure of my my-account-payment-cards is not compromised
    And user able to see security message and Payment title

  @NLSF-551
  Scenario: NLSF-551 AC4 – My Payment Cards – Failure
    Given user navigates to my-account-payment-cards page on uk site as user with varietyOfSavedCards
    Then I can see a CTA to set other card as default
    But the site has payment cards page issue
    Then I click on card to make this as default card
    And I can see a failure message for saving the default card
    And I see failure message disappears after 5 sec

  @NLSF-1183
  Scenario Outline: NLSF-1183 AC9 – Recent search - Failure
   Given user navigates to <page> page on uk site
   But the site has issues with the recent searches
	 When I click on search bar 
	 Then I see there is no recent search list and clear link display 
	Examples:	 
      |page                      |
      |my-account-orders         |
      |orderDetails.homeDelivery |
      |orderDetails.collection   |
      |my-account                |

 @NLSF-550 @NLSF-1951
  Scenario Outline: NLSF-550 AC8 – Delete Payment Card– Failure, NLSF-1951 FR- Failed update message1
    Given user navigates to my-account-payment-cards page on <site> site as user with multipleOrders
    And user click CTA to delete default card for user multipleOrders
    But the site has payment cards page issue
    Then user click Delete CTA in Delete confirm pop to delete card
    Then verify on page remaining 1 cards and update failed
    Examples:
      | site |
      | fr   |

  @NLSF-550
  Scenario: NLSF-550 Delete Payment Card– In-Flight
    Given user navigates to my-account-payment-cards page on uk site as user with multipleOrders
    And page has slow internet connection issue
    And user click CTA to delete default card for user multipleOrders
    Then user click Delete CTA in Delete confirm pop to delete card
    And page has slow internet connection issue
    Then inflight animation skeleton is displayed

  @NLSF-1926
  Scenario: NLSF-1926 AC1 -My Personal Details - Failure
    Given user navigates to my-personal-details page on uk site as user with multipleOrders
    But the site has issues with the order on page my-personal-details
    And refresh page
    Then verify error message display on page
    Then check page skeleton structure not compromised for Personal Details page
    And user navigates to my-personal-details page
    Then click try again link to pull page again

  @NLSF-1926
  Scenario: NLSF-1926 AC2 -My Personal Details - In Flight
    Given user navigates to my-personal-details page on uk site as user with multipleOrders
    And page has slow internet connection issue
    And refresh page
    Then inflight animation skeleton is displayed
    Then check page skeleton structure not compromised for Personal Details page

  @NLSF-558
  Scenario Outline: NLSF-558 AC9 - Update Personal Details - Failure to Save on <site> site
    Given user navigates to my-personal-details page on <site> site as user with multipleOrders
    Then click Update Password link
    Then check page navigate to Update My Password form
    And user entered password in Current Password field and New Password field
    And page has slow internet connection issue
    And click Update Password button
    Then get error message in Personal Detail page
    Examples:
      | site |
      | uk   |

#this Story is done with workaround URL, this can be modify later once ticket NLSF-1849 available.
  @NLSF-1927
  Scenario Outline: NLSF-1927 AC2 My Addresses - In Flight
    Given user navigates to my-Address-loading page on <site> site as user with multipleOrders
    Then inflight animation skeleton is displayed
    Then structure of my <page> is not compromised
    And user able to see  My Address title

    Examples:
      | site |
      | uk   |
      | fr   |
      | de   |

#this Story is done with workaround URL and the try-again is not working since wiremock ticket yet to complete , this can be modify later once ticket NLSF-1849 available.
  @NLSF-1927
  Scenario Outline: NLSF-1927 AC1 My Addresses - failure
    Given user navigates to my-Address-failure page on <site> site as user with multipleOrders
    Then structure of my <page> is not compromised
    Then user is informed of the error and a try again link is displayed on page
    Then click try again link to pull MyaddressPage again

    Examples:
      | site |
      | uk   |
      | fr   |
      | de   |

  @NLSF-560
  Scenario: NLSF-560 AC5 - Update Personal Details - Failure to Save on <site> site
    Given user navigates to my-personal-details page on uk site as user with longName
    Then click Update Details link
    But the site has issues with the order on page my-personal-details
    And update all fields and submit
    Then get error message in Personal Detail page

    @NLSF-1723
    Scenario: NLSF-1723 AC1 My Account page - failure
      Given user navigates to my-account page on uk site
      But the site having issue with loading details on my-account page
      Then user is informed of the error and a try again link is displayed on page
      Then click try again link to pull page again for my-account

    @NLSF-1723
    Scenario: NLSF-1723 AC2 My Account page - In Flight
    When user navigates to my-account page with slow internet connection
    Then inflight animation skeleton is displayed
    And user able to see the title of my-account page