package com.example.moviescleanarchitcture.domain.movie.repository

import com.example.moviescleanarchitcture.data.model.movie.Movie

interface MoviesRepository {


    suspend fun getMovies(): List<Movie>


    suspend fun saveMovies(): List<Movie>

}