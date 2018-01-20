package com.test.talekar.rushikesh.callback;

import com.test.talekar.rushikesh.model.CountryNews;

/**
 * This is a callback mechanism for implementer.
 *
 * @author Rushikesh_Talekar
 */

public interface ResponseCallback {
  /**
   * This method will notify user that API request is successful.
   *
   * @param newsData - news data returned by API
   */
  void onGetNewsSuccess(CountryNews newsData);

  /**
   * This method will notify user that API request is failed.
   */
  void onGetNewsFailure();
}
