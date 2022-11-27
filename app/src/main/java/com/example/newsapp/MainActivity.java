package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;

import com.example.newsapp.adapter.NewsAdapter;
import com.example.newsapp.model.NewsList;
import com.example.newsapp.viewmodel.NewsViewModel;

import java.util.Objects;

public class MainActivity extends AppCompatActivity{
  RecyclerView recylerView;
  NewsAdapter adapter;
  NewsViewModel viewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    super.onCreate(savedInstanceState);
    Objects.requireNonNull(getSupportActionBar()).setTitle("RESTAPI_2018112");
    setContentView(R.layout.activity_main);
    recylerView = findViewById(R.id.recyclerView);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    recylerView.setLayoutManager(linearLayoutManager);
    viewModel = new NewsViewModel();
    viewModel.getNewsList().observe(this, new Observer<NewsList>() {
      @Override
      public void onChanged(NewsList newsList) {
        if (newsList.getArticles() != null) {
          adapter = new NewsAdapter(MainActivity.this, newsList.getArticles());
          adapter.notifyDataSetChanged();
          recylerView.setAdapter(adapter);
        } else {
          Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
        }
      }
    });

  }
}