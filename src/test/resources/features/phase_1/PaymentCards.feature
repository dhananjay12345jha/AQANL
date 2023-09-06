Feature: [UI] Payment Cards
AS A Hard-Logged In Customer

  @NLSF-552 @NLSF-1952 @desktop @mobile @tablet @samsung
  Scenario Outline: NLSF-552 AC1 – Empty My Payment Cards,Save payment card message
    Given user navigates to <page> page on <site> site as user with noPaymentCardSaved
    Then user able to see message of no card saved
   Examples:
      | site |page                      |
      | uk   |my-account-payment-cards  |
      | fr   |my-account-payment-cards  |
      | de   |my-account-payment-cards  |

  @NLSF-548 @NLSF-551 @desktop @mobile @tablet @samsung @smoke @smoke-my-account @my-account
  Scenario: [UI] Smoke test for payment cards
    Given user navigates to my-account-payment-cards page on uk site as user with varietyOfSavedCards
    Then The paymentCards breadcrumb link is visible
    And user able to see security message and Payment title
    And user able to see all saved card in descending order with detailed info and expiry status
    Then I can see a CTA to set other card as default
    And I click on card to make this as default card
    And I see default tag updated on selected card
    And user able to see one default card tag in saved cards
    And user able to see one default card tag in saved cards for user varietyOfSavedCards

  @NLSF-551 @desktop @mobile @tablet @iphone
  Scenario: NLSF-551 AC3 – Only One Payment Card
    Given user navigates to my-account-payment-cards page on uk site as user with onePaymentCardSaved
    Then user able to see default card tag in one single saved card


  @NLSF-550 @desktop @mobile @tablet @samsung @mac
  Scenario Outline: NLSF-550 AC1- Delete Payment Card Link, AC2 – Delete Payment Card, AC4 – Delete Payment Card– Confirm, AC5 – Delete Payment Card– Delete Default Payment Card
    Given user navigates to my-account-payment-cards page on <site> site as user with longName
    Then user able to see total 10 delete CTAs for each Payment Card
    And user click CTA to delete default card for user longName
    Then verify delete card pop up for default card
    Then user click Delete CTA in Delete confirm pop to delete card
    Then verify on page remaining 9 cards
    Then user able to see one default card tag in saved cards for user longName
    Examples:
      | site |
      | uk   |


  @NLSF-550 @desktop @mobile @tablet @mac #@iphone
  # TODO: Re-enable for iPhone when NLSF-2230 is fixed
  Scenario Outline: NLSF-550 AC3 – Delete Payment Card - Expired Card
    Given user navigates to my-account-payment-cards page on <site> site as user with longName
    And user click CTA to delete expired card
    Then verify delete card pop up for expired card
    Then user click Delete CTA in Delete confirm pop to delete card
    Then verify on page remaining 9 cards
    Examples:
      | site |
      | uk   |

  @NLSF-550 @desktop @mobile @tablet @samsung
  Scenario Outline: NLSF-550 AC6 – Delete Payment Card– Cancel, AC7 – Delete Payment Card– Click Away to Cancel
    Given user navigates to my-account-payment-cards page on <site> site as user with longName
    And user click CTA to delete expired card
    Then user click Cancel CTA in Delete confirm pop up
    Then verify on page remaining 10 cards
    And user click CTA to delete expired card
    Then user click out side of Delete confirm pop up
    Then verify on page remaining 10 cards
    Examples:
      | site |
      | uk   |
      | fr   |
      | de   |
      | row  |


  @NLSF-550 @NLSF-1952 @desktop @mobile @tablet @iphone @mac
  Scenario Outline: NLSF-550 AC10 – Delete Payment Card– Last Card, NLSF-1952 Save payment card message
    Given user navigates to my-account-payment-cards page on <site> site as user with multipleOrders
    And user click CTA to delete default card for user multipleOrders
    Then user click Delete CTA in Delete confirm pop to delete card
    Then verify on page remaining 0 cards
    Examples:
      | site |
      | uk   |
      | fr   |
      | de   |
      | row  |

  @NLSF-1952 @desktop @mobile @tablet @samsung @mac
  Scenario Outline: NLSF-1952 Check the Default card message
    Given user navigates to my-account-payment-cards page on <site> site as user with longName
    Then user able to see one default card tag in saved cards for user longName
    Examples:
      | site |
      | uk   |
      | fr   |
      | de   |