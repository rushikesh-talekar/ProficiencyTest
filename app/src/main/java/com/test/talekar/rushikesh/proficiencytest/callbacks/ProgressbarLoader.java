package com.test.talekar.rushikesh.proficiencytest.callbacks;

/**
 * This is a interface to set rules to show and hide progressbar.
 *
 * @author Rushikesh_Talekar
 */

public interface ProgressbarLoader {
  /**
   * Method to show and hide progress dialog
   *
   * @param show - true to show and false to hide the dialog box
   */
  void showLoading(boolean show);

  /**
   * Method to show and hide progress dialog with message
   *
   * @param show - true to show otherwise false
   * @param msg  - message to be displayed
   */
  void showLoading(boolean show, String msg);


}
