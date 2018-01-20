package com.test.talekar.rushikesh.contracts;

import com.test.talekar.rushikesh.model.CountryNews;

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
}
