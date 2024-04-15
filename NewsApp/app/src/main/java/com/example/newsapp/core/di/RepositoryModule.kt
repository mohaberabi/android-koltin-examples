package com.example.newsapp.core.di

import com.example.newsapp.features.news.data.datasource.remote.NewsRemoteDataSource
import com.example.newsapp.features.news.data.datasource.remote.NewsRemoteDataSourceImpl
import com.example.newsapp.features.news.data.repository.NewsRepositoryImpl
import com.example.newsapp.features.news.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {


    @Provides
    @Singleton
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource
    ): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource)
    }
}