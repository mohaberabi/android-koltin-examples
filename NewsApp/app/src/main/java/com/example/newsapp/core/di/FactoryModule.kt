package com.example.newsapp.core.di

import com.example.newsapp.core.util.NetworkConnectionChecker
import com.example.newsapp.features.news.domain.usecase.GetNewsUseCase
import com.example.newsapp.features.news.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module

@InstallIn(SingletonComponent::class)
class FactoryModule {


    @Provides
    @Singleton
    fun provideNewsViewModelFactory(
        getNewsUseCase: GetNewsUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(
            getNewsUseCase,
        )
    }
}