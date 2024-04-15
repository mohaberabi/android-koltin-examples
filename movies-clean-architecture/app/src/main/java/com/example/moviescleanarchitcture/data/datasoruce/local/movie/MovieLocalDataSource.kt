package com.example.moviescleanarchitcture.data.datasoruce.local.movie

import com.example.moviescleanarchitcture.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMovies(): List<Movie>

    suspend fun clearAllMovies()

    suspend fun saveMovies(movies: List<Movie>)

}