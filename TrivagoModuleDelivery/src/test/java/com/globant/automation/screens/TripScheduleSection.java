package com.globant.automation.screens;

import com.globant.automation.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.pmw.tinylog.Logger;

import static java.lang.String.format;

public class TripScheduleSection extends BaseScreen {
    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver : AndroidDriver
     */
    public TripScheduleSection(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    @AndroidFindBy(id = "activityDatesSelectionCalendarApplyTextView")
    private AndroidElement dateConfirmationButton;

    public void tripPrograming(){
        scrollToTextInDatePicker("diciembre");
        clickDynamicElement("1");
        clickDynamicElement("5");
        dateConfirmationButton.click();
    }

    /**
     * Scroll to the text attribute received by parameter in a date picker.
     *
     * @param text : String
     */
    public void scrollToTextInDatePicker(String text) {
        String automator = "new UiScrollable(new UiSelector().resourceId(\"com.trivago:id/activityDatesSelectionCalendarPickerView\"))" +
                ".scrollIntoView(new UiSelector()" +
                ".textContains(\"%s\"))";
        AndroidElement textOnElement = driver.findElementByAndroidUIAutomator(format(automator, text));
        Logger.info(textOnElement.getText());
    }

}
