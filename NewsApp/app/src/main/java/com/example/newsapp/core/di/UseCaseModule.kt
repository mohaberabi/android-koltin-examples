package com.example.newsapp.core.di

import com.example.newsapp.features.news.domain.repository.NewsRepository
import com.example.newsapp.features.news.domain.usecase.GetNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetNewsUseCase(
        newsRepository: NewsRepository
    ): GetNewsUseCase {
        return GetNewsUseCase(newsRepository)
    }
}