package com.test.talekar.rushikesh.proficiencytest;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.test.talekar.rushikesh.proficiencytest.activities.HomeActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Rushikesh_Talekar on 21-01-2018.
 */

@RunWith(AndroidJUnit4.class)
public class UIUnitTestCases {
  @Rule
  public ActivityTestRule<HomeActivity> activityActivityTestRule =
      new ActivityTestRule<>(HomeActivity.class);

  @Before

  @Test
  public void testDataLoadedSuccess() {

  }

  @Test
  public void testDataLoadedFailed() {

  }
}
