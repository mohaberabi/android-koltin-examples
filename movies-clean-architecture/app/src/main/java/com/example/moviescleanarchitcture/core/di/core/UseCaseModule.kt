package com.example.moviescleanarchitcture.core.di.core

import com.example.moviescleanarchitcture.domain.artist.usecase.GetArtistsUseCase
import com.example.moviescleanarchitcture.domain.artist.usecase.SaveArtistsUseCase
import com.example.moviescleanarchitcture.domain.artist.repository.ArtistRepository
import com.example.moviescleanarchitcture.domain.movie.repository.MoviesRepository
import com.example.moviescleanarchitcture.domain.movie.usecase.GetMoviesUseCase
import com.example.moviescleanarchitcture.domain.movie.usecase.SaveMoviesUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {


    @Singleton
    @Provides

    fun provideGetMoviesUseCase(
        moviesRepository: MoviesRepository
    ): GetMoviesUseCase {

        return GetMoviesUseCase(moviesRepository)
    }

    @Singleton
    @Provides

    fun provideUpdateMoviesUseCase(
        moviesRepository: MoviesRepository

    ): SaveMoviesUseCase {

        return SaveMoviesUseCase(moviesRepository)
    }

    @Singleton
    @Provides

    fun provideGetArtistUseCase(
        artistRepository: ArtistRepository

    ): GetArtistsUseCase {

        return GetArtistsUseCase(artistRepository)
    }

    @Singleton
    @Provides

    fun provideSaveArtistUseCase(
        artistRepository:
        ArtistRepository
    ): SaveArtistsUseCase {

        return SaveArtistsUseCase(artistRepository)
    }

}