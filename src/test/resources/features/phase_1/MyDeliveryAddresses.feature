Feature: [UI] My Delivery Addresses
  AS A Hard-Logged In Customer

  #this Story is partially done with workaround URL, this can be modify later once NLSF-1849 US fix the issue
  @NLSF-547 @desktop @mobile @tablet @samsung
	@test
  Scenario Outline: NLSF-547-AC1 - Empty My Addresses
	Given user navigates to my-account page on <site> site
	When I append address-book/?empty=true to the current URL
	Then I see the empty address page and add address button
	Examples:
	  | site |
	  | uk   |
	  | row  |
	  | de   |
	  | fr   |
# The NLSF-546 AC2 and AC3 need to be test again once wiremock ticket NLSF-1852 is done. In AC1 the defalut meesage need tochecka again once wiremock ticket is dones
  @NLSF-1946 @NLSF-1945 @NLSF-546 @desktop @mobile @tablet @iphone
  Scenario Outline:NLSF-1945- Add Address button translation test NLSF-546-Ac1  NLSF-1946-AC1 - Set default address
	Given user navigates to address-book page on <site> site
	Then The this is your default address message is visible
	And The set as default address button is visible
	When user click on Set as default address button
	And The Add Address button is visible
	Examples:
	  | site |
	  | uk   |
	  | row  |
	  | de   |
	  | fr   |

  @NLSF-545 @desktop @mobile @tablet @samsung
  Scenario Outline: NLSF-545 - AC1, AC2, AC4 - Delete address (cancel)
	Given user navigates to address-book page on <site> site
	And The delete address link is visible on all addresses
	When I click on the delete address button under my default address
	Then The delete address popup is visible
	And The delete address popup is populated with my default address

	When I click on the cancel button on the delete address popup
	Then The delete address popup is not visible

	Examples:
	  | site |
	  | uk   |
	  | row  |
	  | de   |
	  | fr   |

	@NLSF-580 @desktop @mobile @tablet @samsung
	Scenario Outline: NLSF-580 - AC1, AC2, AC3 - Add address - change country
		Given user navigates to address-book page on <site> site
		Then The Add Address button is visible
		When user chooses to add new address with <new_country>
		Then the Add address form is updated with <new_country>
		And current delivery <site> is not changed
		And Address finder search field is not present if <new_country> is not UK

		Examples:
			| site | new_country            |
			| uk   | address.country.france |
			| row  | address.country.uk     |
			| uk   | address.country.uk     |

	@NLSF-579 @desktop @mobile @samsung
	Scenario Outline: NLSF-579 - AC1 - Add Address - UK, NLSF-579 - AC2 - Add Address - Non-UK on <site>
		Given user navigates to address-book page on <site> site as user with longName
		When click add address button
		When click enter address manually link
		Then able to see ‘Add Address’ in page form
		And check the Country field is mandatory and editable pre-populated with current Country
		And check the Title, First Name and Last Name as a mandatory and editable fields pre-populated
		And check the Address Line 1 of the address
		And check the Address Line 2 of the address
		And check able to select and add another address line
		And check the Town City of the address
		And check the County of the address
		And check the Postcode of the address
		And check all mandatory fields
		Examples:
			| site |
			| uk   |
			| row  |
			| de   |
			| fr   |

	@NLSF-579 @desktop @mobile @iphone
	Scenario: NLSF-579 - AC3 - Add Address - Add address line
		Given user navigates to address-book page on uk site
		When click add address button
		When click enter address manually link
		Then able to see ‘Add Address’ in page form
		And check the Address Line 1 of the address
		And check the Address Line 2 of the address
		And check able to select and add another address line
		And click Back to address search and go back to address search

	@NLSF-581 @desktop
	Scenario Outline: NLSF-581 - AC2 - Add/Edit Address - Incomplete, AC3 - Add/Edit Address - Postcode Failure, AC4 - Add/Edit Address - Cancel, AC6 - Add /Edit Address - Character Limits on <site>
		Given user navigates to address-book page on <site> site as user with longName
		When click edit address button to enter Edit Address page
		When click edit addresses button in Edit Address page
		Then check all mandatory fields
		Then check all fields limitation
		Then click Cancel CTA and redirect to page My Addresses page
		Examples:
			| site |
			| uk   |
			| row  |
			| de   |
			| fr   |