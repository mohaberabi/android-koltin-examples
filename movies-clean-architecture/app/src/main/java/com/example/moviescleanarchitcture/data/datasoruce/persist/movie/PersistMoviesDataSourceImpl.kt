package com.example.moviescleanarchitcture.data.datasoruce.persist.movie

import com.example.moviescleanarchitcture.data.model.movie.Movie

class PersistMoviesDataSourceImpl : PersistMovieDataSource {

    private val inMemoryMovies = mutableListOf<Movie>()
    override suspend fun getMovies(): List<Movie> = inMemoryMovies

    override suspend fun saveMovies(movies: List<Movie>) {

        inMemoryMovies.clear()
        inMemoryMovies.addAll(movies)
    }
}