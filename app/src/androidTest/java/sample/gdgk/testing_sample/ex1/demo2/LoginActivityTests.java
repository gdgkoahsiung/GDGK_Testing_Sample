package sample.gdgk.testing_sample.ex1.demo2;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import sample.gdgk.testing_sample.R;
import sample.gdgk.testing_sample.ex1.mvpvm.LoginActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTests {

    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void testLoginSuccess() {

        onView(withHint(R.string.email)).perform(typeText("sample@abc.com"));
        onView(withHint(R.string.password)).perform(typeText("123456"));
//        onView(withText(R.string.login)).perform(click());

        onView(withId(R.id.loginButton))
                .check(matches(withText("loginnnn")));
    }
}