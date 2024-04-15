package com.example.moviescleanarchitcture.domain.movie.usecase

import com.example.moviescleanarchitcture.domain.movie.repository.MoviesRepository

class GetMoviesUseCase(private val moviesRepository: MoviesRepository) {
    suspend fun execute() = moviesRepository.getMovies()
}