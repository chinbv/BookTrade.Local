package com.cmsc355.curry_crackers_cats.booktrade;


import android.support.test.espresso.ViewInteraction;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginTest {

    @Rule
    public ActivityRule<Login> mActivityTestRule = new ActivityRule<>(Login.class);

    @Test
    public void loginTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.etUsername), isDisplayed()));
        appCompatEditText.perform(replaceText("vishy"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.etPassword), isDisplayed()));
        appCompatEditText2.perform(replaceText("12345"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.bLogin), withText("Login"), isDisplayed()));
        appCompatButton.perform(click());

    }

}
