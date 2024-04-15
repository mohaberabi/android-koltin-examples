package com.example.newsapp.features.news.data.datasource.remote

import com.example.newsapp.features.news.data.model.NewsResponse
import retrofit2.Response

interface NewsRemoteDataSource {


    suspend fun getTopHeadlines(country: String, page: Int): Response<NewsResponse>
}