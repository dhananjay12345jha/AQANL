Feature: [UI] Contact Preferences Page
	AS A Hard-Logged In Customer
  I WANT to view the website ContactPreferencespage
  SO THAT I can access links and key resources

	@NLSF-565 @NLSF-566 @desktop @mobile @tablet @samsung @smoke @smoke-my-account @my-account
	Scenario Outline: [UI] Smoke test for contact preferences
		Given user navigates to <currentPage> page on <site> site
		Then i am able to see the title of Contact Preferences page
		And i am able to see the summary of Contact Preferences page
		And i am able to see the T&Cs for contact preferences page
		And The <currentPage> breadcrumb link is visible
		Then i am able to see the Email Newsletter title, description and optin options
		Then i am able to see the Post Purchase Product Reviews title, description and optin options
		Then i am able to see the Social Campaigns title, description and optin options
		And i can see the privacy policy link
		When i click on privacy policy link
		Then I see the  Privacy Policy help page

		Examples:
			| currentPage         | site |
			| contact-preferences |  uk  |
			| contact-preferences |  de   |
			| contact-preferences |  fr   |

  @NLSF-567 @desktop @mobile @tablet @samsung @mac
  Scenario Outline: NLSF-567-AC1,AC2, AC5- Contact Preferences Card
	  Given user navigates to contact-preferences page on <site> site as user with <user>
	  Then check default select options for user <user>
	  Then check banner displayed after click save button for user <user>
	  Then check options restored after page refresh for user <user>
	  Examples:
		  | site | user           |
		  | uk   | multipleOrders |
		  | uk   | longName       |
		  | fr   | multipleOrders |
		  | fr   | longName       |
		  | de   | multipleOrders |
		  | de   | longName       |
		  | row  | multipleOrders |
		  | row  | longName       |

  @NLSF-567 @desktop @mobile @tablet @iphone @mac
  Scenario: NLSF-567-AC5, AC6- Update Contact Preferences - Unsaved
	  Given user navigates to contact-preferences page on uk site as user with multipleOrders
	  Then select different selection for user multipleOrders
	  Then user navigates to my-account page
	  Then user navigates to contact-preferences page
	  Then check default select options for user multipleOrders
	  Then click Save Preferences button
	  Then check default select options for user multipleOrders

  @NLSf-1144 @desktop @mobile @mac
  Scenario Outline: NLSF-1144-AC1 – My Contact Preferences – No Consent Record, AC2 – After Consent Record Created
	  Given user navigates to contact-preferences page on <site> site as user with noOrders
	  Then check default select options for user noOrders
	  Examples:
		  | site |
		  | uk   |
		  | fr   |
		  | de   |
		  | row  |








