package com.auto.steps;
import com.auto.pages.*;
import com.auto.props.UserProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class MyPersonalDetailsSteps {
    @Autowired
    private MyPersonalDetailsPage myPersonalDetailsPage;

    @Autowired
    private MyOrdersPage myOrdersPage;

    @Autowired
    FooterPage footerPage;

    @Autowired
    CommonPage commonPage;

    @Autowired
    private HeaderPage headerPage;

    @And("^user able to see Personal Details Card title$")
    public void personalDetailCardTitle() {
        myPersonalDetailsPage.validateTitleOfMyPersonalPage();

    }

    @And("^user able to see the name on personal detail page$")
    public void nameOnPersonalPage() {
        myPersonalDetailsPage.validateNameField();
    }

    @And("^user able to see gender date of birth and mobile number of user (.*)$")
    public void genderDobMobileNumberOnPersonalPage(String user) {
        myPersonalDetailsPage.checkGenderField(user);
        myPersonalDetailsPage.dateBirthAndMobileFiled(user);
    }

    @And("^user able to see my staff card number on personal detail page$")
    public void staffNumberPersonalPage() {
        myPersonalDetailsPage.staffCardNumberDetails();
    }

    @And("^User able to see email address and password on my account page$")
    public void emailPasswordOnPersonalPage() {
        myPersonalDetailsPage.emailAndPasswordDetails();

    }

    @And("^user not  able to see my staff card number on personal detail page$")
    public void staffNumberNotVisible() {
        myPersonalDetailsPage.staffCardNumberDetailsNotVisible();
    }

	@And("I click on the update email link")
	public void iClickOnTheUpdateEmailLink()
	{
		myPersonalDetailsPage.clickUpdateEmailLink();
	}

    @And("The update email form is visible")
    public void theUpdateEmailFormIsVisible()
    {
        myPersonalDetailsPage.updateEmailFormIsVisible();
    }

    @When("I click on the cancel button on the update email form")
    public void iClickOnTheCancelButtonOnTheUpdateEmailForm()
    {
        myPersonalDetailsPage.clickUpdateEmailCancelButton();
    }

    @Then("The update email form is not visible")
    public void theUpdateEmailFormIsNotVisible()
    {
        myPersonalDetailsPage.updateEmailFormIsNotVisible();
    }

    @And("The personal details page contains my old email address")
    public void thePersonalDetailsPageContainsMyOldEmailAddress()
    {
        myPersonalDetailsPage.emailAddressIs(UserProperties.getEmail("existing"));
    }

    @When("I type invalid matching email addresses into the update email form")
    public void iTypeInvalidMatchingEmailAddressesIntoTheUpdateEmailForm() {
        final String emailAddress = RandomStringUtils.randomAlphabetic(5);
        myPersonalDetailsPage.typeEmailAddress(emailAddress);
        myPersonalDetailsPage.typeConfirmEmailAddress(emailAddress);
    }

    @And("I click on the update email button")
    public void iClickOnTheUpdateEmailButton()
    {
        myPersonalDetailsPage.clickUpdateEmailButton();
    }

    @And("The invalid email address error message is visible")
    public void theInvalidEmailAddressErrorMessageIsVisible()
    {
        myPersonalDetailsPage.invalidEmailAddressErrorMessageIsVisible();
    }

    @When("I type mismatched email addresses into the update email form")
    public void iTypeMismatchedEmailAddressesIntoTheUpdateEmailForm()
    {
        myPersonalDetailsPage.typeEmailAddress(UserProperties.getEmail("existing"));
        myPersonalDetailsPage.typeConfirmEmailAddress(UserProperties.getEmail("new"));
    }

    @When("I type matching email addresses into the update email form")
    public void iTypeMatchingEmailAddressesIntoTheUpdateEmailForm()
    {
        final String email = RandomStringUtils.randomAlphabetic(10) + "@test.com";
        myPersonalDetailsPage.typeEmailAddress(email);
        myPersonalDetailsPage.typeConfirmEmailAddress(email);
    }

    @And("I type an incorrect password into the update email form")
    public void iTypeAnIncorrectPasswordIntoTheUpdateEmailForm()
    {
        myPersonalDetailsPage.typePassword(RandomStringUtils.randomAlphabetic(5) +
                                           RandomStringUtils.randomNumeric(5));
    }

    @And("The incorrect password error message is visible")
    public void theIncorrectPasswordErrorMessageIsVisible()
    {
        myPersonalDetailsPage.invalidPasswordErrorMessageIsVisible();
    }

    @And("The mismatched email address error message is visible")
    public void theMismatchedEmailAddressErrorMessageIsVisible()
    {
        myPersonalDetailsPage.mismatchedEmailErrorMessageIsVisible();
    }

    @And("The update email link is visible")
    public void theUpdateEmailLinkIsVisible()
    {
        myPersonalDetailsPage.updateEmailLinkIsVisible();
    }

    @And("I type my password into the update email form")
    public void iTypeMyPasswordIntoTheUpdateEmailForm()
    {
        myPersonalDetailsPage.typePassword(UserProperties.getPassword("existing"));
    }

    @Then("click Update Password link")
    public void clickUpdatePasswordLink() {
        myPersonalDetailsPage.clickUpdatePasswordLink();
    }

    @And("user can see a Personal Details card has a link to update my Password")
    public void userCanSeeAPersonalDetailsCardHasALinkToUpdateMyPassword() {
        myPersonalDetailsPage.checkPersonalDetailsCardHasALinkToUpdateMyPassword();
    }

    @And("user able to see summary details of My Data Privacy Rights")
    public void userAbleToSeeSummaryDetailsOfMyDataPrivacyRights() {
        myPersonalDetailsPage.checkSummaryDetailsOfMyDataPrivacyRights();
    }

    @Then("The password in the update email form is masked")
    public void thePasswordInTheUpdateEmailFormIsMasked()
    {
        myPersonalDetailsPage.updateEmailPasswordFormIsMasked();
    }

    @Then("The password in the update email form is unmasked")
    public void thePasswordInTheUpdateEmailFormIsUnmasked()
    {
        myPersonalDetailsPage.updateEmailPasswordFormIsUnmasked();
    }

    @Then("click the link of find out more")
    public void clickTheLinkOfFindOutMore() {
        myPersonalDetailsPage.clickTheLinkOfFindOutMore();
    }

    @And("I click on the hide password toggle in the update email form")
    public void iClickOnTheHidePasswordToggleInTheUpdateEmailForm()
    {
        myPersonalDetailsPage.clickHidePasswordToggle();
    }

    @Then("check linked to Privacy Help Page")
    public void checkLinkedToPrivacyHelpPage() {
        myPersonalDetailsPage.checkLinkedToPrivacyHelpPage();
    }

    @And("Clicking the update email button updates my email address")
    public void clickingTheUpdateEmailButtonUpdatesMyEmailAddress()
    {
        myPersonalDetailsPage.clickingUpdateEmailButtonUpdatesEmailAddress();
    }

    @And("The personal details updated message is visible for {int} seconds")
    public void thePersonalDetailsUpdatedMessageIsVisibleForSeconds(final int seconds)
    {
        myPersonalDetailsPage.personalDetailsUpdatedMessageIsVisibleForSeconds(seconds);
    }

    @Then("check page navigate to Update My Password form")
    public void checkPageNavigateToUpdateMyPasswordForm() {
        myPersonalDetailsPage.checkPageNavigateToUpdateMyPasswordForm();
    }

    @Then("check Current Password field and New Password field are empty")
    public void checkCurrentPasswordFieldAndNewPasswordFieldAreEmpty() {
        myPersonalDetailsPage.checkCurrentPasswordFieldAndNewPasswordFieldAreEmpty();
    }

    @Then("^check update both fields and cancel will be taken back to the Personal Details page$")
    public void checkUpdateBothFieldsAndCancelWillBeTakenBackToThePersonalDetailsPage() {
        myPersonalDetailsPage.checkCancelUpdate();
    }

    @And("user entered correct password in Current Password field and New Password field")
    public void userEnteredAndSaveCorrectPasswordInCurrentPasswordFieldAndNewPasswordField() {
        myPersonalDetailsPage.enterCorrectPwd();
    }

    @Then("check updated successfully notification display")
    public void checkUpdatedSuccessfullyNotificationDisplay() {
        myPersonalDetailsPage.checkUpdatedSuccessfulNotification();
    }

    @And("check both password fields are set to mask the password")
    public void checkBothPasswordFieldsAreSetToMaskThePassword() {
        myPersonalDetailsPage.checkBothPasswordFieldsAreSetToMaskThePassword();
    }

    @Then("check user can toggle to unmask the password")
    public void checkUserCanToggleToUnmaskThePassword() {
        myPersonalDetailsPage.checkUserCanToggleToUnmaskThePassword();
    }

    @Then("check can show password in each field individually")
    public void checkCanShowPasswordInEachFieldIndividually() {
        myPersonalDetailsPage.checkCanShowPasswordInEachFieldIndividually();
    }

    @And("check type any further characters in the field they will be unmasked")
    public void checkTypeAnyFurtherCharactersInTheFieldTheyWillBeUnmasked() {
        myPersonalDetailsPage.checkTypeCharactersWillBeUnmasked();
    }

    @Then("check user can toggle to mask the password again in that field")
    public void checkUserCanToggleToMaskThePasswordAgainInThatField() {
        myPersonalDetailsPage.toggleToMaskTheField();
    }

    @And("entered an incorrect password in the Current Password field")
    public void enteredAnIncorrectPasswordInTheCurrentPasswordField() {
        myPersonalDetailsPage.clearNewPasswordInput();
        myPersonalDetailsPage.inputPasswordInTheCurrentPasswordField(false);
        myPersonalDetailsPage.clickUpdatePasswordBtn();
    }

    @And("entered an incorrect password in the New Password field")
    public void enteredAnIncorrectPasswordInTheNewPasswordField() {
        myPersonalDetailsPage.inputPasswordInTheNewPasswordField(false);
        myPersonalDetailsPage.clickUpdatePasswordBtn();
    }

    @Then("check get error message for New Password field")
    public void checkGetErrorMessageForNewPasswordField() {
        myPersonalDetailsPage.checkGetErrorMessageForNewPasswordField();
        myPersonalDetailsPage.clearCurrentPasswordInput();
    }

    @Then("entered correct password in the New Password field")
    public void enteredCorrectPasswordInTheNewPasswordField() {
        myPersonalDetailsPage.inputPasswordInTheNewPasswordField(true);
    }

    @Then("check get error message for Current Password field")
    public void checkGetErrorMessageForCurrentPasswordField() {
        myPersonalDetailsPage.checkGetErrorMessageForCurrentPasswordField();
    }

    @Then("entered correct password in the Current Password field")
    public void enteredCorrectPasswordInTheCurrentPasswordField() {
        myPersonalDetailsPage.clearCurrentPasswordInput();
        myPersonalDetailsPage.inputPasswordInTheCurrentPasswordField(true);
        myPersonalDetailsPage.clickUpdatePasswordBtn();
    }

    @Then("get error message in Personal Detail page")
    public void getErrorMessageInPersonalDetailPage() {
        myPersonalDetailsPage.getErrorMessageInPersonalDetailPage();
    }

    @And("click Update Password button")
    public void clickUpdatePasswordButton() {
        myPersonalDetailsPage.clickUpdatePasswordBtn();
    }

    @And("user entered password in Current Password field and New Password field")
    public void userEnteredPasswordInCurrentPasswordFieldAndNewPasswordField() {
        myPersonalDetailsPage.enterPwd();
    }

    @Then("check page skeleton structure not compromised for Personal Details page")
    public void checkPageSkeletonStructureNotCompromisedForPersonalDetailsPage() {
        myOrdersPage.checkLeftNav();
        footerPage.checkFooterColumnStructure();
        headerPage.checkStandardHeaderIsVisibleOnTop();
    }

    @Then("click Update Details link")
    public void clickUpdateDetailsLink() {
        myPersonalDetailsPage.clickUpdateDetailsLink();
    }

    @Then("check page navigate to Update My Detail form")
    public void checkPageNavigateToUpdateMyDetailForm() {
        myPersonalDetailsPage.checkPageNavigateToUpdateMyDetailForm();
    }

    @And("update all fields and submit")
    public void updateAllFieldsAndSubmit() {
        myPersonalDetailsPage.updateAllFields();
        myPersonalDetailsPage.clickSubmitBtn();
    }

    @Then("update all fields and cancel")
    public void updateAllFieldsAndCancel() {
        myPersonalDetailsPage.updateAllFields();
        myPersonalDetailsPage.clickCancelBtn();
    }

    @Then("check page navigate to my personal detail page with no notification display")
    public void checkPageNavigateToMyPersonalDetailPageWithNoNotificationDisplay() {
        myPersonalDetailsPage.checkPageNavigateToMyPersonalDetailPageWithNoNotificationDisplay();
    }

    @And("check there is a limit of 60 characters for first name and last name fields")
    public void checkThereIsALimitOfCharactersForFirstNameAndLastNameFields() {
        myPersonalDetailsPage.fieldsLimitation();
    }
}
