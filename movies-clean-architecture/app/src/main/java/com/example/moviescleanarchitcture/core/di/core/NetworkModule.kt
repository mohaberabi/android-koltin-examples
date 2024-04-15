package com.example.moviescleanarchitcture.core.di.core

import com.example.moviescleanarchitcture.data.api.AppApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule(
    private val baseUrl: String
) {

    @Singleton
    @Provides
    fun provideRetroFit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    fun provideApiService(
        retrofit: Retrofit
    ): AppApiService {
        return retrofit.create(AppApiService::class.java)
    }
}