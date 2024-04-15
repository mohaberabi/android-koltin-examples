package com.example.moviescleanarchitcture.core.di.core

import com.example.moviescleanarchitcture.data.api.AppApiService
import com.example.moviescleanarchitcture.data.datasoruce.remote.artist.ArtistRemoteDataSource
import com.example.moviescleanarchitcture.data.datasoruce.remote.artist.ArtistRemoteDatasourceImpl
import com.example.moviescleanarchitcture.data.datasoruce.remote.movie.MovieRemoteDataSource
import com.example.moviescleanarchitcture.data.datasoruce.remote.movie.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module

class RemoteDataSourceModule(
    private val apiKey: String
) {
    @Provides
    @Singleton
    fun provideMovieRemoteDataSource(
        appApiService: AppApiService
    ): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            appApiService,
            apiKey
        )
    }

    @Provides
    @Singleton
    fun proveArtisRemoteDataSource(
        appApiService: AppApiService
    ): ArtistRemoteDataSource {
        return ArtistRemoteDatasourceImpl(
            appApiService,
            apiKey
        )
    }

}