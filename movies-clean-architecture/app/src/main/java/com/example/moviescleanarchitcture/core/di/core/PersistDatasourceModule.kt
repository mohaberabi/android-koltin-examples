package com.example.moviescleanarchitcture.core.di.core

import com.example.moviescleanarchitcture.data.api.AppApiService

import com.example.moviescleanarchitcture.data.datasoruce.persist.artist.PersistArtistDataSource
import com.example.moviescleanarchitcture.data.datasoruce.persist.artist.PersistArtistDataSourceImpl
import com.example.moviescleanarchitcture.data.datasoruce.persist.movie.PersistMovieDataSource
import com.example.moviescleanarchitcture.data.datasoruce.persist.movie.PersistMoviesDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class PersistDatasourceModule {


    @Provides
    @Singleton
    fun provideMovieRemoteDataSource(
        appApiService: AppApiService
    ): PersistMovieDataSource {
        return PersistMoviesDataSourceImpl(
        )
    }

    @Provides
    @Singleton
    fun proveArtisRemoteDataSource(
        appApiService: AppApiService
    ): PersistArtistDataSource {
        return PersistArtistDataSourceImpl(
        )
    }


}