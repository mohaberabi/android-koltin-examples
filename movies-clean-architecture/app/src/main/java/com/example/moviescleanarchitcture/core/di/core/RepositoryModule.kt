package com.example.moviescleanarchitcture.core.di.core

import com.example.moviescleanarchitcture.data.datasoruce.local.artist.ArtistLocalDataSource
import com.example.moviescleanarchitcture.data.datasoruce.local.movie.MovieLocalDataSource
import com.example.moviescleanarchitcture.data.datasoruce.persist.artist.PersistArtistDataSource
import com.example.moviescleanarchitcture.data.datasoruce.persist.movie.PersistMovieDataSource
import com.example.moviescleanarchitcture.data.datasoruce.remote.artist.ArtistRemoteDataSource
import com.example.moviescleanarchitcture.data.datasoruce.remote.artist.ArtistRemoteDatasourceImpl
import com.example.moviescleanarchitcture.data.datasoruce.remote.movie.MovieRemoteDataSource
import com.example.moviescleanarchitcture.data.repository.artist.ArtistRepositoryImpl
import com.example.moviescleanarchitcture.data.repository.movie.MoviesRepositoryImpl
import com.example.moviescleanarchitcture.domain.artist.repository.ArtistRepository
import com.example.moviescleanarchitcture.domain.movie.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module

class RepositoryModule {


    @Provides
    @Singleton
    fun provideMoviesRepository(
        movieLocalDataSource: MovieLocalDataSource,
        movieRemoteDataSource: MovieRemoteDataSource,
        persistMovieDataSoruce: PersistMovieDataSource
    ): MoviesRepository {
        return MoviesRepositoryImpl(
            moveLocalDataSource = movieLocalDataSource,
            moviePersistLocalDataSource = persistMovieDataSoruce,
            movieRemoteDataSource = movieRemoteDataSource
        )
    }

    @Provides
    @Singleton
    fun provideArtisRepository(
        artisLocalDataSource: ArtistLocalDataSource,
        artistRemoteDatasource: ArtistRemoteDataSource,
        persistArtistDataSource: PersistArtistDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artisLocalDataSource,
            persistArtistDataSource
        )
    }


}