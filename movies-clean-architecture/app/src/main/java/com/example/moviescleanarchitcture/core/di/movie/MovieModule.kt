package com.example.moviescleanarchitcture.core.di.movie

import com.example.moviescleanarchitcture.domain.movie.usecase.GetMoviesUseCase
import com.example.moviescleanarchitcture.domain.movie.usecase.SaveMoviesUseCase
import com.example.moviescleanarchitcture.presentation.movie.viewmodel.MoviesViewModelFactory
import dagger.Module
import dagger.Provides

@Module

class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(

        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: SaveMoviesUseCase
    ): MoviesViewModelFactory {
        return MoviesViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }
}