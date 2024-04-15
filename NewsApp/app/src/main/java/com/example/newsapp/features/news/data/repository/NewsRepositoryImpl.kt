package com.example.newsapp.features.news.data.repository

import com.example.newsapp.core.util.AppResult
import com.example.newsapp.features.news.data.datasource.remote.NewsRemoteDataSource
import com.example.newsapp.features.news.data.model.Article
import com.example.newsapp.features.news.data.model.NewsResponse
import com.example.newsapp.features.news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
) : NewsRepository {


    override suspend fun getNews(
        country: String, page: Int

    ): AppResult<NewsResponse> =
        mapResponseToResult(
            newsRemoteDataSource.getTopHeadlines(
                country,
                page
            ),
        )

    override suspend fun searchNews(query: String):
            AppResult<NewsResponse> = mapResponseToResult(
        newsRemoteDataSource.getTopHeadlines("", 1),
    )

    override suspend fun saveNews(vararg articles: Article) {
        throw Exception("")
    }

    override suspend fun deleteNews(article: Article) {
        throw Exception("")

    }

    override fun getSavedNews(): Flow<List<Article>> {
        throw Exception("")

    }

    private fun mapResponseToResult(response: Response<NewsResponse>):
            AppResult<NewsResponse> {
        return if (response.isSuccessful) {
            return if (response.body() == null) {
                AppResult.Error(response.message())
            } else {
                val res = response.body()!!
                AppResult.Done(res)
            }
        } else {
            AppResult.Error(response.message())
        }
    }
}