package com.test.talekar.rushikesh.api;

import com.test.talekar.rushikesh.commons.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * This is a API interface to fetch news using a retofit framework.
 *
 * @author Rushikesh_Talekar
 */

public interface GetNewsAPI {
  /**
   * This is a method which will initiate API call and capture results and pass results to
   * service callback.
   * <p>
   * return List<String> - a list of news from webservice.
   */
  @GET(Constants.URL_GET_NEWS_DATA)
  Call<List<String>> getNewsData();
}
