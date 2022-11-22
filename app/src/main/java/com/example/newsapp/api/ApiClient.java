package com.example.newsapp.api;

import com.example.newsapp.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
  private static ApiClient instance;
  private Retrofit retrofit;

  private ApiClient() {
    retrofit = new Retrofit.Builder()
            .baseUrl(BuildConfig.NewsBaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
  }

  public static synchronized ApiClient getInstance(){
    if(instance==null){
      instance = new ApiClient();
    }
    return instance;
  }

  public Api getApi(){
    return retrofit.create(Api.class);
  }
}
