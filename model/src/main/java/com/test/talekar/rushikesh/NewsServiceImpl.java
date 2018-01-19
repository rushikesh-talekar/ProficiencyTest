package com.test.talekar.rushikesh;

import com.test.talekar.rushikesh.api.GetNewsAPI;
import com.test.talekar.rushikesh.commons.SessionManager;
import com.test.talekar.rushikesh.contracts.NewsServiceContract;

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
    Callback<List<String>> {
  NewsServiceContract.Callback callback;

  public NewsServiceImpl(
      NewsServiceContract.Callback callback) {
    this.callback = callback;
  }

  @Override
  public void getNewsData() {
    try {
      Call<List<String>> call = SessionManager.getSessionManager()
          .createRestAdapter().create(GetNewsAPI.class).getNewsData();
      call.enqueue(this);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onResponse(Call<List<String>> call, Response<List<String>> response) {
    if (response.isSuccessful()) {
      callback.onGetNewsSuccess(response.body());
    }
  }

  @Override
  public void onFailure(Call<List<String>> call, Throwable throwable) {
    callback.onGetNewsFailure();
  }
}
