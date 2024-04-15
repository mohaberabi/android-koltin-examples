package com.example.moviescleanarchitcture.presentation.movie.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviescleanarchitcture.domain.movie.usecase.GetMoviesUseCase
import com.example.moviescleanarchitcture.domain.movie.usecase.SaveMoviesUseCase

class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: SaveMoviesUseCase
) : ViewModel() {


    fun getMovies() = liveData {

        val movies = getMoviesUseCase.execute()
        emit(movies)
    }

    fun updateMovies() = liveData {
        val movies = updateMoviesUseCase.execute()
        emit(movies)
    }

}