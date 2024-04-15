package com.example.newsapp.core.di

import com.example.newsapp.features.news.data.api.ArticleService
import com.example.newsapp.features.news.data.datasource.remote.NewsRemoteDataSource
import com.example.newsapp.features.news.data.datasource.remote.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule {


    @Provides
    @Singleton
    fun provideNewsRemoteDataSoruce(
        service: ArticleService
    ): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(service)
    }
}