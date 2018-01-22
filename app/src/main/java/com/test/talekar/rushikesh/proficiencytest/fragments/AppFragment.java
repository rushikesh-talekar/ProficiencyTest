package com.test.talekar.rushikesh.proficiencytest.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.talekar.rushikesh.proficiencytest.R;
import com.test.talekar.rushikesh.proficiencytest.callbacks.ProgressbarLoader;
import com.test.talekar.rushikesh.proficiencytest.util.DialogUtil;
import com.test.talekar.rushikesh.util.NetworkUtil;

/**
 * Parent fragment to store all common code.
 * A simple {@link Fragment} subclass.
 *
 * @author Rushikesh_Talekar
 */
public class AppFragment extends Fragment implements ProgressbarLoader {

  private ProgressDialog progressDialog;

  public AppFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_app, container, false);
  }

  /**
   * Method to show and hide progress dialog
   *
   * @param show - true to show and false to hide the dialog box
   */
  @Override
  public void showLoading(boolean show) {
    if (show) {
      progressDialog = new ProgressDialog(getContext());
      progressDialog.setMessage(getString(R.string.loading_));
      progressDialog.show();
    } else {
      if (progressDialog != null) {
        progressDialog.dismiss();
      }
    }
  }

  /**
   * Method to show and hide progress dialog with message
   *
   * @param show - true to show otherwise false
   * @param msg  - message to be displayed
   */
  @Override
  public void showLoading(boolean show, String msg) {
    if (show) {
      progressDialog = new ProgressDialog(getContext());
      progressDialog.setMessage(msg);
      progressDialog.show();
    } else {
      if (progressDialog != null) {
        progressDialog.dismiss();
      }
    }
  }

  /**
   * Utility method to identify if network is connected or no
   *
   * @return true/false
   */
  protected boolean isNetworkConnected() {
    return NetworkUtil.getConnectivityStatus(getContext()) !=
        NetworkUtil.NETWORK_STATUS_NOT_CONNECTED;
  }

  protected void showNoNetworkError() {
    DialogUtil.showAlertDialog(getContext(),getString(R.string.error),
            getString(R.string.error_no_network));

  }
}
