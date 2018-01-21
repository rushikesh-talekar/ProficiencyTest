package com.test.talekar.rushikesh.proficiencytest;

import android.app.Application;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import com.test.talekar.rushikesh.commons.SessionManager;

/**
 * Created by Rushikesh_Talekar on 13-12-2017.
 */

public class ProficiencyTestApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    SessionManager.init(BuildConfig.BASE_URL);

    // BEGIN_INCLUDE(Configuration of Piccaso to cache images)
    Picasso.Builder builder = new Picasso.Builder(this);
    builder.downloader(new OkHttp3Downloader(this, Integer.MAX_VALUE));
    Picasso built = builder.build();
    built.setIndicatorsEnabled(true);
    built.setLoggingEnabled(true);
    Picasso.setSingletonInstance(built);
    // END_INCLUDE(Configuration of Piccaso to cache images)
  }
}
