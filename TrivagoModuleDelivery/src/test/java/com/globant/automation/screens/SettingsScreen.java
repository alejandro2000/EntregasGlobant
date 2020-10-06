package com.globant.automation.screens;

import com.globant.automation.utils.constants.ScreensConstants;
import com.globant.automation.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.pmw.tinylog.Logger;

import static java.lang.String.format;

public class SettingsScreen extends BaseScreen {
    /**
     * Constructor method for standard screen object.
     * @param pDriver : AndroidDriver
     */
    public SettingsScreen(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    /**
     * scroll into data privacy and
     * click it
     */
    public void goIntoPrivacySettingsSection() {
        scrollToTextInSettingsSection(ScreensConstants.DATA_PRIVACY);
        clickDynamicElement(ScreensConstants.DATA_PRIVACY);
    }

    public void clickSettingsSection() {
        clickDynamicElement(ScreensConstants.DATA_PRIVACY);
    }

    /**
     * scroll into settings section
     */
    public void scrollToTextInSettingsSection(String text) {
        String automator = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\"))" +
                ".scrollIntoView(new UiSelector().textContains(\"%s\"))";
        AndroidElement textOnElement = driver.findElementByAndroidUIAutomator(format(automator, text));
        Logger.info(textOnElement.getText());
    }

    public WorkingWithDataPrivacy workingWithDataPrivacy() {
        return new WorkingWithDataPrivacy(driver);
    }
}
