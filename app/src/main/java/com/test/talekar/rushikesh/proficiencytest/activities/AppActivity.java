package com.test.talekar.rushikesh.proficiencytest.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.test.talekar.rushikesh.proficiencytest.R;

/**
 * This will be a parent Activity of all other activities.
 * All common code among activities will go here.
 *
 * @author Rushikesh_Talekar
 */
public class AppActivity extends AppCompatActivity {

  protected Toolbar toolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_app);
  }

  /**
   * This method sets title to toolbar.
   *
   * @param title - title string
   */
  void setToolbarTitle(String title) {
    setSupportActionBar(toolbar);
    if (null == getSupportActionBar()) {
      return;
    }
    getSupportActionBar().setTitle(title);
  }
}
