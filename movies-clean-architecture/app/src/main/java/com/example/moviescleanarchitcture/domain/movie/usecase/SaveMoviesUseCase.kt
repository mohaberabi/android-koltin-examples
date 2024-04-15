package com.example.moviescleanarchitcture.domain.movie.usecase

import com.example.moviescleanarchitcture.data.model.movie.Movie
import com.example.moviescleanarchitcture.domain.movie.repository.MoviesRepository

class SaveMoviesUseCase(private val moviesRepository: MoviesRepository) {


    suspend fun execute() = moviesRepository.getMovies()
}