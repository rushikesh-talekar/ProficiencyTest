package com.test.talekar.rushikesh.presenter;

import android.util.Log;

import com.test.talekar.rushikesh.NewsServiceImpl;
import com.test.talekar.rushikesh.contracts.NewsServiceContract;
import com.test.talekar.rushikesh.model.CountryNews;
import com.test.talekar.rushikesh.presenter.contracts.NewsContract;

/**
 * Business logic releated to news will be here.
 *
 * @author Rushikesh_Talekar
 */

public class NewsPresenter implements NewsContract.UserActionListner,
    NewsServiceContract.Callback {
  public static final String TAG = NewsPresenter.class.getSimpleName();
  NewsContract viewContract;

  public NewsPresenter(NewsContract viewContract) {
    this.viewContract = viewContract;
  }

  @Override
  public void getNewsData() {
    NewsServiceContract newsServiceContract = new NewsServiceImpl(this);
    newsServiceContract.getNewsData();
  }

  @Override
  public void onGetNewsSuccess(CountryNews newsData) {
    Log.e(TAG, "" + newsData.getRows().size());
    if (null != viewContract) {
      viewContract.onGetNewsSuccess();
    }
  }

  @Override
  public void onGetNewsFailure() {
    if (null != viewContract) {
      viewContract.onGetNewsFailure();
    }
  }
}
