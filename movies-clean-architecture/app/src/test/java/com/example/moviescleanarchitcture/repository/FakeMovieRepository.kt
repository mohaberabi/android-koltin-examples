package com.example.moviescleanarchitcture.repository

import com.example.moviescleanarchitcture.data.model.movie.Movie
import com.example.moviescleanarchitcture.domain.movie.repository.MoviesRepository
import com.example.moviescleanarchitcture.viewmodels.MoviesDummy

class FakeMovieRepository : MoviesRepository {


    private val movies = mutableListOf<Movie>()


    init {


        movies.addAll(MoviesDummy.movies)

    }

    override suspend fun getMovies(): List<Movie> = movies

    override suspend fun saveMovies(): List<Movie> {


        movies.clear()


        movies.addAll(MoviesDummy.movies2)
        return movies

    }
}