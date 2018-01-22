package com.test.talekar.rushikesh.proficiencytest;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.test.talekar.rushikesh.proficiencytest.activities.HomeActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

/**
 * Created by Rushikesh_Talekar on 21-01-2018.
 */

@RunWith(AndroidJUnit4.class)
public class UIUnitTestCases {
  public static final long TIMEOUT = 10000;
  private HomeActivity homeActivity;
  @Rule
  public ActivityTestRule<HomeActivity> activityActivityTestRule =
      new ActivityTestRule<>(HomeActivity.class);

  @Before
  public void setUp() {
    activityActivityTestRule.getActivity()
        .getSupportFragmentManager().beginTransaction();
    homeActivity = activityActivityTestRule.getActivity();
    assertNotNull("HomeActivity is null", homeActivity);
  }

  @Test
  public void testDataLoadedSuccess() {
    RecyclerView recyclerView = (RecyclerView) homeActivity.findViewById(R.id.fragment_home_rv);
    assertNotNull("RecyclerView is null", recyclerView);
    assertThat(recyclerView.getAdapter(), instanceOf(RecyclerView.Adapter.class));
    try {
      Thread.sleep(TIMEOUT);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    assertThat(recyclerView.getAdapter().getItemCount(), greaterThan(0));
  }

  @Test
  public void testDataLoadedFailed() {
    try {
      Thread.sleep(TIMEOUT);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    TextView mEmptyStateText = (TextView) homeActivity
        .findViewById(R.id.tv_empty_state);
    assertNotNull("EmptyStateTextView is null", mEmptyStateText);
    assertThat(mEmptyStateText.getVisibility(), lessThanOrEqualTo(View.VISIBLE));
  }
}
