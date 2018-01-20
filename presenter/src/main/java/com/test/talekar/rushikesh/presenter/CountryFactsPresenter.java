package com.test.talekar.rushikesh.presenter;

import android.util.Log;

import com.test.talekar.rushikesh.CountryFactsServiceImpl;
import com.test.talekar.rushikesh.callback.ResponseCallback;
import com.test.talekar.rushikesh.contracts.CountryFactsServiceContract;
import com.test.talekar.rushikesh.model.CountryFacts;
import com.test.talekar.rushikesh.presenter.contracts.CountryFactsContract;
import com.test.talekar.rushikesh.util.CollectionUtil;

import java.util.Collections;

/**
 * Business logic releated to news will be here.
 *
 * @author Rushikesh_Talekar
 */

public class CountryFactsPresenter implements CountryFactsContract.UserActionListner,
    ResponseCallback {
  public static final String TAG = CountryFactsPresenter.class.getSimpleName();
  CountryFactsContract viewContract;

  public CountryFactsPresenter(CountryFactsContract viewContract) {
    this.viewContract = viewContract;
  }

  @Override
  public void getCountryFacts() {
    CountryFactsServiceContract countryFactsServiceContract = new CountryFactsServiceImpl(this);
    countryFactsServiceContract.getCountryfacts();
  }

  @Override
  public void onGetCountryFactsSuccess(CountryFacts newsData) {
    Log.e(TAG, "" + newsData.getRows().size());
    if (null == viewContract) {
      return;
    }

    if (null == newsData || CollectionUtil.isEmpty(newsData.getRows())) {
      viewContract.showEmptyReponseError();
      return;
    }
    viewContract.setToolbarTitle(newsData.getTitle());
    viewContract.onGetCountryFactsSuccess(newsData.getRows());
  }

  @Override
  public void onGetCountryFactsFailure() {
    if (null == viewContract) {
      return;
    }
    viewContract.showError();
  }
}
