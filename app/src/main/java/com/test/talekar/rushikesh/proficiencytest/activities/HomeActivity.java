package com.test.talekar.rushikesh.proficiencytest.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;

import com.test.talekar.rushikesh.proficiencytest.R;
import com.test.talekar.rushikesh.proficiencytest.fragments.HomeFragment;

/**
 * This is a launcher activity.
 *
 * @author Rushikesh_Talekar
 */
public class HomeActivity extends AppActivity implements
    HomeFragment.OnFragmentInteractionListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    initUI();
    setListners();
    addFactsFragment();
  }

  /**
   * Used fragment so that It can be reused if required in any other activity
   * Load UI fragment in activity.
   */
  private void addFactsFragment() {
    getSupportFragmentManager().beginTransaction()
        .add(R.id.activity_home_container, HomeFragment.newInstance())
        .commit();
  }

  /**
   * This method will initialize all listners.
   */
  private void setListners() {
  }

  /**
   * This method will initialize views as required.
   */
  private void initUI() {
    toolbar = (Toolbar) findViewById(R.id.toolbar);
    setToolbarTitle(getString(R.string.home_page));
  }

  @Override
  public void setToolbarTitle(String title) {
    super.setToolbarTitle(TextUtils.isEmpty(title) ? getString(R.string.home_page) : title);
  }
}
