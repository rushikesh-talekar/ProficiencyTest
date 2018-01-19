package com.test.talekar.rushikesh;

import com.test.talekar.rushikesh.api.GetNewsAPI;
import com.test.talekar.rushikesh.commons.SessionManager;
import com.test.talekar.rushikesh.contracts.NewsServiceContract;
import com.test.talekar.rushikesh.model.CountryNews;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This is a service implementer.
 * It will handle all data related functionality like initiating actual API call or database
 * operation.
 *
 * @author Rushikesh_Talekar
 */

public class NewsServiceImpl implements NewsServiceContract,
    Callback<CountryNews> {
  NewsServiceContract.Callback callback;

  public NewsServiceImpl(
      NewsServiceContract.Callback callback) {
    this.callback = callback;
  }

  @Override
  public void getNewsData() {
    try {
      Call<CountryNews> call = SessionManager.getSessionManager()
          .createRestAdapter().create(GetNewsAPI.class).getNewsData();
      call.enqueue(this);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onResponse(Call<CountryNews> call, Response<CountryNews> response) {
    if (response.isSuccessful()) {
      callback.onGetNewsSuccess(response.body());
    }
  }

  @Override
  public void onFailure(Call<CountryNews> call, Throwable throwable) {
    callback.onGetNewsFailure();
  }
}