package com.example.newsapp.model;

import java.util.List;

public class NewsList{
	private List<ArticlesItem> articles;

	public void setArticles(List<ArticlesItem> articles){
		this.articles = articles;
	}

	public List<ArticlesItem> getArticles(){
		return articles;
	}
}