package com.auto.pages;

import com.auto.base.BasePage;
import com.auto.config.PropertyConfig;
import com.auto.props.PersonalDetailsProperties;
import com.auto.utils.LocaleUtils;
import com.automation.core.base.ExtWebElement;
import com.automation.core.utilities.Sleeper;
import com.automation.core.utilities.assertion.AssertUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.auto.utils.DeviceUtils.isIphone;
import static com.auto.utils.DeviceUtils.isSamsung;

public class MyPersonalDetailsPage extends BasePage {
    @FindBy(css = "[data-testid='pageTitle']")
    private ExtWebElement title;

    @FindBy(css = "[data-testid='nameData']")
    private ExtWebElement name;
    @FindBy(css = "[data-testid='genderData']")
    private ExtWebElement gender;
    @FindBy(css = "[data-testid='dateOfBirthHeader']")
    private ExtWebElement dateOfBirthHeader;
    @FindBy(css = "[data-testid='dateOfBirthData']")
    private ExtWebElement dateOfBirthDetail;
    @FindBy(css = "[data-testid='dateOfBirthPlaceholder']")
    private ExtWebElement dateOfBirthPlaceholder;
    @FindBy(css = "[data-testid='mobileData']")
    private ExtWebElement mobileData;

    @FindBy(css = "[data-testid='mobilePlaceholder']")
    private ExtWebElement mobilePlaceholder;

    @FindBy(css = "[data-testid='mobileHeader']")
    private ExtWebElement mobileHeader;
    @FindBy(css = "[data-testid='staffCardNumberHeader']")
    private ExtWebElement staffCardNumber;
    @FindBy(css = "[data-testid='emailData']")
    private ExtWebElement email;
    @FindBy(css = "[data-testid='passwordData']")
    private ExtWebElement password;

    @FindBy(css = "[data-testid='personal-details-data-privacy'] div")
    private ExtWebElement dataPrivacyRightTitle;

    @FindBy(css = "[data-testid='personal-details-data-privacy-link'] span")
    private ExtWebElement dataPrivacyRightLink;

    @FindBy(css = "[data-testid='personal-details-data-privacy-title']")
    private ExtWebElement dataPrivacyRightDetail;

    @FindBy(css = "[data-testid='openUpdateEmailModalBtn']")
    private ExtWebElement updateEmailLink;

    @FindBy(css = "[data-testid='UpdateEmailForm']")
    private ExtWebElement updateEmailForm;

    @FindBy(css = "[data-testid='CancelUpdateEmailButton']")
    private ExtWebElement updateEmailFormCancelButton;

    @FindBy(css = "[data-testid='UpdateEmailInput-input']")
    private ExtWebElement updateEmailFormEmailField;

    @FindBy(css = "[data-testid='UpdateConfirmInput-input']")
    private ExtWebElement updateEmailFormConfirmEmailField;

    @FindBy(css = "[data-testid='UpdateEmailPassword-input']")
    private ExtWebElement updateEmailFormPasswordField;

    @FindBy(css = "[data-testid='UpdateEmailButton']")
    private ExtWebElement updateEmailFormUpdateButton;

    @FindBy(css = "[data-testid='UpdateEmailInput-container'] [data-testid='error']")
    private ExtWebElement invalidEmailAddressErrorMessage;

    @FindBy(css = "[data-testid='newPasswordInput-container'] [data-testid='error']")
    private ExtWebElement invalidPasswordErrorMessage;

    @FindBy(css = "[data-testid='UpdateConfirmInput-container'] [data-testid='error']")
    private ExtWebElement mismatchedEmailErrorMessage;

    @FindBy(css = "[data-testid='passwordIcon']")
    private ExtWebElement hidePasswordToggle;

    @FindBy(css = "[data-testid='updateMessageContainer']")
    private ExtWebElement personalDetailsUpdatedMessage;

    @FindBy(css = "[data-testid='updatePasswordHeader'] span")
    private ExtWebElement updatePasswordLink;

    @FindBy(css = "[data-testid='updatePasswordForm']")
    private ExtWebElement updatePasswordForm;

    @FindBy(css = "input[name='password']")
    private ExtWebElement currentPasswordInput;

    @FindBy(css = "[data-testid='genderHeader']")
    private ExtWebElement genderHeader;

    @FindBy(css = "[data-testid='genderData']")
    private ExtWebElement genderData;

    @FindBy(css = "[data-testid='genderPlaceholder']")
    private ExtWebElement genderPlaceholder;

    @FindBy(css = "input[name='newPassword']")
    private ExtWebElement newPasswordInput;

    @FindBy(css = "[data-testid='updatePasswordBtn']")
    private ExtWebElement updatePasswordBtn;

    @FindBy(css = "[data-testid='updatePasswordCancelBtn']")
    private ExtWebElement updatePasswordCancelBtn;

    @FindBy(css = "[data-testid='updateMessageContainer'] span")
    private ExtWebElement notificationMessage;

    @FindBy(css = "[data-testid='passwordIcon']")
    private List<ExtWebElement> passwordIcons;

    @FindBy(css = "[data-testid^='error']")
    private List<ExtWebElement> errorMessages;

    @FindBy(css = "[data-testid*='validationMessageMessage_']")
    private List<ExtWebElement> validationMessages;

    @FindBy(css = "button[data-testid='mobileCancelBtn']")
    private ExtWebElement mobileCancelBtn;

    @FindBy(css = "button[data-testid='updateDetailsBtn']")
    private ExtWebElement updateDetailsBtn;

    @FindBy(css = "[data-testid='updatePasswordHeading']")
    private ExtWebElement updatePasswordHeading;

    @FindBy(css = "[data-testid='passwordInput-label']")
    private ExtWebElement currentpassWordTitle;

    @FindBy(css = "[data-testid='newPasswordInput-label']")
    private ExtWebElement newpassWordTitle;
    @FindBy(css = "[data-testid='pageContent'] div div h2")
    private ExtWebElement updateMyDetailTitle;

    @FindBy(css = "[data-testid='title-dropdown-label']")
    private ExtWebElement titleTitle;

    @FindBy(css = "[id='mui-component-select-titleCode']")
    private ExtWebElement titleValue;

    @FindBy(css = "[data-testid='title-dropdown-option-mrs']")
    private ExtWebElement mrsOptions;

    @FindBy(css = "[data-testid='birth-year-dropdown-option-2016']")
    private ExtWebElement yearOption2016;

    @FindBy(css = "[data-testid='birth-month-dropdown-option-02']")
    private ExtWebElement monthOption2;

    @FindBy(css = "[data-testid='birth-day-dropdown-option-04']")
    private ExtWebElement dayOption4;

    @FindBy(css = "[data-testid='first-name-input']")
    private ExtWebElement firstNameInput;

    @FindBy(css = "[data-testid='last-name-input']")
    private ExtWebElement lastNameInput;

    @FindBy(css = "[data-testid='mobile-number-input']")
    private ExtWebElement mobileNumberInput;

    private By firstNameInputBy = By.cssSelector("[data-testid='first-name-input']");

    private By lastNameInputBy = By.cssSelector("[data-testid='last-name-input']");

    private By mobileNumberInputBy = By.cssSelector("[data-testid='mobile-number-input']");

    @FindBy(css = "[data-testid='mobile-number-label']")
    private ExtWebElement mobileNumberTitle;

    @FindBy(css = "[data-testid='mobile-number-blurb']")
    private ExtWebElement mobileNumberLabel;

    @FindBy(css = "[data-testid='first-name-label']")
    private ExtWebElement firstNameTitle;

    @FindBy(css = "[data-testid='last-name-label']")
    private ExtWebElement lastNameTitle;

    @FindBy(css = "[data-testid='gender-radio-group-label']")
    private ExtWebElement genderTitle;

    @FindBy(css = "[data-testid='gender-radio-group-label-FEMALE'] input")
    private ExtWebElement femaleSelector;

    @FindBy(css = "[data-testid='gender-radio-group-label-MALE'] input")
    private ExtWebElement maleSelector;

    @FindBy(css = "[data-testid='gender-radio-group-label-FEMALE'] span:nth-child(2)")
    private ExtWebElement femaleTitle;

    @FindBy(css = "[data-testid='gender-radio-group-label-MALE'] span:nth-child(2)")
    private ExtWebElement maleTitle;

    @FindBy(css = "[data-testid='gender-radio-group-container'] ~p")
    private ExtWebElement dateOfBirthTitle;

    @FindBy(css = "[id='mui-component-select-birthDay']")
    private ExtWebElement dayDropdown;

    @FindBy(css = "[id='mui-component-select-birthMonth']")
    private ExtWebElement monthDropdown;

    @FindBy(css = "[id='mui-component-select-birthYear']")
    private ExtWebElement yearDropdown;

    @FindBy(css = "[data-testid='cancel-update-details-btn']")
    private ExtWebElement cancelBtn;

    @FindBy(css = "[data-testid='submit-btn']")
    private ExtWebElement updatePersonalDetailsBtn;

    @FindBy(css = "[data-testid='first-name-container'] [data-testid='error']")
    private ExtWebElement firstNameError;

    @FindBy(css = "[data-testid='last-name-container'] [data-testid='error']")
    private ExtWebElement lastNameError;

    public void validateTitleOfMyPersonalPage() {
        Sleeper.sleep(8000);
        AssertUtils.assertContains(getTitle(), title.getText());
    }

    public void validateNameField() {
        Assert.assertTrue(name.isDisplayed());
    }

    public void checkGenderField(String user) {
        Assert.assertEquals(PropertyConfig.getValue("personal.overview.gender.title"), genderHeader.getText());
        Assert.assertEquals(PropertyConfig.getValue("personal.overview.gender." + getUserValue(user) + ".detail"), user.equals("multipleOrders") ? genderPlaceholder.getText():genderData.getText());

    }

    public String getUserValue(String user) {
        String userValue = "user1";
        if (user.equals("multipleOrders")) {
            userValue = "user2";
        }
        return userValue;
    }

    public void dateBirthAndMobileFiled(String user) {
        Assert.assertEquals(PropertyConfig.getValue("personal.overview.mobile.title"), mobileHeader.getText());
        Assert.assertEquals(PropertyConfig.getValue("personal.overview.mobile." + getUserValue(user) + ".detail"), user.equals("multipleOrders") ? mobilePlaceholder.getText(): mobileData.getText());
        Assert.assertEquals(PropertyConfig.getValue("personal.overview.dateOfBirth.title"), dateOfBirthHeader.getText());
        Assert.assertEquals(PropertyConfig.getValue("personal.overview.dateOfBirth." + getUserValue(user) + ".detail"), user.equals("multipleOrders") ? dateOfBirthPlaceholder.getText(): dateOfBirthDetail.getText());
    }

    public void staffCardNumberDetails() {
        Assert.assertTrue(staffCardNumber.isDisplayed());
    }

    public void emailAndPasswordDetails() {
        Assert.assertTrue(email.isDisplayed());
        Assert.assertTrue(password.isDisplayed());
    }

    public void staffCardNumberDetailsNotVisible() {
        Assert.assertFalse(isElementVisible(staffCardNumber));
    }

    public void checkPersonalDetailsCardHasALinkToUpdateMyPassword() {
        Assert.assertEquals(PropertyConfig.getValue("personal.updatePassword.link"), updatePasswordLink.getText());
    }

    public void clickUpdatePasswordLink() {
        updatePasswordLink.click();
    }

    public void checkSummaryDetailsOfMyDataPrivacyRights() {
        waitForPageLoad();
        Assert.assertEquals(PropertyConfig.getValue("personalDetails.dataPrivacyRights.title"), dataPrivacyRightTitle.getText());
        Assert.assertEquals(PropertyConfig.getValue("personalDetails.dataPrivacyRights.detail") + PropertyConfig.getValue("personalDetails.dataPrivacyRights.link"), dataPrivacyRightDetail.getText().trim());
    }

    public void clickTheLinkOfFindOutMore() {
        Assert.assertEquals(PropertyConfig.getValue("personalDetails.dataPrivacyRights.link"), dataPrivacyRightLink.getText());
        dataPrivacyRightLink.click();
    }

    public void checkLinkedToPrivacyHelpPage() {
        Sleeper.sleep(1000);
        Assert.assertEquals(PropertyConfig.getValue("personalDetails.dataPrivacyRights.site"), getDriver().getCurrentUrl());
    }

    public void clickUpdateEmailLink() {
        updateEmailLink.click();
    }

    public void updateEmailFormIsVisible() {
        Assert.assertTrue(isElementVisible(updateEmailForm));
    }

    public void clickUpdateEmailCancelButton() {
        updateEmailFormCancelButton.click();
    }

    public void updateEmailFormIsNotVisible() {
        Assert.assertFalse(isElementVisible(updateEmailForm));
    }

    public void emailAddressIs(final String expectedEmailAddress) {
        Assert.assertEquals(expectedEmailAddress, email.getText());
    }

    public void typeEmailAddress(final String emailAddress) {
        updateEmailFormEmailField.clear();
        updateEmailFormEmailField.sendKeys(emailAddress);
    }

    public void typeConfirmEmailAddress(final String emailAddress) {
        updateEmailFormConfirmEmailField.clear();
        updateEmailFormConfirmEmailField.sendKeys(emailAddress);
    }

    public void clickUpdateEmailButton() {
        updateEmailFormUpdateButton.click();
    }

    public void invalidEmailAddressErrorMessageIsVisible() {
        Assert.assertTrue(isElementVisible(invalidEmailAddressErrorMessage));
        Assert.assertEquals(PersonalDetailsProperties.getInvalidEmailMessage(), invalidEmailAddressErrorMessage.getText());
    }

    public void typePassword(final String password) {
        updateEmailFormPasswordField.clear();
        Assert.assertEquals(PropertyConfig.getValue("personalDetails.updateEmail.placeholder"), updateEmailFormPasswordField.getAttribute("placeholder"));
        updateEmailFormPasswordField.sendKeys(password);
    }

    public void invalidPasswordErrorMessageIsVisible() {
        waitFor(2000);
        Assert.assertTrue(isElementVisible(invalidPasswordErrorMessage));
        Assert.assertEquals(PersonalDetailsProperties.getInvalidPasswordMessage(), invalidPasswordErrorMessage.getText());
    }

    public void mismatchedEmailErrorMessageIsVisible() {
        Assert.assertTrue(isElementVisible(mismatchedEmailErrorMessage));
        Assert.assertEquals(PersonalDetailsProperties.getMismatchedEmailMessage(), mismatchedEmailErrorMessage.getText());
    }

    public void updateEmailLinkIsVisible() {
        Assert.assertTrue(isElementVisible(updateEmailLink));
        Assert.assertEquals(PersonalDetailsProperties.getUpdateEmailLinkText(), updateEmailLink.getText());
    }

    public void updateEmailPasswordFormIsMasked() {
        Assert.assertEquals("password", updateEmailFormPasswordField.getAttribute("type"));
    }

    public void updateEmailPasswordFormIsUnmasked() {
        Assert.assertEquals("text", updateEmailFormPasswordField.getAttribute("type"));
    }

    public void clickHidePasswordToggle() {
        hidePasswordToggle.click();
    }

    public void clickingUpdateEmailButtonUpdatesEmailAddress() {
        final String newEmail = updateEmailFormEmailField.getValue();
        updateEmailFormUpdateButton.click();
        // TODO: Re-enable when we run tests on integ environment - does not work with Wiremock
        //emailAddressIs(newEmail);
    }

    public void personalDetailsUpdatedMessageIsVisibleForSeconds(final int seconds) {
        Assert.assertTrue(isElementVisible(personalDetailsUpdatedMessage));
        Assert.assertEquals(PersonalDetailsProperties.getUpdateSuccessMessage(), personalDetailsUpdatedMessage.getText());
        Sleeper.sleep(seconds * 1000L);
        Assert.assertFalse(isElementVisible(personalDetailsUpdatedMessage));
    }

    public void checkPageNavigateToUpdateMyPasswordForm() {
        Assert.assertTrue(updatePasswordForm.isDisplayed());
        Assert.assertEquals(PropertyConfig.getValue("personal.updatePassword.title.updateMyPassword"), updatePasswordHeading.getText());
        Assert.assertEquals(PropertyConfig.getValue("personal.updatePassword.title.currentPassword"), currentpassWordTitle.getText());
        Assert.assertEquals(PropertyConfig.getValue("personal.updatePassword.title.newPassword"), newpassWordTitle.getText());
    }

    public void checkCurrentPasswordFieldAndNewPasswordFieldAreEmpty() {
        Assert.assertTrue(currentPasswordInput.getTextContent().isEmpty());
        Assert.assertTrue(newPasswordInput.getTextContent().isEmpty());
    }

    public void inputCurrentPassword(String inputString) {
        currentPasswordInput.sendKeybyKey(inputString);
    }

    public void inputNewPassword(String inputString) {
        newPasswordInput.sendKeybyKey(inputString);
    }

    public void checkCancelUpdate() {
        enterCorrectPwd();
        if (isMobile()) {
            newPasswordInput.sendKeys(Keys.TAB);
        }
        Assert.assertEquals(PropertyConfig.getValue("personal.updatePassword.button"), updatePasswordBtn.getText());
        Assert.assertEquals(PropertyConfig.getValue("personal.cancelPassword.button"), updatePasswordCancelBtn.getText());
        updatePasswordCancelBtn.click();
        Assert.assertTrue(updatePasswordLink.isDisplayed());
    }

    public void clickUpdatePasswordBtn() {
        updatePasswordBtn.click();
    }

    public void clearCurrentPasswordInput() {
        currentPasswordInput.clear();
    }

    public void clearNewPasswordInput() {
        newPasswordInput.clear();
    }

    public void enterCorrectPwd() {
        inputCurrentPassword(PropertyConfig.getValue("personal.updatePassword.currentPwd"));
        inputNewPassword(PropertyConfig.getValue("personal.updatePassword.newPwd"));
    }

    public void checkBothPwdFieldsAreMasked() {
        checkInputValueMarked(currentPasswordInput);
        checkInputValueMarked(newPasswordInput);
    }

    public void checkBothPwdFieldsAreNotMasked() {
        checkInputValueNotMarked(currentPasswordInput);
        checkInputValueNotMarked(newPasswordInput);
    }

    public void checkInputValueMarked(ExtWebElement element) {
        Assert.assertEquals("password", element.getAttribute("type"));
    }

    public void checkInputValueNotMarked(ExtWebElement element) {
        Assert.assertEquals("text", element.getAttribute("type"));
    }

    public void checkInputValue(ExtWebElement element, String expectedValue) {
        Assert.assertEquals(expectedValue, element.getValue());
    }

    public void checkUpdatedSuccessfulNotification() {
        Assert.assertEquals(PropertyConfig.getValue("personal.updatePassword.message.success"), notificationMessage.getText());
        if (isIphone()) {
            notificationMessage.sendKeys(Keys.PAGE_DOWN);
        }
        Assert.assertTrue(updatePasswordLink.isDisplayed());
    }

    public void checkBothPasswordFieldsAreSetToMaskThePassword() {
        enterCorrectPwd();
        checkBothPwdFieldsAreMasked();
    }

    public void checkUserCanToggleToUnmaskThePassword() {
        passwordIcons.get(0).click();
        passwordIcons.get(1).click();
        checkBothPwdFieldsAreNotMasked();
    }

    public void checkCanShowPasswordInEachFieldIndividually() {
        passwordIcons.get(1).click();
        checkInputValueMarked(newPasswordInput);
        passwordIcons.get(0).click();
        checkInputValueMarked(currentPasswordInput);
        passwordIcons.get(1).click();
        checkInputValueNotMarked(newPasswordInput);
    }

    public void checkTypeCharactersWillBeUnmasked() {
        newPasswordInput.sendKeybyKey("test");
        checkInputValue(newPasswordInput, (PropertyConfig.getValue("personal.updatePassword.newPwd") + "test"));
    }

    public void toggleToMaskTheField() {
        passwordIcons.get(1).click();
        checkInputValueMarked(newPasswordInput);
    }

    public void inputPasswordInTheCurrentPasswordField(boolean isCorrect) {
        currentPasswordInput.sendKeybyKey(PropertyConfig.getValue((isCorrect) ? "personal.updatePassword.currentPwd" : "personal.updatePassword.currentPwd.wrong"));
    }

    public void inputPasswordInTheNewPasswordField(boolean isCorrect) {
        newPasswordInput.sendKeybyKey(PropertyConfig.getValue((isCorrect) ? "personal.updatePassword.newPwd" : "personal.updatePassword.newPwd.wrong"));
    }

    public void checkGetErrorMessageForNewPasswordField() {
        Assert.assertEquals(PropertyConfig.getValue("personal.errorMessage.currentPwd"), errorMessages.get(0).getText());
        Assert.assertEquals(PropertyConfig.getValue("personal.errorMessage.newPwd"), errorMessages.get(1).getText());
        Assert.assertEquals(PropertyConfig.getValue("personal.validationMessage1.newPwd"), validationMessages.get(0).getText());
        Assert.assertEquals(PropertyConfig.getValue("personal.validationMessage2.newPwd"), validationMessages.get(1).getText());
    }

    public void checkGetErrorMessageForCurrentPasswordField() {
        Assert.assertEquals(PropertyConfig.getValue("personal.errorMessage.currentPwd"), errorMessages.get(0).getText());
        Assert.assertEquals(PropertyConfig.getValue("personal.validationMessage1.newPwd"), validationMessages.get(0).getText());
        Assert.assertEquals(PropertyConfig.getValue("personal.validationMessage2.newPwd"), validationMessages.get(1).getText());
    }

    public void getErrorMessageInPersonalDetailPage() {
        Assert.assertEquals(PropertyConfig.getValue("personal.updatePassword.message.failed"), notificationMessage.getText());
    }

    public void enterPwd() {
        inputPasswordInTheCurrentPasswordField(false);
        inputPasswordInTheNewPasswordField(true);
    }

    public void clickUpdateDetailsLink() {
        updateDetailsBtn.click();
    }

    public void checkPageNavigateToUpdateMyDetailForm() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(updateMyDetailTitle.getText(), PropertyConfig.getValue("personal.updateDetail.title.updateMyDetails"));
        softAssert.assertEquals(titleTitle.getText(), PropertyConfig.getValue("personal.updateDetail.title.title"));
        softAssert.assertEquals(firstNameTitle.getText(), PropertyConfig.getValue("personal.updateDetail.title.firstName"));
        softAssert.assertEquals(firstNameInput.getValue(), PropertyConfig.getValue("personal.updateDetail.input.firstName"));
        softAssert.assertEquals(lastNameTitle.getText(), PropertyConfig.getValue("personal.updateDetail.title.lastName"));
        softAssert.assertEquals(lastNameInput.getValue(), PropertyConfig.getValue("personal.updateDetail.input.lastName"));
        scrollToBottom();
        softAssert.assertEquals(genderTitle.getText(), PropertyConfig.getValue("personal.updateDetail.title.gender"));
        softAssert.assertTrue(femaleSelector.isPresent());
        softAssert.assertTrue(maleSelector.isPresent());
        softAssert.assertEquals(femaleTitle.getText(), PropertyConfig.getValue("personal.updateDetail.title.female"));
        softAssert.assertEquals(maleTitle.getText(), PropertyConfig.getValue("personal.updateDetail.title.male"));
        softAssert.assertEquals(dateOfBirthTitle.getText(), PropertyConfig.getValue("personal.updateDetail.title.dateOfBirth"));
        softAssert.assertTrue(yearDropdown.isDisplayed());
        softAssert.assertTrue(monthDropdown.isDisplayed());
        softAssert.assertTrue(dayDropdown.isDisplayed());
        softAssert.assertEquals(mobileNumberTitle.getText(), PropertyConfig.getValue("personal.updateDetail.title.mobileNumber"));
        softAssert.assertEquals(mobileNumberInput.getValue(), PropertyConfig.getValue("personal.updateDetail.input.mobileNumber"));
        softAssert.assertEquals(mobileNumberLabel.getText(), PropertyConfig.getValue("personal.updateDetail.input.mobileLabel"));
        softAssert.assertEquals(updatePersonalDetailsBtn.getText(), PropertyConfig.getValue("personal.updateDetail.button.update"));
        softAssert.assertEquals(cancelBtn.getText(), PropertyConfig.getValue("personal.updateDetail.button.cancel"));
        softAssert.assertAll();
    }

    public void updateAllFields() {
        scrollToTop();
        titleValue.click();
        mrsOptions.click();
        firstNameInput.sendKeybyKey(PropertyConfig.getValue("personal.updateDetail.input.firstName"));
        lastNameInput.sendKeybyKey(PropertyConfig.getValue("personal.updateDetail.input.lastName"));
        femaleSelector.click();
        lastNameInput.sendKeys(Keys.ARROW_UP);
        if (LocaleUtils.getSite().equals("fr") || isSamsung()) {
            lastNameInput.sendKeys(Keys.ARROW_UP);
        }
        dayDropdown.click();
        dayOption4.click();
        monthDropdown.click();
        monthOption2.click();
        yearDropdown.click();
        yearOption2016.click();
    }

    public void clickSubmitBtn() {
        updatePersonalDetailsBtn.click();
    }

    public void clickCancelBtn() {
        cancelBtn.click();
    }

    public void checkPageNavigateToMyPersonalDetailPageWithNoNotificationDisplay() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains(PropertyConfig.getValue("url", "my-personal-details")));
    }

    public void fieldsLimitation() {
        firstNameInput.sendKeybyKey(PropertyConfig.getValue("personal.updateDetail.60characters"));
        lastNameInput.sendKeybyKey(PropertyConfig.getValue("personal.updateDetail.60characters"));
        clickSubmitBtn();
        Assert.assertEquals(PropertyConfig.getValue("personal.updateDetail.firstName.error"), firstNameError.getText());
        Assert.assertEquals(PropertyConfig.getValue("personal.updateDetail.lastName.error"), lastNameError.getText());
    }
}
