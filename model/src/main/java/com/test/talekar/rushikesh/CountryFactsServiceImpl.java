package com.test.talekar.rushikesh;

import com.test.talekar.rushikesh.api.GetCountryFactsAPI;
import com.test.talekar.rushikesh.callback.ResponseCallback;
import com.test.talekar.rushikesh.commons.SessionManager;
import com.test.talekar.rushikesh.contracts.CountryFactsServiceContract;
import com.test.talekar.rushikesh.model.CountryNews;

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

public class CountryFactsServiceImpl implements CountryFactsServiceContract,
    Callback<CountryNews> {
  ResponseCallback callback;

  public CountryFactsServiceImpl(ResponseCallback callback) {
    this.callback = callback;
  }

  @Override
  public void getCountryfacts() {
    try {
      Call<CountryNews> call = SessionManager.getSessionManager()
          .createRestAdapter().create(GetCountryFactsAPI.class).getCountryFacts();
      call.enqueue(this);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onResponse(Call<CountryNews> call, Response<CountryNews> response) {
    if (response.isSuccessful()) {
      callback.onGetCountryFactsSuccess(response.body());
    }
  }

  @Override
  public void onFailure(Call<CountryNews> call, Throwable throwable) {
    callback.onGetCountryFactsFailure();
  }
}