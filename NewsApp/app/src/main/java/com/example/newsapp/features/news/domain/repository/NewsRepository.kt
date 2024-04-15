package com.example.newsapp.features.news.domain.repository

import com.example.newsapp.core.util.AppResult
import com.example.newsapp.features.news.data.model.Article
import com.example.newsapp.features.news.data.model.NewsResponse
import kotlinx.coroutines.flow.Flow

interface NewsRepository {


    suspend fun getNews(
        country: String, page: Int
    ): AppResult<NewsResponse>

    suspend fun searchNews(query: String): AppResult<NewsResponse>

    suspend fun saveNews(vararg articles: Article)

    suspend fun deleteNews(article: Article)

    fun getSavedNews(): Flow<List<Article>>

}