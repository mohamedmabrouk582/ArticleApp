package com.example.articlesapp.ui.activities


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.articlesapp.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ArticleListActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(ArticleListActivity::class.java)

    @Test
    fun articleListActivityTest() {
        val recyclerView = onView(
                allOf(withId(R.id.articles_rcv),
                        childAtPosition(
                                withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                                0)))
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(0, click()))

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(700)

        val appCompatImageView = onView(
                allOf(withId(R.id.link_img),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(`is`("androidx.core.widget.NestedScrollView")),
                                        0),
                                14),
                        isDisplayed()))
        appCompatImageView.perform(click())

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(700)

        val appCompatImageView2 = onView(
                allOf(withId(R.id.back_img),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(`is`("androidx.core.widget.NestedScrollView")),
                                        0),
                                15),
                        isDisplayed()))
        appCompatImageView2.perform(click())
    }

    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
