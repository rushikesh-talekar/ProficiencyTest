package com.test.talekar.rushikesh.proficiencytest;

import android.app.Application;

import com.test.talekar.rushikesh.commons.SessionManager;

/**
 * Created by Rushikesh_Talekar on 13-12-2017.
 */

public class ProficiencyTestApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    SessionManager.init(BuildConfig.BASE_URL);
  }
}
