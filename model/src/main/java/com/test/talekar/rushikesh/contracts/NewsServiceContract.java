package com.test.talekar.rushikesh.contracts;

import java.util.List;

/**
 * This is a service contract.
 * It provide a action for service implementor to initiate API call.
 * It captures callback from retrofit API interface.
 *
 * @author Rushikesh_Talekar
 */

public interface NewsServiceContract {
  /**
   * This method will initiate atual service call to get data.
   */
  void getNewsData();


  /**
   * This is a callback mechanism for implementer.
   *
   * @author Rushikesh_Talekar
   */
  interface Callback {
    /**
     * This method will notify user that API request is successful.
     *
     * @param newsDataList - news data returned by API
     */
    void onGetNewsSuccess(List<String> newsDataList);

    /**
     * This method will notify user that API request is failed.
     */
    void onGetNewsFailure();
  }
}
