package com.test.talekar.rushikesh.commons;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This calss is created to handle session.
 * It will also have API call initializations here.
 *
 * @author Rushikesh_Talekar
 */

public class SessionManager {

  private volatile static SessionManager sessionManager = null;

  /**
   * Base Url for retrieving data.
   */
  private static String baseUrl;


  private SessionManager() {
  }

  /**
   * Method to get instance of session manager
   *
   * @return - instance of sxm session manager
   * @throws IOException - throws IOException if base url is not provided
   */
  public static SessionManager getSessionManager() throws IOException {
    if (sessionManager == null) {
      sessionManager = new SessionManager();
    }
    return sessionManager;
  }

  public Retrofit createRestAdapter() {
    Gson gson = new GsonBuilder()
        .setLenient()
        .create();

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();

    return retrofit;
  }

  /**
   * Method for initializing base url
   *
   * @param baseUrl
   */
  public static void init(String baseUrl) {
    SessionManager.baseUrl = baseUrl;
  }
}
