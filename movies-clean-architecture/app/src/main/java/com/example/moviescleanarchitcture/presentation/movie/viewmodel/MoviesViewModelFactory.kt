package com.example.moviescleanarchitcture.presentation.movie.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviescleanarchitcture.domain.movie.usecase.GetMoviesUseCase
import com.example.moviescleanarchitcture.domain.movie.usecase.SaveMoviesUseCase

class MoviesViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: SaveMoviesUseCase
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesViewModel::class.java)) {
            return MoviesViewModel(getMoviesUseCase, updateMoviesUseCase) as T
        }
        throw IllegalArgumentException("ERROR")
    }
}