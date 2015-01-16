package com.lynxsolutions.myjenkinsapplication;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

import com.robotium.solo.Solo;

/**
 * Created by csucsistvan on 16/01/15.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        solo=new Solo(getInstrumentation(),getActivity());
    }

    public void testCurrentActivity() {
        solo.assertCurrentActivity("Wrong activity...", MainActivity.class);
    }

    public void testIfTextAppears() {

//        Button btn_pushTheButton = (Button) solo.getButton(R.id.btn_pushTheButton);
        solo.clickOnButton("Push The Button");

//        TextView tv_afterButtonPushed = (TextView) solo.getView(R.id.tv_afterButtonPushed);
        assertTrue("the text doesn't appear!", solo.waitForText("The button was pressed"));
    }


    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}