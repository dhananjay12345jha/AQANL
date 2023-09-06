Feature: [UI] MyPersonalDetails page
  AS A Hard-Logged In Customer

  @NLSF-562 @NLSF-563 @desktop @mobile @tablet @iphone @mac
  Scenario Outline: NLSF-562 AC2 – My Personal details Page, AC3 – Breadcrumb on <site> site
	Given user navigates to my-personal-details page on <site> site as user with noOrders
	Then The myPersonalDetails breadcrumb link is visible
	And user able to see Personal Details Card title
	And user able to see the name on personal detail page
	And user able to see gender date of birth and mobile number of user noOrders
	And user able to see my staff card number on personal detail page
	And User able to see email address and password on my account page
    Examples:
      | site |
      | uk   |
      | fr   |
      | de   |
      | row  |

	@NLSF-562 @desktop @mobile @tablet @samsung @mac @smoke @smoke-my-account @my-account
  Scenario Outline: NLSF-562 AC1 – My Personal details Page on <site> site
	Given user navigates to my-personal-details page on <site> site as user with multipleOrders
	And user able to see Personal Details Card title
    And user able to see the name on personal detail page
    And user able to see gender date of birth and mobile number of user multipleOrders
	And user not  able to see my staff card number on personal detail page
	And User able to see email address and password on my account page
    And user able to see summary details of My Data Privacy Rights
      Examples:
        | site |
        | uk   |
        | fr   |
        | de   |
        | row  |

  @NLSF-558 @desktop @mobile @tablet @iphone
  Scenario Outline: NLSF-558 AC1 - Update Password Link, AC2 - Update Password, AC4 - Update Password - Cancel on <site> site
    Given user navigates to my-personal-details page on <site> site as user with multipleOrders
    And user can see a Personal Details card has a link to update my Password
    Then click Update Password link
    Then check page navigate to Update My Password form
    Then check Current Password field and New Password field are empty
    Then check update both fields and cancel will be taken back to the Personal Details page
    Examples:
      | site |
      | uk   |
      | fr   |
      | de   |
      | row  |

  @NLSF-558 @desktop @mobile @tablet @iphone @mac
  Scenario Outline: NLSF-558 AC3 - Update Password – Save on <site> site
    Given user navigates to my-personal-details page on <site> site as user with multipleOrders
    Then click Update Password link
    Then check page navigate to Update My Password form
    And user entered correct password in Current Password field and New Password field
    And click Update Password button
    And verify pageoffset
    Then check updated successfully notification display
    Examples:
      | site |
      | uk   |
      | fr   |
      | de   |
      | row  |

  @NLSF-558 @desktop @mobile @tablet @iphone @mac
  Scenario Outline: NLSF-558 AC5 - Update Password - Masked Password, AC6 - Update Password - Show Password on <site> site
    Given user navigates to my-personal-details page on <site> site as user with multipleOrders
    Then click Update Password link
    Then check page navigate to Update My Password form
    And check both password fields are set to mask the password
    Then check user can toggle to unmask the password
    Then check can show password in each field individually
    And check type any further characters in the field they will be unmasked
    Then check user can toggle to mask the password again in that field
    Examples:
      | site |
      | uk   |
      | fr   |
      | de   |
      | row  |

  @NLSF-558 @NLSF-1945 @desktop @mobile @tablet @iphone @mac
  Scenario Outline:NLSF-1945 update password translation test  NLSF-558 AC7 - Update Password - Password Validation, AC8 - Update Password - Incorrect current password on <site> site
    Given user navigates to my-personal-details page on <site> site as user with multipleOrders
    Then click Update Password link
    Then check page navigate to Update My Password form
    And entered an incorrect password in the New Password field
    Then check get error message for New Password field
    Then entered correct password in the New Password field
    Examples:
      | site |
      | uk   |
      | fr   |
      | de   |
      | row  |

  @NLSF-558 @NLSF-1945 @desktop @mobile @tablet @iphone @mac
  Scenario Outline: NLSF- 1945 NLSF-558 AC8 - Update Password - Incorrect current password on <site> site
    Given user navigates to my-personal-details page on <site> site as user with multipleOrders
    Then click Update Password link
    Then check page navigate to Update My Password form
    And entered an incorrect password in the Current Password field
    Then check get error message for Current Password field
    Then entered correct password in the Current Password field
    Examples:
      | site |
      | uk   |
      | fr   |
      | de   |
      | row  |

  @NLSF-557 @desktop @mobile @tablet @iphone @mac
  Scenario Outline: NLSF-557 AC1 – Data Privacy Link
    Given user navigates to my-personal-details page on <site> site as user with multipleOrders
    And user able to see summary details of My Data Privacy Rights
    Then click the link of find out more
    Then check linked to Privacy Help Page
    Examples:
      | site |
      | uk   |
      | fr   |
      | de   |
      | row  |

  @NLSF-559 @desktop @mobile @tablet @samsung @mac
  Scenario Outline: NLSF-559 - AC1, AC2, AC3, AC5, AC6 - Update Email Link on <site> site
    Given user navigates to my-personal-details page on <site> site
    And The personal details page contains my old email address
    And The update email link is visible
    When I click on the update email link
    Then The update email form is visible

    When I type matching email addresses into the update email form
    And I type my password into the update email form
    And The password in the update email form is masked
    And I click on the hide password toggle in the update email form
    Then The password in the update email form is unmasked
    When I click on the hide password toggle in the update email form
    Then The password in the update email form is masked

    And Clicking the update email button updates my email address
    And The personal details updated message is visible for 5 seconds
    And The update email form is not visible
    Examples:
      | site |
      | uk   |
      | fr   |
      | de   |
      | row  |

	@NLSF-559 @desktop @mobile @tablet @iphone @mac
  Scenario: NLSF-559 - AC4 - Update Email - Cancel
	Given user navigates to my-personal-details page
	And I click on the update email link
	And The update email form is visible
	When I click on the cancel button on the update email form
	Then The update email form is not visible
	And The update email form is not visible
	And The personal details page contains my old email address

	@NLSF-559 @desktop @mobile @tablet @samsung
  Scenario: NLSF-559 - AC7, AC8, AC9 - Update Email - Email/password validation
	Given user navigates to my-personal-details page
	And I click on the update email link
	When I type invalid matching email addresses into the update email form
	And I click on the update email button
	Then The update email form is visible
	And The invalid email address error message is visible

	When I type mismatched email addresses into the update email form
	And I click on the update email button
	Then The update email form is visible
	And The mismatched email address error message is visible

	When I type matching email addresses into the update email form
	And I type an incorrect password into the update email form
	And I click on the update email button
	Then The update email form is visible
	And The incorrect password error message is visible

  #@NLSF-560 @desktop @mobile @tablet
  # Bug 2234 raised for wrong messageonce resolved below 3rd step should be pass
  Scenario Outline: NLSF-560 AC1 - Update Personal Details Link, AC2 - Update Personal Details, AC3 - Update Personal Details - Save on <site> site
    Given user navigates to my-personal-details page on <site> site as user with longName
    Then click Update Details link
    Then check page navigate to Update My Detail form
    And update all fields and submit
    Then check updated successfully notification display
    Examples:
      | site |
      | uk   |
      | fr   |
      | de   |
      | row  |

  @NLSF-560 @desktop @mobile @tablet
  Scenario Outline: NLSF-560 AC2 - Update Personal Details on <site> site
    Given user navigates to my-personal-details page on <site> site as user with longName
    Then click Update Details link
    And check there is a limit of 60 characters for first name and last name fields
    Examples:
      | site |
      | uk   |
      | fr   |
      | de   |
      | row  |

  @NLSF-560 @desktop @mobile @tablet
  Scenario Outline: NLSF-560 AC4 - Update Personal Details - Cancel on <site> site
    Given user navigates to my-personal-details page on <site> site as user with longName
    Then click Update Details link
    Then update all fields and cancel
    Then check page navigate to my personal detail page with no notification display
    Examples:
      | site |
     | uk   |
      | fr   |
     | de   |
     | row  |