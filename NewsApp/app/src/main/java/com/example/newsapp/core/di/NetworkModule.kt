package com.example.newsapp.core.di

import com.example.newsapp.BuildConfig
import com.example.newsapp.features.news.data.api.ArticleService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {


        return Retrofit.Builder()
            .baseUrl(BuildConfig.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideArticleService(
        retrofit: Retrofit
    ): ArticleService {

        return retrofit.create(ArticleService::class.java)
    }
}