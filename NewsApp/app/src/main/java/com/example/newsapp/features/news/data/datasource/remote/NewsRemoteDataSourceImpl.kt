package com.example.newsapp.features.news.data.datasource.remote

import com.example.newsapp.features.news.data.api.ArticleService
import com.example.newsapp.features.news.data.model.NewsResponse
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val articleService: ArticleService,

    ) : NewsRemoteDataSource {

    override suspend fun getTopHeadlines(
        country: String,
        page: Int
    ): Response<NewsResponse> {
        return articleService.getTopHeadlines(
            country = country,
            page = page
        )
    }
}