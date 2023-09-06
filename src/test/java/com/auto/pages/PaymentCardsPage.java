package com.auto.pages;

import com.auto.base.BasePage;
import com.auto.config.PropertyConfig;
import com.automation.core.base.ExtWebElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.stream.IntStream;


public class PaymentCardsPage extends BasePage {

	// String created to build the webelements
	String prefixCardNumber = "[data-testid='paymentCard_1234567820";
	String prefixCardNumberNext = "[data-testid='paymentCard_123456782";
	String prefixCardExpiry = "[data-testid='paymentCardExpiry_1234567820";
	String prefixCardExpiryNext = "[data-testid='paymentCardExpiry_123456782";
	String prefixCardAddress = "[data-testid='paymentCardAddress_1234567820";
	String prefixCardAddressNext = "[data-testid='paymentCardAddress_123456782";
	String prefixCardNumberLastFourDigits = "[data-testid='paymentCardNo_1234567820";
	String prefixCardNumberLastFourDigitsNext = "[data-testid='paymentCardNo_123456782";
	String prefixCardStatus = "[data-testid='paymentCardStatus_1234567820";
	String prefixCardStatusNext = "[data-testid='paymentCardStatus_1234567820";
	String prefixCardDeleteLink = "[data-testid='paymentCardDeleteLink_12345678";

	@FindBy(css = "[data-testid='noDataContainer']")
	private ExtWebElement noPaymentCard;

	@FindBy(css = "[data-testid='securePaymentInfoMessage']")
	private ExtWebElement securePaymentInfoMessage;

	@FindBy(css = "[data-testid='pageTitle']")
	private ExtWebElement pageTitlePaymentCard;

	@FindBy(css = "[data-testid='paymentCardListContainer'] > div")
	private List<ExtWebElement> savedPaymentCards;

	@FindBy(css = "[data-testid='expiredText']")
	private ExtWebElement expiredCard;

	@FindBy(css = "[data-testid='defaultCardText']")
	private ExtWebElement defaultCardText;

	@FindBy(css = "[data-testid='paymentCardDeleteLink_12345678201']")
	private ExtWebElement firstDeleteButton;

	@FindBy(css = "[data-testid^='paymentCardDeleteLink_']")
	private List<ExtWebElement> deleteButtons;

	@FindBy(css = "[data-testid^='paymentCardStatus_'] span")
	private List<ExtWebElement> paymentCardStatus;

	@FindBy(css = "[data-testid='confirmBoxCloseButton_test']")
	private ExtWebElement confirmBoxCloseButton;

	@FindBy(css = "[data-testid='confirmBox_test'] h3")
	private ExtWebElement confirmBoxDeleteCardTitle;

	@FindBy(css = "[data-testid='confirmBox_test'] p")
	private ExtWebElement confirmBoxDeleteCardSubTitle;

	@FindBy(css = "[data-testid^='paymentCardIcon_']")
	private List<ExtWebElement> paymentCardIcons;

	@FindBy(css = "[data-testid='paymentCardStatus_12345678201'] span")
	private ExtWebElement paymentCardStatus_Popup;

	@FindBy(css = "[data-testid='confirmBoxConfirmButton_test'] span")
	private ExtWebElement deleteButton;

	@FindBy(css = "[data-testid='confirmBoxCancelButton_test'] span")
	private ExtWebElement cancelButton;

	@FindBy(css = "[data-testid='updateMessageContainer'] span")
	private ExtWebElement updateMessage;

	@FindBy(css = "[data-testid='noDataIcon']")
	private ExtWebElement noPaymentCardsIcon;

	@FindBy(css = "[data-testid='noDataTitle']")
	private ExtWebElement noSavedCardText;

	@FindBy(css = "[data-testid='noDataDescription']")
	private ExtWebElement noSavedCardDescription;

	@FindBy(css = "[data-testid='updateMessageContainer']")
	private ExtWebElement failureCardSaveMessage;

	private By headerPromoHeading=By.cssSelector("[data-testid='headerPromoHeading']");

	private List<ExtWebElement> notExpiredCards;

	WebElement card;
	WebElement paymentCardBillingNameAndAddress;
	WebElement paymentCardNumberLastFourDigits;
	WebElement cardExpiryDate;
	public void checkMessageOfNoPaymentCards() {
        Assert.assertEquals("Payment card title is displaying", PropertyConfig.getValue("payment.pageTitlePaymentCard"), pageTitlePaymentCard.getText());
        Assert.assertEquals("No card message is displaying", PropertyConfig.getValue("payment.noCardMessage"), noPaymentCard.getText().replaceAll("\n", ""));
        Assert.assertEquals("Security message is displaying", PropertyConfig.getValue("payment.securityMessage"), securePaymentInfoMessage.getText());
    }

    public void checkPageTitleAndSecurityMessage() {
        Assert.assertEquals("Payment card title is displaying", PropertyConfig.getValue("payment.pageTitlePaymentCard"), pageTitlePaymentCard.getText());
        Assert.assertEquals("Security message is displaying", PropertyConfig.getValue("payment.securityMessage"), securePaymentInfoMessage.getText());
    }

    public void checkCardExpiry(WebElement cardExpiryDate) {
        // get card expire date from my payment card page
        String[] cardExpiryNote = cardExpiryDate.getText().split(" ");
        String[] getDateMonthAndYear = cardExpiryNote[1].split("/");
        String getMonth = getDateMonthAndYear[0];
        String getYear = getDateMonthAndYear[1];

        // get current system date MM/yy format
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        String[] currentDateMonthAndYear = formattedDate.split("/");
        String currentMonthAndYear = currentDateMonthAndYear[1] + "/" + currentDateMonthAndYear[2];
        String[] systemMonthAndYear = currentMonthAndYear.split("/");
        String currentMonth = systemMonthAndYear[0];
        String currentYear = systemMonthAndYear[1];

        // compare the card expire date with current system date to check if card expired then Expired text should visible
        if (Integer.parseInt(currentYear) > Integer.parseInt(getYear)) {
            Assert.assertEquals("Expired text is displaying", PropertyConfig.getValue("payment.expiredCardText"), expiredCard.getText());
            checkExpiredCardInfoColourIs();
        } else if (Integer.parseInt(currentYear) == Integer.parseInt(getYear)) {
            Assert.assertEquals(Integer.parseInt(currentYear), Integer.parseInt(getYear));
            if (Integer.parseInt(currentMonth) > Integer.parseInt(getMonth)) {
                checkExpiredCardInfoColourIs();
            }
        }
    }

    public void checkBillingNameAndAddressOnCard(WebElement paymentCardBillingNameAndAddress) {
        Assert.assertEquals("on payment card billing name & address is displaying", PropertyConfig.getValue("payment.paymentCard.billingname.address"), paymentCardBillingNameAndAddress.getText().replaceAll("\n", " "));
    }

    public void checkExpiredCardInfoColourIs() {
        final String color = expiredCard.getCssValue("color");
        Assert.assertTrue("Color of Expired text",
                color.contains(PropertyConfig.getValue("payment.expired.text.red")));
    }

    public void checkLastFourDigitOfCardNumber(WebElement paymentCardNumberLastFourDigits) {
        String[] cardNumber = paymentCardNumberLastFourDigits.getText().split(" ");
        char[] endDigits = cardNumber[3].toCharArray();
        Assert.assertEquals(Integer.parseInt((PropertyConfig.getValue("payment.cardNumber.digit"))), endDigits.length);
    }

	public void checkFailureCardSaveMessage() {
		Assert.assertEquals(PropertyConfig.getValue("payment.failureCardSaveMessage"), failureCardSaveMessage.getText());
	}

    public void checkDefaultCardText() {
		Assert.assertTrue(defaultCardText.isVisible());
		Assert.assertEquals(PropertyConfig.getValue("payment.defaultCardText"), defaultCardText.getText());
    }

	public void checkDefaultCardText(String prefixCardStatus, String prefixCardStatusNext) {
		int defaultCardCount = 0;
		WebElement defaultCard;
		for (int i = 1; i <= savedPaymentCards.size(); i++) {
			if(i < 10) {
				defaultCard = find(By.cssSelector(prefixCardStatus + i + "'" +"]" + ">span"));
			} else {
				defaultCard = find(By.cssSelector(prefixCardStatusNext + i + "'" +"]" + ">span"));
			}
			if(defaultCard.getText().contentEquals(PropertyConfig.getValue("payment.defaultCardText"))) {
				defaultCardCount ++;
				break;
			}
		}
		Assert.assertEquals(Integer.parseInt((PropertyConfig.getValue("payment.defaultcard.count"))), defaultCardCount);
	}

	public void checkSetDefaultCardTextOnSavedCards(String prefixCardStatus, String prefixCardStatusNext) {
		int setDefaultCardTagCount = 0;
		WebElement setDefaultCardTag;
		for (int i = 1; i <= savedPaymentCards.size(); i++) {
			if(i < 10) {
				setDefaultCardTag = find(By.cssSelector(prefixCardStatus + i + "'" +"]" + ">span"));
			} else {
				setDefaultCardTag = find(By.cssSelector(prefixCardStatusNext + i + "'" +"]" + ">span"));
			}
			if(setDefaultCardTag.getText().contentEquals(PropertyConfig.getValue("payment.setDefaultCardText"))) {
				setDefaultCardTagCount ++;
			}
		}
		if (!(setDefaultCardTagCount >= Integer.parseInt(PropertyConfig.getValue("payment.setDefaultcardTag.count")))) {
			throw new ArithmeticException();
		}
	}

	public void clickOnCardToMakeThisDefaultCard(String prefixCardStatus) {
		int cardNumberToMakeDefaultCard=2;
		WebElement setDefaultCardTag = find(By.cssSelector(prefixCardStatus + cardNumberToMakeDefaultCard + "'" +"]" + ">span"));
		setDefaultCardTag.click();
		waitFor(500);
	}

	public void checktheorderofSavedCards() {
		for (int i = 1; i <= savedPaymentCards.size(); i++) {
			WebElement card;
			WebElement paymentCardBillingNameAndAddress;
			WebElement paymentCardNumberLastFourDigits ;
			WebElement cardExpiryDate ;
			// if saved card count less than 10
			if(i < 10) {
				card = find(By.cssSelector(prefixCardNumber + i + "'" +"]"));
				paymentCardBillingNameAndAddress = find(By.cssSelector(prefixCardAddress + i + "'" +"]"));
				paymentCardNumberLastFourDigits = find(By.cssSelector(prefixCardNumberLastFourDigits + i + "'" +"]"));
				cardExpiryDate = find(By.cssSelector(prefixCardExpiry + i + "'" +"]"));

			}
			// if saved card count more than 10
			else {
				card = find(By.cssSelector(prefixCardNumberNext + i + "'" +"]"));
				paymentCardBillingNameAndAddress = find(By.cssSelector(prefixCardAddressNext + i + "'" +"]"));
				paymentCardNumberLastFourDigits = find(By.cssSelector(prefixCardNumberLastFourDigitsNext + i + "'" +"]"));
				cardExpiryDate = find(By.cssSelector(prefixCardExpiryNext + i + "'" +"]"));
			}
			card.isDisplayed();
			checkBillingNameAndAddressOnCard(paymentCardBillingNameAndAddress);
			checkLastFourDigitOfCardNumber(paymentCardNumberLastFourDigits);
			checkCardExpiry(cardExpiryDate);
		}
	}

	public void checkCardIsNowDefaultCard(String prefixCardStatus) {
		waitForPageLoad();
		int cardNumberToMakeDefaultCard=2;
		WebElement setDefaultCardTag = find(By.cssSelector(prefixCardStatus + cardNumberToMakeDefaultCard + "'" +"]" + ">span"));
		Assert.assertEquals(PropertyConfig.getValue("payment.defaultCardText"), setDefaultCardTag.getText());
	}

	public int getDefaultCardPostfix(String user) {
        int order = 201;
        if (user.equals("longName"))
        {
            order=(savedPaymentCards.size()==9)?202:201;
        }
        else
        {
            order = 101;
        }
        return order;
    }

    public void getCardNumberAndAddress(int i) {
        paymentCardBillingNameAndAddress = find(By.cssSelector(prefixCardAddress + i + "'" + "]"));
        paymentCardNumberLastFourDigits = find(By.cssSelector(prefixCardNumberLastFourDigits + i + "'" + "]"));
        cardExpiryDate = find(By.cssSelector(prefixCardExpiry + i + "'" + "]"));
    }

    public void checkCardNumberAndAddress(int i) {
        getCardNumberAndAddress(i);
        Assert.assertTrue("payment card icon missing", paymentCardIcons.size()==11);
        checkBillingNameAndAddressOnCard(paymentCardBillingNameAndAddress);
        checkLastFourDigitOfCardNumber(paymentCardNumberLastFourDigits);
        checkCardExpiry(cardExpiryDate);
    }

    public void checkDeletePaymentCardsCTA(int totalCards) {
        Assert.assertEquals("Total cards are not "+totalCards,deleteButtons.size(), totalCards);
        IntStream.range(0, deleteButtons.size()).forEach(i -> Assert.assertTrue("Missing delete CTAs of payment card", deleteButtons.get(i).isDisplayed()));
    }

    public void clickCTAToDeleteDefaultCard(String user) {
        find(By.cssSelector(prefixCardDeleteLink + getDefaultCardPostfix(user) + "'" + "]")).click();
    }

    public void verifyDeleteCardPopUp(Boolean expired) {
		SoftAssert softly = new SoftAssert();
        softly.assertEquals(confirmBoxDeleteCardTitle.getTextContent(), PropertyConfig.getValue("payment.delete.title"), "payment.delete.title missing");
        softly.assertEquals(confirmBoxDeleteCardSubTitle.getText(), PropertyConfig.getValue("payment.delete.subtitle"), "payment.delete.subtitle missing");
        softly.assertTrue(confirmBoxCloseButton.isVisible(), "Form close button missing");

        softly.assertEquals(deleteButton.getText(), PropertyConfig.getValue("payment.delete.deleteButton"), "payment.delete.deleteButton missing");
        softly.assertEquals(cancelButton.getText(), PropertyConfig.getValue("payment.delete.cancelButton"), "payment.delete.cancelButton missing");
        softly.assertAll();
        if (expired.equals(true))
        {
            Assert.assertEquals("Missing expired text", expiredCard.getText(), PropertyConfig.getValue("payment.expiredCardText"));
            checkCardNumberAndAddress(9);
        }
        else
        {
            checkCardNumberAndAddress(1);}
    }

    public void clickDeleteCTAInPopup() {
        deleteButton.click();
    }

    public void verifyPageRemainingCards(int remainingCards, Boolean failed) {
        if(remainingCards==10)
        {
            Assert.assertEquals("Total cards are not " + remainingCards, remainingCards, deleteButtons.size());
        }
        else if(remainingCards<10 & remainingCards>0)
        {
        	Assert.assertEquals("payment.delete.message missing", PropertyConfig.getValue(failed.equals(true)?"payment.delete.message.failed":"payment.delete.message"), updateMessage.getText());
        }
        else
        {
            Assert.assertTrue("Missing noPaymentCardsIcon", noPaymentCardsIcon.isVisible() );
            Assert.assertEquals("payment.delete.noSavedCardText missing", PropertyConfig.getValue("payment.delete.noSavedCardText"), noSavedCardText.getText());
            Assert.assertEquals("payment.delete.noSavedCardDescription missing", PropertyConfig.getValue("payment.delete.noSavedCardDescription"), noSavedCardDescription.getText());
        }
    }

    public void clickCTAToDeleteExpiredCard() {
        find(By.cssSelector(prefixCardDeleteLink + 209 + "'" + "]")).click();
    }

    public void clickCancelCTA() {
        cancelButton.click();
    }

    public void clickOutSideDeleteConfirm() {
        clickWithinElementWithXYCoordinates(50,50);
    }

	public void checkFailureCardSaveMessageDisappears() {
		//waiting for 5 sec to check failure message disappear
		waitFor(5000);
		Assert.assertFalse(isElementVisible(failureCardSaveMessage));
	}
}