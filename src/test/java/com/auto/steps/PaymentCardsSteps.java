package com.auto.steps;

import com.auto.config.PropertyConfig;
import com.auto.pages.PaymentCardsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import org.springframework.beans.factory.annotation.Autowired;

public class PaymentCardsSteps {

	@Autowired
	PaymentCardsPage payment;
	
    @Then("user able to see message of no card saved")
   	public void checkMessageOfNoPaymentCards() {
    	payment.checkMessageOfNoPaymentCards();
   	}
    
    @Then("user able to see security message and Payment title")
   	public void checkPageTitleAndSecurityMessage() {
    	payment.checkPageTitleAndSecurityMessage();
   	}
    
    @Then("user able to see all saved card in descending order with detailed info and expiry status")
   	public void checktheorderofSavedCards() {
    	payment.checktheorderofSavedCards();
   	}
    
    @Then("user able to see one default card tag in saved cards")
   	public void checkDefaultCardTextOnVarietyOfSavedCards()  {
    	payment.checkDefaultCardText(PropertyConfig.getValue("payment.prefixCardStatus"), PropertyConfig.getValue("payment.prefixCardStatusNext"));
   	}

    @Then("user able to see default card tag in one single saved card")
   	public void checkDefaultCardTextOnSingleSavedCard()  {
    	payment.checkDefaultCardText(PropertyConfig.getValue("payment.prefixSingleCardStatus"), PropertyConfig.getValue("payment.prefixSingleCardStatusNext"));
   	}

    @Then("I can see a CTA to set other card as default")
   	public void checkSetDefaultCardTextOnSavedCards()  {
    	payment.checkSetDefaultCardTextOnSavedCards(PropertyConfig.getValue("payment.prefixCardStatus"), PropertyConfig.getValue("payment.prefixCardStatusNext"));
   	}

    @Then("I can see a failure message for saving the default card")
   	public void checkFailureCardSaveMessage()  {
    	payment.checkFailureCardSaveMessage();
   	}

    @Then("I click on card to make this as default card")
   	public void clickOnCardToMakeThisDefaultCard()  {
    	payment.clickOnCardToMakeThisDefaultCard(PropertyConfig.getValue("payment.prefixCardStatus"));
   	}

    @Then("I see default tag updated on selected card")
   	public void checkCardIsNowDefaultCard()  {
    	payment.checkCardIsNowDefaultCard(PropertyConfig.getValue("payment.prefixCardStatus"));
   	}

	@Then("^user able to see one default card tag in saved cards for user (.*)$")
	public void checkDefaultCardText(final String user)  {
		payment.checkDefaultCardText();
	}

    @Then("^user able to see total (.*) delete CTAs for each Payment Card$")
    public void userAbleToSeeCTAToDeleteThePaymentCardOnEachTile(int totalCards) {
    	payment.checkDeletePaymentCardsCTA(totalCards);
    }

	@And("^user click CTA to delete default card for user (.*)$")
	public void userClickCTAToDeleteDefaultCard(String user) {
		payment.clickCTAToDeleteDefaultCard(user);
	}

	@Then("verify delete card pop up for default card")
	public void verifyDeleteCardPopUp() {
		payment.verifyDeleteCardPopUp(false);
	}

	@Then("user click Delete CTA in Delete confirm pop to delete card")
	public void userClickDeleteCTAInDeleteConfirmPopToDeleteCard() {
		payment.clickDeleteCTAInPopup();
	}

	@Then("^verify on page remaining (.*) cards$")
	public void verifyPageRemainingCards(int remainingCards) {
		payment.verifyPageRemainingCards(remainingCards, false);
	}

	@Then("^verify on page remaining (.*) cards and update failed$")
	public void verifyPageRemainingCardsUpdateFailed(int remainingCards) {
		payment.verifyPageRemainingCards(remainingCards, true);
	}

	@And("user click CTA to delete expired card")
	public void userClickCTAToDeleteExpiredCard() {
		payment.clickCTAToDeleteExpiredCard();
	}

	@Then("verify delete card pop up for expired card")
	public void verifyDeleteCardPopUpForExpiredCard() {
		payment.verifyDeleteCardPopUp(true);
	}

	@Then("user click Cancel CTA in Delete confirm pop up")
	public void userClickCancelCTAInDeleteConfirmPopUp() {
		payment.clickCancelCTA();
	}

	@Then("user click out side of Delete confirm pop up")
	public void userClickOutSideOfDeleteConfirmPopUp() {
		payment.clickOutSideDeleteConfirm();
	}

    @Then("I see failure message disappears after 5 sec")
   	public void checkFailureCardSaveMessageDisappears()  {
    	payment.checkFailureCardSaveMessageDisappears();
   	}

}