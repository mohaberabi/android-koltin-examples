package com.example.moviescleanarchitcture.data.datasoruce.local.movie

import com.example.moviescleanarchitcture.data.database.dao.MovieDao
import com.example.moviescleanarchitcture.data.model.movie.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val moviesDao: MovieDao) : MovieLocalDataSource {
    override suspend fun getMovies(): List<Movie> = moviesDao.getMovies()

    override suspend fun clearAllMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            moviesDao.deleteMovies()
        }
    }

    override suspend fun saveMovies(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO)
            .launch {
                moviesDao.saveMovies(movies)
            }
    }
}