package com.test.talekar.rushikesh.presenter.contracts;

import com.test.talekar.rushikesh.model.Row;

import java.util.List;

/**
 * This interface will have all contract method between presenter and UI.
 * <p>
 *
 * @author Rushikesh_Talekar
 */

public interface CountryFactsContract {

  interface View {
    /**
     * This method will notify user that API request is successful.
     *
     * @param rowsData - data from server
     */
    void onGetCountryFactsSuccess(List<Row> rowsData);

    /**
     * This method will update UI if error occurs while fetching data
     */
    void showError();

    /**
     * This method will update UI if response from server is empty
     */
    void showEmptyReponseError();

    /**
     * This method sets toolbar title.
     */
    void setToolbarTitle(String title);
  }

  /**
   * This class is to initiate call from presenter.
   *
   * @author Rushikesh_Talekar
   */
  interface UserActionListner {

    void getCountryFacts();
  }
}
