package com.globant.automation.screens;

import com.globant.automation.utils.constants.ScreensConstants;
import com.globant.automation.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.pmw.tinylog.Logger;

import static java.lang.String.format;

public class TripScheduleSection extends BaseScreen {
    @AndroidFindBy(id = "activityDatesSelectionCalendarApplyTextView")
    private AndroidElement dateConfirmationButton;

    /**
     * Constructor method for standard screen object.
     */
    public TripScheduleSection(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    /**
     * select the given range of date
     */
    public void tripPrograming() {
        scrollToTextInDatePicker(ScreensConstants.MONTH);
        clickDynamicElement(ScreensConstants.INITIAL);
        clickDynamicElement(ScreensConstants.FINAL);
        dateConfirmationButton.click();
    }

    /**
     * Scroll into the the proper month.
     */
    public void scrollToTextInDatePicker(String text) {
        String automator = "new UiScrollable(new UiSelector().resourceId(\"com" +
                ".trivago:id/activityDatesSelectionCalendarPickerView\"))" +
                ".scrollIntoView(new UiSelector()" +
                ".textContains(\"%s\"))";
        AndroidElement textOnElement = driver.findElementByAndroidUIAutomator(format(automator, text));
        Logger.info(textOnElement.getText());
    }

}
