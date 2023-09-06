@datalayer @desktop
Feature: [UI] NLSF-1070 DataLayer
  AS A Analytics Manager
  I WANT a global set of GTM scripts to be present on each of the new Storefront pages
  SO THAT I can continue to use the NL Datalayer to analyse the customer behaviours on the website

  @NLSF-1070
  Scenario: NLSF-507-AC1 - Scripts present in head and body
	Given user navigates to my-account page on uk site
	Then The cookiebot script is present in the head of the site
	And The gtm.head.script script is present in the head of the site
	And The gtm.body.noscript script is present in the body of the site

	But user navigates to my-account-orders page on uk site
	Then The cookiebot script is present in the head of the site
	And The gtm.head.script script is present in the head of the site
	And The gtm.body.noscript script is present in the body of the site

	But user navigates to orderPromotionOrder_c&c page on uk site
	Then The cookiebot script is present in the head of the site
	And The gtm.head.script script is present in the head of the site
	And The gtm.body.noscript script is present in the body of the site

  @NLSF-1178
  Scenario Outline: NLSF-1178-AC1 - Toggle GTM with URL parameter
	Given user navigates to my-account page
	When I append <toggle> to the current URL
	Then The dataLayer is <enabledOrDisabled>
	Examples:
	  | toggle         | enabledOrDisabled |
	  | ?loadGTM=true  | enabled           |
	  | ?loadGTM=false | disabled          |

  #@NLSF-1071 @NLSF-1168
  @mobile @smoke @my-account-smoke @my-account @samsung @mac @tablet
  Scenario Outline: [UI] Smoke test 1 - Data layer core variables
	When user navigates to my-account page on <site> site
	Then The data layer core variables are populated
	When I click on the my-orders account link
	Then The data layer breadcrumb property is updated
	And The data layer title property is updated

	Examples:
	  | site |
	  | uk   |
	  | row  |
	  | de   |
	  | fr   |

  @NLSF-1266
  Scenario: NLSF-1266 - AC1 - DataLayer JS Errors
	When user navigates to js-error page
	Then The data layer error event is populated with the jsError variables