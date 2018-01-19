package com.test.talekar.rushikesh.presenter.contracts;

/**
 * This interface will have all contract method between presenter and UI.
 * <p>
 *
 * @author Rushikesh_Talekar
 */

public interface NewsContract {
  /**
   * This method will notify user that API request is successful.
   */
  void onGetNewsSuccess();

  /**
   * This method will notify user that API request is failed.
   */
  void onGetNewsFailure();

  /**
   * This class is to initiate call from presenter.
   *
   * @author Rushikesh_Talekar
   */
  interface UserActionListner {

    void getNewsData();
  }
}
