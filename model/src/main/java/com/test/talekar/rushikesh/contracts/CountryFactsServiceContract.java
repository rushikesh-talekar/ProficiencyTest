package com.test.talekar.rushikesh.contracts;

/**
 * This is a service contract.
 * It provide a action for service implementor to initiate API call.
 * It captures callback from retrofit API interface.
 *
 * @author Rushikesh_Talekar
 */

public interface CountryFactsServiceContract {
  /**
   * This method will initiate atual service call to get data.
   */
  void getCountryfacts();
}
