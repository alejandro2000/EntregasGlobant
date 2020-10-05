package com.globant.automation.screens;

import com.globant.automation.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Object of SecondScreen.
 * 
 **/
public class PrivacyScreen extends BaseScreen {

	public LandingView returnLandingView() {
		return new LandingView(driver);
	}

	public NavigationItemsComponent returnNavigationItemsComponent() {
		return new NavigationItemsComponent(driver);
	}

	/**
	 * Constructor method.
	 *
	 * @param pDriver : AndroidDriver
	 */

	public PrivacyScreen(AndroidDriver<AndroidElement> pDriver) {
		super(pDriver);
	}

	@AndroidFindBy(id = "activityCookieConsentContentTitleTextView")
	protected AndroidElement privacyTitle;

	@AndroidFindBy(id = "activityCookieConsentContentBody1TextView")
	private AndroidElement firstParagraph;

	@AndroidFindBy(id = "activityCookieConsentContentBody2TextView")
	private AndroidElement sencondParagraph;

	@AndroidFindBy(id = "activityCookieConsentContentBody3TextView")
	private AndroidElement thirdParagraph;

	@AndroidFindBy(id = "activityCookieConsentContentAcceptButton")
	private AndroidElement acceptPrivacyTermsButton;
	
	public String getPrivacySectionTitle() {
		return privacyTitle.getText();
	}

	public String getPrivacyFirtSection() {
		return firstParagraph.getText();
	}

	public String getPrivacySecondSection() {
		return sencondParagraph.getText();
	}

	public String getPrivacyThirdSection() {
		return thirdParagraph.getText();
	}

	public void acceptPrivacyTermsButton() {
		waitForAnElement(driver,acceptPrivacyTermsButton,30);
		acceptPrivacyTermsButton.click();
	}

}
