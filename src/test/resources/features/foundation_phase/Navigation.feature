#@smoke-search-and-browse @search-and-browse
Feature: [UI] pages navigation
  As a user
  I want to test navigation to a page
  So that I can verify page name

  Scenario Outline: Test Case 001 page navigation
    When user navigates to <page> page
    Then <pageName> name is displayed

  Examples:
  | page | pageName |
  | multiStepCheckoutSummary | CheckoutSinglePage |
  | checkout-login | LoginCheckoutPage |
  | cart | CartPage |
  | guest-contact-preferences-request | GuestContactPreferencesPage|
  | delivery-options | DeliveryOptionsPage |
  | subscriptionProductPage | SubscriptionProductPage |
  | trackMyOrderDetails | GuestOrderPage |
  | help | HelpPage |
  | helpCode | HelpCodePage |
  | callback-login | CallbackLoginPage |
  | callback-register | CallbackRegisterPage |
  | login | LoginPage |
  | rtbf-form | RTBFFormPage |
  | rtbf-form-confirmation | RTBFFormConfirmationPage |
  | rtbf-confirmation | RTBFConfirmationPage |
  | saved-items | SavedItemsPage |
  | search | SearchPage |
  | staff-discount | StaffDiscountPage |
  | staff-discount-register | StaffDiscountRegisterPage |
  | staff-discount-confirmation | StaffDiscountConfirmationPage |
  | storefinder | StoreFinderPage |
  | storedetails | StoreDetailsPage |
  | store-stock | StoreStockLookupPage |
  | trackMyOrder | GuestTrackOrderPage |
  | html-sitemap | SitemapPage |