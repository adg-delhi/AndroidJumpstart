package com.adgdelhi.android

import androidx.test.filters.SmallTest
import androidx.test.rule.ActivityTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.adgdelhi.jumpstart.BaseDrawerActivity

@RunWith(AndroidJUnit4::class)
@SmallTest
class BaseActivityTest {

    @Rule
    var testRule = ActivityTestRule(BaseDrawerActivity::class.java, true, false)

    @Before
    fun setup() {
        (DebugBaseApplication.getInstance() as DebugBaseApplication).enableMockMode()
        testRule.launchActivity(null)
    }

    @After
    fun tearDown() {
        testRule.activity.finish()
    }

    @Test
    fun sampleTest() {
        onView(withText("Hello World!"))
                .check(matches(isDisplayed()))
    }
}
