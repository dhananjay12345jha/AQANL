Feature: [UI] My Orders Page
AS A Hard-Logged In Customer
I WANT to be advised when there has been a delay or issue with loading my orders on the My Orders page
SO THAT I know that there has been a delay or issue, and what my next steps are

  @NLSF-536 @NLSF-535
  Scenario: NLSF-536-AC1 - Collection Address (Collection Delivery) NLSF-535-AC1-AC2-AC4-AC5 - Store Opening Hours(Collection Delivery)
    When user navigates to click-collect-order-visa page
    Then check the Collection Address details
    Then check opening hours and temporary opening hours displayed

  @NLSF-512
  Scenario: NLSF-512-AC1,AC2,AC3,AC4,AC5 – My Orders Page
    When user navigates to my-account-orders page
    Then page displayed with all orders in descending order
    And dispatched order displayed
    And orders table has order details Columns

  @NLSF-533 @NLSF-519 @desktop @mobile @tablet @samsung
  Scenario Outline: NLSF-533-AC1 – Order Details – Order Status Bar NLSF-519-AC1 – Home Delivery Order – Order Status Bar
    When user navigates to <page> page on <site> site
    Then The <deliveryMethod> order statuses are visible in order
    And The current order status is highlighted
    And The order statuses have the correct colours
    Examples:
      | site | page                      | deliveryMethod  |
      | uk   | orderDetails.collection   | clickAndCollect |
      | de   | orderDetails.parcelShop   | parcelShop      |
      | fr   | orderDetails.homeDelivery | homeDelivery    |


  @NLSF-533 @NLSF-519 @desktop @mobile @tablet @iphone
  Scenario Outline: NLSF-533-AC2 – C&C Delivery Order – Order Status Text - Cancelled NLSF-519-AC2 – Home Delivery Order – Order Status Cancelled
    When user navigates to <page>.cancelled page on <site> site
    Then The order status timeline is not visible
    And The order status is cancelled
    And The order status colour is red
    Examples:
      | site | page                      |
      | row  | orderDetails.collection   |
      | uk   | orderDetails.parcelShop   |
      | de   | orderDetails.homeDelivery |

  @NLSF-533 @desktop @mobile @tablet @samsung @mac
  Scenario: NLSF-533-AC3 – C&C Delivery Order – Order Status Not Collected
    Given user navigates to my-account-orders page on uk site as user with collectionOrders
    When I click on an order with the notCollected status
    Then The order status timeline is not visible
    And The order status is notCollected
    And The description of notCollected status is visible

  @NLSF-533 @desktop @mobile @tablet @iphone
  Scenario Outline: NLSF-533-AC4 - NLSF-519-AC3 - NLSF-520 - AC2 Order Status Text - Returned
    When user navigates to <page>.returned page on <site> site
    Then The order status timeline is not visible
    And The order status is returned
    And track my order link is not displayed
    And The order status colour is black
    Examples:
      | site | page                      |
      | fr   | orderDetails.collection   |
      | uk   | orderDetails.parcelShop   |
      | uk   | orderDetails.homeDelivery |

  @NLSF-585 @desktop @mobile @tablet @iphone
  Scenario Outline: NLSF-585-AC1 – Collection From
    When user navigates to click-collect-order-visa page on <country> site
    Then verify Collection From contents
    Examples:
      | country |
      | uk |
      | fr |
      | de |
      | row |

  @NLSF-584 @desktop @mac
  Scenario Outline: NLSF-584-AC1 – Collection Details
    When user navigates to click-collect-order-visa page on <country> site
    Then verify Collection Details contents
    Examples:
      | country |
      | uk |
      | fr |
      | de |
      | row |

  @NLSF-605 @NLSF-526
  Scenario Outline: NLSF-605-AC1 - Collection Delivery - Order Details - Contact us link, NLSF-526-AC1 – Contact Us Link
    When user navigates to <orderDetails> page on <site> site
    And The contact us button is visible
    When I click on the contact us button
    Then verify user on website orders.contactUs.link
    Examples:
      | site |  orderDetails |
      | uk   |  orderDetails.homeDelivery |
      | fr   |  orderDetails.homeDelivery |
      | de   |  orderDetails.homeDelivery |
      | row  |  orderDetails.homeDelivery |
      | uk   |  collectionOrder |
      | fr   |  collectionOrder |
      | de   |  collectionOrder |
      | row  |  collectionOrder |


  @NLSF-537 @mobile @tablet @samsung
  Scenario: NLSF-537 - AC1,AC3,AC4,AC5,AC6 – Collection Location Map - Mobile / Tablet
    When user navigates to collectionOrder page
    Then The map with the collection point is visible as a static image
    And The static map links to Google Maps
    And The open map CTA is visible
    And The open map CTA links to Google Maps

  @NLSF-537 @desktop @mac
  Scenario: NLSF-537 - AC2,AC7 – Collection Location Map - Desktop
    When user navigates to collectionOrder page
    Then The map with the collection point is visible as a dynamic map
    And The open map CTA is visible
    And The open map CTA links to Google Maps

   @NLSF-1154 @NLSF-1155 @desktop @mobile @tablet @iphone
  Scenario Outline: NLSF-1154 - AC1 – Item List (Collection Delivery) – Not Visible NLSF-1155 - AC5 – Item List (Home Delivery) – Not Visible
    When user navigates to <page> page
    And The order statuses have the correct colours
    And Verify purged item not visible and not clickable
    Examples:
    | page                             |
    | collectedOrder                   |
    | orderDetails.homeDelivery.purged |

  @desktop @smoke @smoke-my-account @my-account @mac
  Scenario Outline: [UI] Smoke test 1 My orders page validation with translations
    Given user navigates to my-account-orders page on <site> site

    Then I see the find store text with icon and newlook logo as header along with go to my account text
    And Payment types are in an order in the footer
    Then I see the language info displaying
    Then I see a Newsletter sign-up section in the Footer
    Then verify the footer links under vertical alignments/columns
    Then verify the bottom footer links

    Then my Account Side Menu is displayed
    Then order details page displayed
    And orders heading is present
    And page displayed with all orders in descending order

    And verify Top Countries list in Delivery Country field
    When switch to fr Delivery Country
    Then verify user on the fr/my-account/orders site
    And verify the footer country change to fr

    Examples:
      | site |
      | uk   |
      | fr   |
      | row  |
      | de   |

  @desktop @mobile @tablet @my-orders @smoke @smoke-my-account @my-account @iphone @mac @testactions
  Scenario: [UI] My Orders Page : Smoke test 2 Orders table and side menu
    Given user navigates to my-account-orders page
    Then page displayed with all orders in descending order
    And orders table has order details Columns
    And my Account Side Menu is displayed

  @desktop @mobile @tablet @my-orders @smoke @smoke-my-account @my-account @samsung @mac
  Scenario: [UI] My Orders Page : Smoke test 3 Change the footer delivery country
    Given user navigates to my-account-orders page
    And Payment types are in an order in the footer
    And verify Top Countries list in Delivery Country field
    When switch to fr Delivery Country
    Then verify user on the fr/my-account/orders site
    And verify the footer country change to fr

    