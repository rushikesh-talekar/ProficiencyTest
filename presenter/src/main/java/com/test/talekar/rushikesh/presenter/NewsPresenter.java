package com.test.talekar.rushikesh.presenter;

import com.test.talekar.rushikesh.NewsServiceImpl;
import com.test.talekar.rushikesh.contracts.NewsServiceContract;
import com.test.talekar.rushikesh.presenter.contracts.NewsContract;

import java.util.List;

/**
 * Business logic releated to news will be here.
 *
 * @author Rushikesh_Talekar
 */

public class NewsPresenter implements NewsContract.UserActionListner,
    NewsServiceContract.Callback {
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
  public void onGetNewsSuccess(List<String> newsData) {
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
