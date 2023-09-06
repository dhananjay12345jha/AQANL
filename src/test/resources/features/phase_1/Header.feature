@header
Feature: [UI] Header
  AS A customer,
  I WANT to view the website header
  SO THAT I can access links and key resources

  @NLSF-890 @desktop
  Scenario: NLSF-890-AC1,AC3 - Header welcome message & account icon
	Given user navigates to my-account-orders page
	And The header welcome message is visible
	And The account icon is visible
	When I click on the account icon
	Then I am on the my-account page

  @NLSF-890 @desktop @mac
  Scenario Outline: NLSF-890-AC4,AC6 - Header mini menu
	Given user navigates to <startingPage> page
	When I hover over the header welcome message
	Then The header mini menu is visible

	When I click on the mini menu <miniMenuLink> link
	Then I am on the <miniMenuLink> page
	Examples:
	  | startingPage      | miniMenuLink      |
	  | my-account        | my-account-orders |
	  | my-account-orders | my-account        |

  @NLSF-890 @desktop @wip # The results of signing out are out of scope, but adding this test to be completed in future
  Scenario: NLSF-890-AC7 - Header mini menu sign out
	Given user navigates to my-account page
	When I hover over the header welcome message
	And I click on the mini menu sign out button
	Then I am on the homepage page
	And I have been signed out
	And The signed out notification is visible

  @NLSF-893 @search @desktop @tablet
  Scenario: NLSF-893-AC1,AC7 - Search (desktop/tablet)
	Given user navigates to my-account page
	And The search bar is visible
	And The search bar placeholder text is visible
	And The search icon is visible
	When I type a some-results search term into the search bar
	And I click on the search icon
	Then My some-results search term is visible in the URL
# The search page is currently handled by the old site so not automating yet
#	And Search results are visible

  @NLSF-893 @search @mobile @samsung
  Scenario: NLSF-893-AC1,AC5 - Search (mobile)
	Given user navigates to my-account page
	And The search toggle is visible
	When I click on the search toggle
	Then The search bar is visible
	And The search bar placeholder text is visible
	And The search icon is visible
	And The mobile search popup is visible
	And The close mobile search popup button is visible

	When I type a some-results search term into the search bar
	And I click on the search icon
	Then My some-results search term is visible in the URL
# The search page is currently handled by the old site so not automating yet
#	And Search results are visible

  @NLSF-893 @search @desktop @mobile @tablet @iphone
  @wip
  # We won't be able to test the redirects until we have some set up
  Scenario: NLSF-893-AC8 - Search redirect
	Given user navigates to my-account page
	When I search for a redirected search term
	Then External search.redirected URL is opened

  @NLSF-893 @search @desktop @mobile @tablet @samsung
  @wip
  # Currently, this is no different to the above test for searching with results
  # I have disabled until we test the search results page to avoid duplicate tests
  Scenario: NLSF-893-AC9 - Search no results
	Given user navigates to my-account page
	When I search for a no-results search term
	Then My no-results search term is visible in the URL
# The search page is currently handled by the old site so not automating yet
#	And Search results are not visible
#   And The no search results message is visible

  @NLSF-893 @search @desktop @mobile @tablet @iphone
  @wip
# Marking this WIP as this AC is moved out of the story and will made part of another story
  Scenario: NLSF-893-AC10 - Malicious search blocked
	Given user navigates to my-account page
	When I search for a malicious search term
	Then The 403 error page is visible

  @NLSF-923 @desktop @mac
  Scenario: NLSF-923-AC1-AC2-AC3-AC4-AC8 - Sticky header
	Given user navigates to my-account-orders page on uk site
	When I scroll down the header is not visible
	And I scroll up the sticky header should be visible
	And I scroll down the header is not visible
	And I scroll to the top of the page the standard header elements should be visible

  @NLSF-923 @mobile @samsung
  Scenario: NLSF-923-AC5-AC6-AC7-AC8 - Mobile Sticky header
	Given user navigates to my-account-orders page on uk site
	When I scroll down the sticky header is visible
	And I scroll up the sticky header should be visible
	And I scroll to the top of the page the standard mobile header should be visible

  @NLSF-1040 @desktop @mobile @tablet @iphone @mac
  Scenario: NLSF-1040-AC1-AC2 - General header – Saved Items Link
	Given user navigates to my-account page
	When I click on the saved items icon on header
	Then the saved items page slides open as side panel
	And the side panel is closed when closed

	@NLSF-783 @mobile @samsung
	Scenario: NLSF-783-AC2-AC3-AC4 - Header Hamburger menu test
		Given user navigates to my-account page
		When I clicked on hamburger menu from the header
		Then I can see the Menu at the top in header bar
		And the header Menu is having option to close
		And I can see the welcome message and the account icon

	@NLSF-783 @mobile @iphone
	Scenario: NLSF-783-AC5 - Header Hamburger menu welcome message and account icon test
		Given user navigates to my-account-orders page
		When I clicked on hamburger menu from the header
		When I click on welcome message and account icon
		Then I am on the my-account page

	@NLSF-783 @mobile @samsung
	Scenario: NLSF-783-AC6 - Header Hamburger menu close button test
		Given user navigates to my-account page
		When I clicked on hamburger menu from the header
	    When  I click on the close option
		Then I am on the my-account page

  @NLSF-891 @desktop @mobile @tablet @iphone @mac
  Scenario Outline: NLSF-891-AC1-AC3-AC6 - header – Saved Items - Counter
	  Given user navigates to my-account page on uk site as user with <user>
	  Then I should see the saved items icon with the counter <value> displayed
	  Given user navigates to my-account page on fr site as user with <user>
	  Then I should see the saved items icon with the counter <value> displayed

	  Examples:
		  | user           | value |
		  | multipleOrders | 50    |

  @NLSF-891 @desktop @mobile @tablet @samsung
  Scenario: NLSF-891-AC5-AC7 - header – Saved Items - Counter
    Given user navigates to my-account page on uk site as user with noOrders
	Then I should not see any counter on the saved item icon

  @NLSF-892 @desktop @mobile @tablet @iphone @mac
  # TODO: Once Browserstack tests can access AWS15, the @wip tag should be removed
  @wip
  Scenario: NLSF-892-AC1-AC3-AC4-AC7 - header – My Bag icon
    Given user navigates to my-account page on uk site as user with multipleOrders
    Then I see My Bag icon with the counter 50 displayed
    Then click My Bag icon and verify linked to cart page
    Given user navigates to my-account page on fr site as user with multipleOrders
    Then I see My Bag icon with the counter 50 displayed
    Then click My Bag icon and verify linked to cart page

  @NLSF-892 @desktop @mobile @tablet @samsung @mac
  Scenario: NLSF-892-AC6-AC8 - header – My Bag icon
    Given user navigates to my-account page on uk site as user with noOrders
    Then I should not see any counter on the My Bag icon
    Given user navigates to my-account page on de site as user with noOrders
    Then I should not see any counter on the My Bag icon

  # Search item funtionality not working on CICD, once working we can remove # tag from @NLSF-1002
	#@NLSF-1002 @desktop @mobile @samsung
  Scenario Outline: NLSF-1002 AC1 - Start to type AC2- Search - no terms AC6-Auto suggest Search - Failure
	Given user navigates to <page> page
	When I type a <searchTerm> search term into the search bar
	Then I see no auto suggested terms displayed
		Examples:	 
      |page                      |searchTerm               |
      |my-account-orders         |TwoCharacterSearchResults|
      |orderDetails.homeDelivery |TwoCharacterSearchResults|
      |orderDetails.collection   |TwoCharacterSearchResults|
      |my-account                |TwoCharacterSearchResults|
      |my-account-orders         |ThreeCharacterNotFound   |
      |orderDetails.homeDelivery |ThreeCharacterNotFound   |
      |orderDetails.collection   |ThreeCharacterNotFound   |
      |my-account                |ThreeCharacterNotFound   |
	
	# Search item funtionality not working on CICD, once working we can remove # tag from @NLSF-1002
	#@NLSF-1002 @desktop @mobile @iphone
# Auto suggest is not working currently. @smoke @smoke-my-account @my-account tag should be added above when its working
  Scenario Outline: NLSF-1002 AC3-Search - Terms found AC4-Search - Click suggest term
	Given user navigates to <page> page
	When I type a ThreeCharacterSearchResults search term into the search bar
	Then I see auto suggested terms displayed
	And I click on with out redirect option from auto suggested option
	And I am redirect to expected result page
	Examples:	 
      |page                      |
      |my-account-orders         |
      |orderDetails.homeDelivery |
      |orderDetails.collection   |
      |my-account                |
 
  # Search item funtionality not working on CICD, once working we can remove # tag from @NLSF-1002
 	#@NLSF-1002 @desktop @mobile @smoke-header @samsung
# Auto suggest is not working currently. @smoke @smoke-my-account @my-account tag should be added above when its working
  Scenario Outline: NLSF-1002 AC5 - Search - Keyword redirect
	Given user navigates to <page> page
	When I type a searchTermRedirectSetup search term into the search bar
	Then I see redirect auto suggested terms displayed
	And I click on with redirect setup option from auto suggested option
	And I am redirect to expected PLP or PDP page
	Examples:
		| page                      |
		| my-account-orders         |
		| orderDetails.homeDelivery |
		| orderDetails.collection   |
		| my-account                |

  @NLSF-1592 @NLSF-1603 @desktop @mobile @tablet @samsung @mac
  Scenario Outline: NLSF-1592 AC1,AC2 NLSF-1603 AC1 - Breadcrumb links
	Given user navigates to <currentPage> page on <site> site
	And The <currentPage> breadcrumb link is visible
	And The <lowerTierPage> breadcrumb link is visible
	When I click on the <lowerTierPage> breadcrumb link
	Then I am on the <lowerTierPage> page
	Examples:
	  | currentPage               | lowerTierPage     | site |
	  | my-account-orders         | my-account        | uk   |
	  | my-account                | homepage          | fr   |
	  | orderDetails.homeDelivery | my-account-orders | de   |

  @desktop @my-orders @mobile @tablet @NLSF-1596 @samsung @mac
  Scenario: NLSF-1596 AC1 Breadcrumb - My Order - Collection
	Given user navigates to 1OneItemsOrder_c&c page on uk site
	Then verify breadcrumb display as Home / My Account / My Orders / Order HY03300004
	

  @NLSF-1183 @desktop @mobile @tablet @iphone @mac
  # TODO: Once Browserstack tests can access AWS15, the @wip tag should be removed
  @wip
  Scenario Outline: NLSF-1183 AC1 - Search - Desktop: recent searches, AC2  - Search - Desktop: select a recent search, AC5- Search - mobile: recent searches, AC6  - Search - Mobile/tablet: select a recent search, AC10  - Recent search across devices
	Given user navigates to <page> page
	When I click on search bar
	Then I see the cursor blink in search box in hover state
	Then I see the recent search list
	Then I click on recent searched list option
	# this below step only validate the aws redirection now as per ticket 1993 it will redirect to aws and we will test this on integ env.
	And  I see expected result page for recent search
		Examples:	 
      |page                      |
      |my-account-orders         |
      |orderDetails.homeDelivery |
      |orderDetails.collection   |
      |my-account                |
  
  @NLSF-1183 @desktop @mobile @tablet @iphone @mac
  Scenario Outline: NLSF-1183 AC3  - Search - Desktop: clear recent searches, AC7  - Search - Mobile/tablet: clear recent searches
	Given user navigates to <page> page
	When I click on search bar 
	Then I see the cursor blink in search box in hover state
	And I click on clear link for recent search
	And I see there is no recent search list and clear link display 
	And I see no cursor blink in search box and its not in hover state
		Examples:	 
      |page                      |
      |my-account-orders         |
      |orderDetails.homeDelivery |
      |orderDetails.collection   |
      |my-account                |
      
  @NLSF-1183 @desktop @mobile @tablet @iphone @mac
  Scenario Outline: NLSF-1183  AC4  - Search - Desktop: start to type, AC8  - Search - mobile/tablet: start to type
	Given user navigates to <page> page
	When I type a <searchTerm> search term into the search bar
	Then I see there is no recent search list and clear link display 
		Examples:	 
      |page                      |searchTerm               |
      |my-account-orders         |TwoCharacterSearchResults|
      |orderDetails.homeDelivery |TwoCharacterSearchResults|
      |orderDetails.collection   |TwoCharacterSearchResults|
      |my-account                |TwoCharacterSearchResults|
   
	@desktop @smoke @smoke-my-account @my-account
	Scenario: [UI] Header Smoke Test 1 : Header checks
		Given user navigates to my-account page
		Then The header welcome message is visible
		And The account icon is visible
		When I scroll down the header is not visible
		And I scroll to the top of the page the standard header elements should be visible

		When I click on the saved items icon on header
		Then the saved items page slides open as side panel
		And the side panel is closed when closed

		When I hover over the header welcome message
		Then The header mini menu is visible
		When I click on the mini menu my-account-orders link
		Then I am on the my-account-orders page

		When I hover over the header welcome message
		And I click on the mini menu sign out button
		And I have been signed out
		And The signed out notification is visible

	@desktop @mobile @tablet @smoke @smoke-my-account @my-account @samsung
	Scenario: [UI] Header Smoke Test 2 : Search
		Given user navigates to my-account page
	  	And I click on the search toggle if visible
		And The search bar is visible
		And The search bar placeholder text is visible
		And The search icon is visible
		When I type a some-results search term into the search bar
		And I click on the search icon
		Then My some-results search term is visible in the URL

	@NLSF-1622 @desktop @mobile @tablet @samsung @mac
	Scenario Outline: NLSF-1622 AC1 - Key Page Attributes <page> page on <site>
		Given user navigates to <page> page on <site> site
		Then check key attributes set for <page> page on the SPA site
		Examples:
			| site | page                 |
			| uk   | account    |
			| uk   | my-account-orders    |
			| uk   | address-book    |
			| uk   | collection-locations |
			| uk   | my-account-delivery-pass-51300069999   |
			| uk   | saved-cards                    |
			| uk   | profile                        |
			| uk   | my-account-contact-preferences |
			| uk   | orderDetails.collection        |
			| uk   | orderDetails.homeDelivery      |

			| fr   | account                        |
			| fr   | my-account-orders              |
			| fr   | address-book                   |
			| fr   | collection-locations           |
			| fr   | saved-cards                    |
			| fr   | profile                        |
			| fr   | my-account-contact-preferences |
			| fr   | orderDetails.collection        |
			| fr   | orderDetails.homeDelivery      |

			| de   | account                        |
			| de   | my-account-orders              |
			| de   | address-book                   |
			| de   | collection-locations           |
			| de   | saved-cards                    |
			| de   | profile                        |
			| de   | my-account-contact-preferences |
			| de   | orderDetails.collection        |
			| de   | orderDetails.homeDelivery      |

			| row  | account                        |
			| row  | my-account-orders              |
			| row  | address-book                   |
			| row  | collection-locations           |
			| row  | saved-cards                    |
			| row  | profile                        |
			| row  | my-account-contact-preferences |
			| row  | orderDetails.collection        |
			| row  | orderDetails.homeDelivery      |


