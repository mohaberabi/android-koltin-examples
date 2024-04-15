package com.example.moviescleanarchitcture.core.di.core

import com.example.moviescleanarchitcture.data.api.AppApiService
import com.example.moviescleanarchitcture.data.database.dao.ArtistDao
import com.example.moviescleanarchitcture.data.database.dao.MovieDao
import com.example.moviescleanarchitcture.data.datasoruce.local.artist.ArtistLocalDataSource
import com.example.moviescleanarchitcture.data.datasoruce.local.artist.ArtistLocalDataSourceImpl
import com.example.moviescleanarchitcture.data.datasoruce.local.movie.MovieLocalDataSource
import com.example.moviescleanarchitcture.data.datasoruce.local.movie.MovieLocalDataSourceImpl

import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LocalDataSourceModule(

) {


    @Provides
    @Singleton
    fun provideMovieRemoteDataSource(
        movieDao: MovieDao
    ): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(
            movieDao
        )
    }

    @Provides
    @Singleton
    fun proveArtisRemoteDataSource(
        artistDao: ArtistDao
    ): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(
            artistDao
        )
    }

}