Feature: [UI] My Account Home
  AS A Hard-Logged In Customer
  I want to see that I have no recent orders in My Account
  SO THAT I have confirmation that I have not placed any recent orders on NewLook.com

  @NLSF-507
  Scenario: NLSF-507-AC1 - My account no recent orders
    Given user navigates to my-account-no-order page as user with noOrders
    Then page displayed with no recent orders

  @NLSF-509 @NLSF-513
  Scenario: NLSF-513 - AC1-View Order (My Orders CTA) NLSF-509-AC1 - My account view order
    Given user navigates to my-account page
    When user clicks on first view order link
    Then order details page displayed

  @NLSF-508 @NLSF-512
  Scenario: NLSF-508-AC1 - My account, My order view orders NLSF-512-AC1 – My Orders AC2 – My Orders Page – Desktop
    Given user navigates to my-account page
    When page displayed with recent orders in descending order
    Then user navigates to my-account-orders page
    And page displayed with all orders in descending order
    And dispatched order displayed
    And orders table has order details Columns

  @NLSF-508 @NLSF-515
  Scenario: NLSF-508-AC2 NLSF-515-AC1,AC2 - My account, My order no recent orders
    When user navigates to my-account-orders-no-order page as user with noOrders
    Then orders page displayed with no orders with shop now button displayed

  @NLSF-505
  Scenario: NLSF-505-AC1,AC2,AC3,AC4,AC5,AC6,AC7,AC8 MyAccount HomePage
    Given user navigates to my-account page
    When user clicks and verifies homepage icons
      | My_Orders               |
      | My_Addresses            |
      | My_Payment_Cards        |
      | My_Personal_Details     |
      | Saved_Collection_Points |
      | My_Saved_Items          |
      | My_Delivery_Pass        |
      | My_Contact_Preferences  |
    
  @desktop @mobile @tablet @NLSF-782 @NLSF-1439 @samsung @mac
  Scenario Outline: NLSF-782-AC1,AC2,AC3,AC4,AC5 : check find store link-icon and new look header navigation NLSF-1439 - Alt Text - translations
    Given user navigates to <page> page on <site> site
    Then I see the find store text with icon and newlook logo as header along with go to my account text
    And I click on find store link or icon and navigate to new look store finder page
    When user navigates to <page> page on <site> site
    Then I click on new look title and navigate to new look page
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
      | uk   |my-account-orders         |
      | uk   |orderDetails.homeDelivery |
      | uk   |orderDetails.collection   |
      | uk   |my-account                |

    @desktop @mobile @tablet @NLSF-1439 @iphone
  Scenario Outline: NLSF-1439 - My Account Home Page Tiles - translations
    Given user navigates to my-account page on <site> site
    Then I see the MyAddress and SavedCollectionPoints text on page
    Examples:
      | site |
      | fr   |
      | de   |  
   
  @desktop @mobile @tablet @NLSF-1620 @samsung @mac
  Scenario Outline:NLSF-1620 AC10 No search text provided in search box when searching (test only current site functionality)
    Given user navigates to <page> page on <site> site
    Then I have NOT type into the search field and click on the search button
    # this below step only validate the aws redirection now as per ticket 1993 it will redirect to aws and we will test this on integ env.
    And I navigate to search page and I see the text response on the page
   Examples:
      | site |page                      |
      | uk   |my-account-orders         |
      | uk   |orderDetails.homeDelivery |
      | uk   |orderDetails.collection   |
      | uk   |my-account                |

##    Removing @samsung and @iphone tag due to NLSF-2054
  @desktop @mobile @tablet @smoke @smoke-my-account @my-account
  Scenario Outline: [UI] Smoke test 1 My accounts page validation with translations
    Given user navigates to my-account page on <site> site
    Then I see the find store text with icon and newlook logo as header along with go to my account text
    Then I see My Account links
    And orders table has order details Columns
    And Payment types are in an order in the footer
    Then I see the language info displaying
    Examples:
      | site |
      | uk   |
      | fr   |
      | row  |
      | de   |

  @desktop @mobile @tablet @NLSF-973 @iphone
  # TODO: Once Browserstack tests can access AWS15, the @wip tag should be removed
  @wip
  Scenario Outline:NLSF-973 AC1, AC2, AC3, AC4, AC5, AC6 – My Account Page - navigate to <page> page as <user>
    Given user navigates to <page> page on <site> site as user with <user>
    Then verify user on the <redirectPage> site
    Examples:
      | site | user           | page                           | redirectPage |
      | uk   | anonymouslogin | my-account                     | login        |
      | uk   | anonymouslogin | saved-cards                    | login        |
      | uk   | anonymouslogin | profile                        | login        |
      | uk   | anonymouslogin | address-book                   | login        |
      | uk   | anonymouslogin | collection-locations           | login        |
      | uk   | anonymouslogin | saved-items                    | login        |
      | uk   | anonymouslogin | my-account-delivery-pass-51300069999   | login        |
      | uk   | anonymouslogin | my-account-contact-preferences | login        |
      | uk   | anonymouslogin | orders                         | trackMyOrder |
      | uk   | anonymouslogin | orderDetails.collection        | trackMyOrder |
      | uk   | anonymouslogin | orderDetails.homeDelivery      | trackMyOrder |

      | fr   | anonymouslogin | my-account                     | login        |
      | fr   | anonymouslogin | saved-cards                    | login        |
      | fr   | anonymouslogin | profile                        | login        |
      | fr   | anonymouslogin | address-book                   | login        |
      | fr   | anonymouslogin | collection-locations           | login        |
      | fr   | anonymouslogin | saved-items                    | login        |
      | fr   | anonymouslogin | my-account-delivery-pass-51300069999   | login        |
      | fr   | anonymouslogin | my-account-contact-preferences | login        |
      | fr   | anonymouslogin | orders                         | trackMyOrder |
      | fr   | anonymouslogin | orderDetails.collection        | trackMyOrder |
      | fr   | anonymouslogin | orderDetails.homeDelivery      | trackMyOrder |

      | de   | anonymouslogin | my-account                     | login        |
      | de   | anonymouslogin | saved-cards                    | login        |
      | de   | anonymouslogin | profile                        | login        |
      | de   | anonymouslogin | address-book                   | login        |
      | de   | anonymouslogin | collection-locations           | login        |
      | de   | anonymouslogin | saved-items                    | login        |
      | de   | anonymouslogin | my-account-delivery-pass-51300069999   | login        |
      | de   | anonymouslogin | my-account-contact-preferences | login        |
      | de   | anonymouslogin | orders                         | trackMyOrder |
      | de   | anonymouslogin | orderDetails.collection        | trackMyOrder |
      | de   | anonymouslogin | orderDetails.homeDelivery      | trackMyOrder |

      | row  | anonymouslogin | my-account                     | login        |
      | row  | anonymouslogin | saved-cards                    | login        |
      | row  | anonymouslogin | profile                        | login        |
      | row  | anonymouslogin | address-book                   | login        |
      | row  | anonymouslogin | collection-locations           | login        |
      | row  | anonymouslogin | saved-items                    | login        |
      | row  | anonymouslogin | my-account-delivery-pass-51300069999   | login        |
      | row  | anonymouslogin | my-account-contact-preferences | login        |
      | row  | anonymouslogin | orders                         | trackMyOrder |
      | row  | anonymouslogin | orderDetails.collection        | trackMyOrder |
      | row  | anonymouslogin | orderDetails.homeDelivery      | trackMyOrder |

      | uk   | softlogin      | my-account                     | login        |
      | uk   | softlogin      | saved-cards                    | login        |
      | uk   | softlogin      | profile                        | login        |
      | uk   | softlogin      | address-book                   | login        |
      | uk   | softlogin      | collection-locations           | login        |
      | uk   | softlogin      | saved-items                    | login        |
      | uk   | softlogin      | my-account-delivery-pass-51300069999   | login        |
      | uk   | softlogin      | my-account-contact-preferences | login        |
      | uk   | softlogin      | orders                         | trackMyOrder |
      | uk   | softlogin      | orderDetails.collection        | trackMyOrder |
      | uk   | softlogin      | orderDetails.homeDelivery      | trackMyOrder |

      | fr   | softlogin      | my-account                     | login        |
      | fr   | softlogin      | saved-cards                    | login        |
      | fr   | softlogin      | profile                        | login        |
      | fr   | softlogin      | address-book                   | login        |
      | fr   | softlogin      | collection-locations           | login        |
      | fr   | softlogin      | saved-items                    | login        |
      | fr   | softlogin      | my-account-delivery-pass-51300069999 | login        |
      | fr   | softlogin      | my-account-contact-preferences | login        |
      | fr   | softlogin      | orders                         | trackMyOrder |
      | fr   | softlogin      | orderDetails.collection        | trackMyOrder |
      | fr   | softlogin      | orderDetails.homeDelivery      | trackMyOrder |

      | de   | softlogin      | my-account                     | login        |
      | de   | softlogin      | saved-cards                    | login        |
      | de   | softlogin      | profile                        | login        |
      | de   | softlogin      | address-book                   | login        |
      | de   | softlogin      | collection-locations           | login        |
      | de   | softlogin      | saved-items                    | login        |
      | de   | softlogin      | my-account-delivery-pass-51300069999  | login        |
      | de   | softlogin      | my-account-contact-preferences | login        |
      | de   | softlogin      | orders                         | trackMyOrder |
      | de   | softlogin      | orderDetails.collection        | trackMyOrder |
      | de   | softlogin      | orderDetails.homeDelivery      | trackMyOrder |

      | row  | softlogin      | my-account                     | login        |
      | row  | softlogin      | saved-cards                    | login        |
      | row  | softlogin      | profile                        | login        |
      | row  | softlogin      | address-book                   | login        |
      | row  | softlogin      | collection-locations           | login        |
      | row  | softlogin      | saved-items                    | login        |
      | row  | softlogin      | my-account-delivery-pass-51300069999  | login        |
      | row  | softlogin      | my-account-contact-preferences | login        |
      | row  | softlogin      | orders                         | trackMyOrder |
      | row  | softlogin      | orderDetails.collection        | trackMyOrder |
      | row  | softlogin      | orderDetails.homeDelivery      | trackMyOrder |

  @desktop @mobile @tablet @smoke @smoke-my-account @my-account @iphone @mac
  Scenario: [UI] Account Page Smoke test 1 : icons, recent orders table displayed
    Given user navigates to my-account page
    Then page displayed with recent orders in descending order
    And orders table has order details Columns
    And all homepage links displayed
      |My_Orders|
      |My_Addresses|
      |My_Payment_Cards|
      |My_Personal_Details|
      |Saved_Collection_Points|
      |My_Saved_Items         |
      |My_Delivery_Pass       |
      |My_Contact_Preferences |

  @desktop @mobile @tablet @my-account @smoke @smoke-my-account @my-account @iphone @mac
  Scenario: [UI] Account Page Smoke test 2 : footer delivery country change
    Given user navigates to my-account page on fr site
    And Payment types are in an order in the footer
    And verify Top Countries list in Delivery Country field
    When switch to gb Delivery Country
    Then verify user on the uk/my-account site
    And verify the footer country change to gb