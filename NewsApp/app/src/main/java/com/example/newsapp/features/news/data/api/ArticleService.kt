package com.example.newsapp.features.news.data.api

import com.example.newsapp.BuildConfig
import com.example.newsapp.features.news.data.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

object ApiConst {

    const val topHeadlinesEndPoint = "top-headlines"

}

interface ArticleService {


    @GET(ApiConst.topHeadlinesEndPoint)
    suspend fun getTopHeadlines(
        @Query("country")
        country: String,
        @Query("page")
        page: Int,
        @Query("apiKey")
        apiKey: String = BuildConfig.newsApi
    ): Response<NewsResponse>


}