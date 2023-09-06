Feature: [UI] Order Details Page
AS A Hard-Logged In Customer

  @NLSF-534
  Scenario: NLSF-534-AC2 – Collection Delivery – Track My Order
    When user navigates to click-collect-order-page_2 page
    And track my order link is not displayed

  @NLSF-534 @NLSF-598
  Scenario: NLSF-534-AC1 Track My Order @NLSF-598-AC1 Order Header
    When user navigates to my-account-orders page
    And user clicks on first view order link
    And Order Details displayed


  @NLSF-511 @NLSF-764 @NLSF-765 @NLSF-941 @NLSF-942 @mobile @tablet @desktop @iphone @mac
  Scenario Outline: NLSF-511-AC1,AC2,AC3,AC4,AC5 - My Account Side Menu on <site> site
    When user navigates to <page> page on <site> site
    Then my Account Side Menu is displayed
    And Clicking each side menu link takes me to the corresponding account page
    Examples:
      | site | page                           |
      | uk   | my-account-orders              |
      | row  | my-account-orders              |
      | fr   | orderDetails.collection        |
      | de   | orderDetails.homeDelivery      |
      | uk   | my-account-contact-preferences |
      | uk   | my-account-payment-cards       |

  @NLSF-602 @NLSF-524 @desktop @mobile @tablet @samsung @mac
  Scenario Outline: NLSF-602-AC2, AC1, NLSF-524-AC2, AC1 – Check payment history of Visa on <country> and page <orderDetails> (Collection Delivery) \ (Home Delivery)
    When user navigates to <orderDetails> page on <country> site
    Then check order payment records of Visa
    Examples:
      | country | orderDetails |
      | uk | click-collect-order-visa |
      | fr | click-collect-order-visa |
      | de | click-collect-order-visa |
      | row | click-collect-order-visa |
      | uk | orderDetails.homeDelivery.visa |
      | fr | orderDetails.homeDelivery.visa |
      | de | orderDetails.homeDelivery.visa |
      | row | orderDetails.homeDelivery.visa |

  @NLSF-602 @NLSF-524 @desktop @mobile @tablet @iphone @mac
  Scenario Outline: NLSF-602-AC3, NLSF-524-AC3 – Check payment history of PayPal on <country> and page <orderDetails> (Collection Delivery) \ (Home Delivery)
    When user navigates to <orderDetails> page on <country> site
    Then check order payment records of PayPal
    Examples:
      | country | orderDetails |
      | uk | click-collect-order-paypal |
      | fr | click-collect-order-paypal |
      | de | click-collect-order-paypal |
      | row | click-collect-order-paypal |
      | uk | orderDetails.homeDelivery.paypal |
      | fr | orderDetails.homeDelivery.paypal |
      | de | orderDetails.homeDelivery.paypal |
      | row | orderDetails.homeDelivery.paypal |

  @NLSF-602 @NLSF-524 @desktop @mobile @tablet @samsung @mac
  Scenario Outline: NLSF-602-AC4, NLSF-524-AC4 – Check payment history of Gif Card on <country> and page <orderDetails> (Collection Delivery) \ (Home Delivery)
    When user navigates to <orderDetails> page on <country> site
    Then check order payment records of Gift Card
    Examples:
      | country | orderDetails |
      | uk | click-collect-order-giftCard |
      | fr | click-collect-order-giftCard |
      | de | click-collect-order-giftCard |
      | row | click-collect-order-giftCard |
      | uk | orderDetails.homeDelivery.giftCard |
      | fr | orderDetails.homeDelivery.giftCard |
      | de | orderDetails.homeDelivery.giftCard |
      | row | orderDetails.homeDelivery.giftCard |

  @NLSF-602 @NLSF-524 @desktop @mobile @tablet @iphone @mac
  Scenario Outline: NLSF-602-AC5, NLSF-524-AC5 – Check payment history of New Look Card on <country> and page <orderDetails> (Collection Delivery) \ (Home Delivery)
    When user navigates to <orderDetails> page on <country> site
    Then check order payment records of New Look Card
    Examples:
      | country | orderDetails |
      | uk | click-collect-order-storeCard |
      | fr | click-collect-order-storeCard |
      | de | click-collect-order-storeCard |
      | row | click-collect-order-storeCard |
      | uk | orderDetails.homeDelivery.storeCard |
      | fr | orderDetails.homeDelivery.storeCard |
      | de | orderDetails.homeDelivery.storeCard |
      | row | orderDetails.homeDelivery.storeCard |

  @NLSF-602 @NLSF-524 @desktop @mobile @tablet @samsung @mac
  Scenario Outline: NLSF-602-AC6, NLSF-524-AC6 – Check payment history of Klarna on <country> and page <orderDetails> (Collection Delivery) \ (Home Delivery)
    When user navigates to <orderDetails> page on <country> site
    Then check order payment records of Klarna
    Examples:
      | country | orderDetails |
      | uk | click-collect-order-klarna |
      | fr | click-collect-order-klarna |
      | de | click-collect-order-klarna |
      | row | click-collect-order-klarna |
      | uk | orderDetails.homeDelivery.klarna |
      | fr | orderDetails.homeDelivery.klarna |
      | de | orderDetails.homeDelivery.klarna |
      | row | orderDetails.homeDelivery.klarna |

  @NLSF-602 @NLSF-524 @desktop @mobile @tablet @iphone @mac
  Scenario Outline: NLSF-602,NLSF-524 – Check payment history of multi records on <country> and page <orderDetails> (Collection Delivery) \ (Home Delivery)
    When user navigates to <orderDetails> page on <country> site
    Then check order payment records of Gift Card,PayPal
    Examples:
      | country | orderDetails |
      | uk | click-collect-order-paypal-giftCard |
      | fr | click-collect-order-paypal-giftCard |
      | de | click-collect-order-paypal-giftCard |
      | row | click-collect-order-paypal-giftCard |
      | uk | orderDetails.homeDelivery.multiOrders |
      | fr | orderDetails.homeDelivery.multiOrders |
      | de | orderDetails.homeDelivery.multiOrders |
      | row | orderDetails.homeDelivery.multiOrders |


  @NLSF-604 @NLSF-525 @desktop @mobile @tablet @samsung
  Scenario Outline: @NLSF-604-AC1 Collection Delivery – Returns link, NLSF-525-AC1 – Returns & Refunds Link
    When user navigates to <orderDetails> page on <site> site
    Then returns link is displayed
    And returns help page is opened on clicking returns link
    Examples:
      | site |  orderDetails |
      | uk   |  orderDetails.homeDelivery |
      | fr   |  orderDetails.homeDelivery |
      | de   |  orderDetails.homeDelivery |
      | row  |  orderDetails.homeDelivery |
      | uk   |  click-collect-order-page_2|
      | fr   |  click-collect-order-page_2|
      | de   |  click-collect-order-page_2|
      | row  |  click-collect-order-page_2|

  @NLSF-603 @NLSF-530 @desktop @mobile @tablet @iphone
  Scenario Outline: NLSF-603-AC1,AC3, NLSF-530-AC1,AC3 – Check refund history of Credit \ Debit Card on <country> and page <orderDetails> (Collection Delivery) \ (Home Delivery)
    When user navigates to <orderDetails> page on <country> site
    Then check order refund records of Visa
    Examples:
      | country | orderDetails |
      | uk | orderDetails.parcelShop.returned.visa |
      | fr | orderDetails.parcelShop.returned.visa |
      | de | orderDetails.parcelShop.returned.visa |
      | row | orderDetails.parcelShop.returned.visa |
      | uk | orderDetails.homeDelivery.returned.visa |
      | fr | orderDetails.homeDelivery.returned.visa |
      | de | orderDetails.homeDelivery.returned.visa |
      | row | orderDetails.homeDelivery.returned.visa |

  @NLSF-600 @NLSF-522 @NLSF-774 @NLSF-766 @mobile @tablet @desktop @samsung
  Scenario Outline: NLSF-600-522-744-766 - Applied promotions on <site> site with <orderDetails>
    Given user navigates to <orderDetails> page on <site> site
    Then applied <discount> message is displayed
    Examples:
      | site | orderDetails                 | discount                  |
      | uk   | orderPromotionOrder_c&c      | orderPromotionMessage     |
      | uk   | noPromotionCoupon_c&c        | none                      |
      | uk   | couponOrder_c&c              | couponMessage             |
      | row  | couponOrder_c&c              | couponMessage             |
      | uk   | orderPromotionOrder_hd       | orderPromotionMessage     |
      | uk   | noPromotionCoupon_hd         | none                      |
      | uk   | couponOrder_hd               | couponMessage             |
      | row  | couponOrder_hd               | couponMessage             |
      | fr   | noPromotionCoupon_c&c        | none                      |
      | fr   | orderPromotionOrder_c&c      | orderPromotionMessage     |
      | fr   | orderPromotionOrder_hd       | orderPromotionMessage     |
      | fr   | couponOrder_c&c              | couponMessage             |
      | uk   | orderDetails.homeDelivery.twoItems.prodPromo       | productPromotion          |
      | uk   | orderDetails.collection.twoItems.prodPromo       | productPromotion          |
      | uk   | orderDetails.homeDelivery.oneItem.prodPromo       | productPromotion          |
      | uk   | orderDetails.collection.oneItem.prodPromo       | productPromotion          |
      | fr   | orderDetails.homeDelivery.twoItems.prodPromo       | productPromotion          |
      | fr   | orderDetails.collection.twoItems.prodPromo       | productPromotion          |
      | fr   | orderDetails.homeDelivery.oneItem.prodPromo       | productPromotion          |
      | fr   | orderDetails.collection.oneItem.prodPromo       | productPromotion          |
      | de   | orderDetails.homeDelivery.twoItems.prodPromo       | productPromotion          |
      | de   | orderDetails.collection.twoItems.prodPromo       | productPromotion          |
      | de   | orderDetails.homeDelivery.oneItem.prodPromo       | productPromotion          |
      | de   | orderDetails.collection.oneItem.prodPromo       | productPromotion          |
      | row   | orderDetails.homeDelivery.twoItems.prodPromo       | productPromotion          |
      | row   | orderDetails.collection.twoItems.prodPromo       | productPromotion          |
      | row   | orderDetails.homeDelivery.oneItem.prodPromo       | productPromotion          |
      | row   | orderDetails.collection.oneItem.prodPromo       | productPromotion          |
      | uk   | orderDetails.homeDelivery.twoItems.oneOutOfTwo.prodPromo       | productPromotion          |
      | uk   | orderDetails.collection.twoItems.oneOutOfTwo.prodPromo       | productPromotion          |
      | fr   | orderDetails.homeDelivery.twoItems.oneOutOfTwo.prodPromo       | productPromotion          |
      | fr   | orderDetails.collection.twoItems.oneOutOfTwo.prodPromo       | productPromotion          |
      | de   | orderDetails.homeDelivery.twoItems.oneOutOfTwo.prodPromo       | productPromotion          |
      | de   | orderDetails.collection.twoItems.oneOutOfTwo.prodPromo       | productPromotion          |
      | row   | orderDetails.homeDelivery.twoItems.oneOutOfTwo.prodPromo       | productPromotion          |
      | row   | orderDetails.collection.twoItems.oneOutOfTwo.prodPromo       | productPromotion          |



  @NLSF-599-521-517 @mobile @tablet @desktop @iphone
  # TODO: Once NLSF-2229 is complete, @wip can be removed
  @wip
  Scenario Outline:NLSF-599-521-517 - items list on <site> site with <orderDetails>
  Given user navigates to <orderDetails> page on <site> site
  Then <items> items displayed with  image, size, <orderStatus> and <quantity>
    Examples:
      |site | orderDetails        | items | quantity  | orderStatus |
      |uk   | 2TwoItemsOrder_c&c  | 2     | 2         | 3           |
      |uk   | 1OneItemsOrder_c&c   | 1     | 1         | 2           |
      |uk   | 2TwoItemsOrder_hd  | 2     | 2         | 0           |
      |uk   | 1OneItemsOrder_hd   | 1     | 1         | 1           |
#      |fr   | 1OneItemsOrder_hd   | 1     | 1         | 1           |
#      |fr   | 2TwoItemsOrder_hd   | 2     | 2         | 3           |
#      |fr   | 2TwoItemsOrder_c&c  | 2     | 2         | 3           |

  @NLSF-603 @NLSF-530 @desktop @mobile @tablet @samsung @mac
  Scenario Outline: NLSF-603-AC2, NLSF-530-AC2 – No Refund History on <country> and page <orderDetails> (Collection Delivery) \ (Home Delivery)
    When user navigates to <orderDetails> page on <country> site
    Then check order with no refund records
    Examples:
      | country | orderDetails                            |
      | uk      | click-collect-order-visa                |
      | fr      | click-collect-order-visa                |
      | de      | click-collect-order-visa                |
      | row     | click-collect-order-visa                |
      | uk      | orderDetails.homeDelivery.noRefund.visa |
      | fr      | orderDetails.homeDelivery.noRefund.visa |
      | de      | orderDetails.homeDelivery.noRefund.visa |
      | row     | orderDetails.homeDelivery.noRefund.visa |

  @NLSF-603 @NLSF-530 @desktop @mobile @tablet @iphone @mac
  Scenario Outline: NLSF-603-AC4, NLSF-530-AC4 – Check refund history of PayPal on <country> and page <orderDetails> (Collection Delivery) \ (Home Delivery)
    When user navigates to <orderDetails> page on <country> site
    Then check order refund records of PayPal
    Examples:
      | country | orderDetails                              |
      | uk      | orderDetails.parcelShop.returned.paypal   |
      | fr      | orderDetails.parcelShop.returned.paypal   |
      | de      | orderDetails.parcelShop.returned.paypal   |
      | row     | orderDetails.parcelShop.returned.paypal   |
      | uk      | orderDetails.homeDelivery.returned.paypal |
      | fr      | orderDetails.homeDelivery.returned.paypal |
      | de      | orderDetails.homeDelivery.returned.paypal |
      | row     | orderDetails.homeDelivery.returned.paypal |

  @NLSF-603 @NLSF-530 @desktop @mobile @tablet @samsung @mac
  Scenario Outline: NLSF-603-AC5, NLSF-530-AC5 – Check refund history of Gift Card on <country> and page <orderDetails> (Collection Delivery) \ (Home Delivery)
    When user navigates to <orderDetails> page on <country> site
    Then check order refund records of Gift Card
    Examples:
      | country | orderDetails                                |
      | uk      | orderDetails.parcelShop.returned.giftCard   |
      | fr      | orderDetails.parcelShop.returned.giftCard   |
      | de      | orderDetails.parcelShop.returned.giftCard   |
      | row     | orderDetails.parcelShop.returned.giftCard   |
      | uk      | orderDetails.homeDelivery.returned.giftCard |
      | fr      | orderDetails.homeDelivery.returned.giftCard |
      | de      | orderDetails.homeDelivery.returned.giftCard |
      | row     | orderDetails.homeDelivery.returned.giftCard |

  @NLSF-603 @NLSF-530 @desktop @mobile @tablet @iphone @mac
  Scenario Outline: NLSF-603-AC6, NLSF-530-AC6 – Check refund history of Store Card on <country> and page <orderDetails> (Collection Delivery) \ (Home Delivery)
    When user navigates to <orderDetails> page on <country> site
    Then check order refund records of New Look Card
    Examples:
      | country | orderDetails                                 |
      | uk      | orderDetails.parcelShop.returned.storeCard   |
      | fr      | orderDetails.parcelShop.returned.storeCard   |
      | de      | orderDetails.parcelShop.returned.storeCard   |
      | row     | orderDetails.parcelShop.returned.storeCard   |
      | uk      | orderDetails.homeDelivery.returned.storeCard |
      | fr      | orderDetails.homeDelivery.returned.storeCard |
      | de      | orderDetails.homeDelivery.returned.storeCard |
      | row     | orderDetails.homeDelivery.returned.storeCard |

  @NLSF-603 @NLSF-530 @desktop @mobile @tablet @samsung @mac
  Scenario Outline: NLSF-603-AC7, NLSF-530-AC7 – Check refund history of Klarna on <country> and page <orderDetails> (Collection Delivery) \ (Home Delivery)
    When user navigates to <orderDetails> page on <country> site
    Then check order refund records of Klarna
    Examples:
      | country | orderDetails                              |
      | uk      | orderDetails.parcelShop.returned.klarna   |
      | fr      | orderDetails.parcelShop.returned.klarna   |
      | de      | orderDetails.parcelShop.returned.klarna   |
      | row     | orderDetails.parcelShop.returned.klarna   |
      | uk      | orderDetails.homeDelivery.returned.klarna |
      | fr      | orderDetails.homeDelivery.returned.klarna |
      | de      | orderDetails.homeDelivery.returned.klarna |
      | row     | orderDetails.homeDelivery.returned.klarna |

  @NLSF-603 @NLSF-530 @desktop @mobile @tablet @iphone
  Scenario Outline: NLSF-603, NLSF-530 – Check refund history of multiple records on <country> and page <orderDetails> (Collection Delivery) \ (Home Delivery)
    When user navigates to <orderDetails> page on <country> site
    Then check order refund records of Gift Card,PayPal
    Examples:
      | country | orderDetails                                   |
      | uk      | orderDetails.parcelShop.returned.multiOrders   |
      | fr      | orderDetails.parcelShop.returned.multiOrders   |
      | de      | orderDetails.parcelShop.returned.multiOrders   |
      | row     | orderDetails.parcelShop.returned.multiOrders   |
      | uk      | orderDetails.homeDelivery.returned.multiOrders |
      | fr      | orderDetails.homeDelivery.returned.multiOrders |
      | de      | orderDetails.homeDelivery.returned.multiOrders |
      | row     | orderDetails.homeDelivery.returned.multiOrders |

  @NLSF-601 @NLSF-523 @desktop @mobile @tablet @samsung @mac
  Scenario Outline: NLSF-601-AC1,AC2,AC3,AC6 – Order details - Subtotal, free delivery, total price
    When user navigates to <page> page on <site> site
    Then The delivery method is <deliveryMethod>
    And The delivery cost is free
    And The subtotal is visible
    And The total price is visible
    # TODO: Uncomment these once we have actual data
#    Then The subtotal is the sum of all product prices and savings
#    And The total price is the sum of subtotal and delivery
    Examples:
      | site | page                                   | deliveryMethod       |
      | uk   | orderDetails.collection.freeDelivery   | collection           |
      | fr   | orderDetails.homeDelivery.freeDelivery | homeDelivery.express |

  @NLSF-601 @NLSF-523 @desktop @mobile @tablet @iphone @mac
  Scenario Outline: NLSF-601-AC1,AC2,AC4,AC6 – Order details - Subtotal, delivery, total price, savings
    When user navigates to <page> page on <site> site
    Then The savings are visible
    And The delivery method is <deliveryMethod>
    And The delivery cost is visible
    And The subtotal is visible
    And The total price is visible
#    And The total price is the sum of subtotal and delivery
    Examples:
      | site | page                              | deliveryMethod       |
      | de   | orderDetails.collection.savings   | collection           |
      | row  | orderDetails.homeDelivery.savings | homeDelivery.express |

  @NLSF-601 @NLSF-523 @desktop @mobile @tablet @samsung @mac
  Scenario Outline: NLSF-601-AC1,AC2,AC5,AC6 – Order details - Subtotal, delivery, total price, no savings
    When user navigates to <page> page on <site> site
    Then The savings are not visible
    And The delivery method is <deliveryMethod>
    And The delivery cost is visible
    And The subtotal is visible
    And The total price is visible
#    And The total price is the sum of subtotal and delivery
    Examples:
      | site | page                                | deliveryMethod |
      | row  | orderDetails.collection.noSavings   | collection     |
      | uk   | orderDetails.homeDelivery.noSavings | homeDelivery   |


  @my-orders @smoke @smoke-my-account @desktop @mobile @tablet @my-account @iphone @mac
  Scenario Outline: [UI] Smoke test 1 Order details page status <status> timeline
    Given user navigates to my-account-orders page as user with longName
    When I click on an order with the <status> status
    Then The order status timeline is not visible
    And The order status is <status>
    And check order payment records
    Examples:
      | status    |
      | returned  |

  @my-orders @smoke @smoke-my-account @desktop @mobile @tablet @my-account @samsung @mac
  Scenario: [UI] Smoke test 2 Order details page cancelled timeline
    Given user navigates to my-account-orders page on uk site
    When I click on an order with the cancelled status
    Then The order status timeline is not visible
    And The order status is cancelled
    And check order payment records

  @my-orders @smoke @smoke-my-account @desktop @mobile @tablet @my-account @iphone @mac
  Scenario Outline: [UI] Smoke test 3 Order details page <status> timeline
    Given user navigates to my-account-orders page on uk site
    When I click on an order with the <status> status
    And check customer facing order status in order detail page
    And check order payment records
    Examples:
      | status |
      | awaiting_dispatch    |

  @my-orders @smoke @smoke-my-account @desktop @mobile @tablet @my-account @samsung @mac
  Scenario Outline: [UI] Smoke test 6 Order details page <status> timeline
    Given user navigates to my-account-orders page on uk site as user with collectionOrders
    When I click on an order with the <status> status
    And check customer facing order status in order detail page
    And check order payment records
    Examples:
      | status |
      | ready_for_collection |
      | collected            |

  @my-orders @smoke @smoke-my-account @desktop @mobile @tablet @my-account @iphone @mac
  Scenario Outline: [UI] Smoke test 5 Order details page status <status> timeline
    Given user navigates to my-account-orders page on uk site as user with collectionOrders
    When I click on an order with the <status> status
    Then The order status timeline is not visible
    And The order status is <status>
    And The description of <status> status is visible
    And check order payment records
    Examples:
      | status    |
      | notCollected |

  @my-orders @smoke @smoke-my-account @desktop @mobile @tablet @my-account @samsung
  Scenario: [UI] Smoke test 4 Collection details on ready_for_collection Order details page
    Given user navigates to my-account-orders page on uk site as user with collectionOrders
    When I click on an order with the ready_for_collection status
    And verify Collection Details contents
    Then The map with the collection point is visible
    And The open map CTA is visible
    And The open map CTA links to Google Maps

  @NLSF-504 @desktop @mobile @tablet @iphone @mac
  Scenario Outline: @NLSF-504-AC1,AC3,AC5,AC6 Delivery Details (Home Delivery)
    When user navigates to <deliveryMode> page
    Then I see the delivery details of the order for <deliveryMode>
    And I see the recipients full name and address
    Examples:
      | deliveryMode                                                 |
      | orderDetails.homeDelivery.nominatedDeliveryGroup.dateAndTime |
      | orderDetails.homeDelivery.date                               |
      | orderDetails.homeDelivery.deliveryPromise                    |

  @NLSF-504 @NLSF-1367 @desktop @mobile @tablet @samsung @mac
  Scenario Outline: @1367 Delivered by - translations
    When user navigates to <deliveryMode> page on <country> site
    Then I see the delivery details of the order for <deliveryMode>
    And I see the recipients full name and address
    Examples:
      | deliveryMode                   | country |
      | orderDetails.homeDelivery.date | fr      |
      | orderDetails.homeDelivery.date | de      |

  @NLSF-520 @desktop @mobile @tablet @iphone @mac
  Scenario: NLSF-520 - AC1 – Home Delivery – Track My Order
    When user navigates to click-track-my-order-page page
    And track my order link is displayed
    And click on track my order link
    And I see my orders delivery tracking page as per the URL

  @NLSF-1439 @desktop @mobile @tablet @samsung
  Scenario Outline: NLSF-1439 - Order Details Page - translations
    Given user navigates to orderDetails.collection.returned.notcollected page on <site> site
   Then I see the returned not collected  message displaying
    Examples:
      | site |
      | fr   |
      | de   |

   @NLSF-1439 @desktop @mobile @tablet @iphone
  Scenario: NLSF-1439 - Order List & Order Details Page - translations
    When user navigates to orderDetails.homeDelivery.trackMyOrder page on de site
    And track my order link is displayed
    And I see the track my order traslation per selected language

  @desktop @smoke @smoke-my-account @my-account
  Scenario Outline: [UI] Smoke test 5 Order details page validation with translations
    Given user navigates to my-account-orders page on <site> site
    And user clicks on first view order link
    And order details page displayed
    And Order Details match the first order
    And Order Details displayed
    And The delivery cost is visible
    And The subtotal is visible
    And The total price is visible
    Then returns link is displayed

    Examples:
      | site |
      | uk   |
      | de   |
