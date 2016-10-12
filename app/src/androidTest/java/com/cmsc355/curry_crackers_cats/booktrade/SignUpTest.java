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
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SignUpTest {

    @Rule
    public ActivityRule<Login> mActivityTestRule = new ActivityRule<>(Login.class);

    @Test
    public void signUpTest() {
        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.tvRegisterLink), withText("Don't have an account? Sign Up"), isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.etUsername), isDisplayed()));
        appCompatEditText.perform(replaceText("sehgalv"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.etEmail), isDisplayed()));
        appCompatEditText2.perform(replaceText("sehgalv@vcu.edu"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.etCEmail), isDisplayed()));
        appCompatEditText3.perform(replaceText("sehgalv@vcu.edu"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.etPassword), isDisplayed()));
        appCompatEditText4.perform(replaceText("Cmsc355"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.etREPassword), isDisplayed()));
        appCompatEditText5.perform(replaceText("Cmsc355"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.bSignUp), withText("Sign Up"), isDisplayed()));
        appCompatButton.perform(click());

    }

}
