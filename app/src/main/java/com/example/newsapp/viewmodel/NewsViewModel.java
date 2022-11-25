package com.example.newsapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsapp.BuildConfig;
import com.example.newsapp.api.ApiClient;
import com.example.newsapp.model.NewsList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel extends ViewModel {
  private static final String TAG = "NewsViewModel";
  MutableLiveData<NewsList> newsList;

  public MutableLiveData<NewsList> getNewsList() {
    if (newsList == null) {
      newsList = new MutableLiveData<>();
      setNewsList();
    }
    return newsList;
  }

  private void setNewsList() {
    ApiClient.getInstance().getApi().getNewsList("id", BuildConfig.NewsAPIKey)
            .enqueue(new Callback<NewsList>() {
              @Override
              public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                if (response.isSuccessful()) {
                  newsList.postValue(response.body());
                }
              }

              @Override
              public void onFailure(Call<NewsList> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
              }
            });
  }
}
