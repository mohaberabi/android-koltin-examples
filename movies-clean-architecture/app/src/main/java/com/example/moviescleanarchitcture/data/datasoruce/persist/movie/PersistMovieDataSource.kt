package com.example.moviescleanarchitcture.data.datasoruce.persist.movie

import com.example.moviescleanarchitcture.data.model.movie.Movie

interface PersistMovieDataSource {


    suspend fun getMovies(): List<Movie>


    suspend fun saveMovies(movies: List<Movie>)
}