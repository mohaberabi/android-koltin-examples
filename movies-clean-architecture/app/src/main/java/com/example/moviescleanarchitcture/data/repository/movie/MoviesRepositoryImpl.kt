package com.example.moviescleanarchitcture.data.repository.movie

import android.util.Log
import com.example.moviescleanarchitcture.data.datasoruce.local.movie.MovieLocalDataSource
import com.example.moviescleanarchitcture.data.datasoruce.persist.movie.PersistMovieDataSource
import com.example.moviescleanarchitcture.data.datasoruce.remote.movie.MovieRemoteDataSource
import com.example.moviescleanarchitcture.data.model.movie.Movie
import com.example.moviescleanarchitcture.domain.movie.repository.MoviesRepository
import java.lang.Exception

class MoviesRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val moveLocalDataSource: MovieLocalDataSource,
    private val moviePersistLocalDataSource: PersistMovieDataSource,
) :
    MoviesRepository {
    override suspend fun getMovies(): List<Movie> = getMoviesFromCache()


    override suspend fun saveMovies(): List<Movie> {
        val newListOfMovies = getMoviesFromAPI()
        moveLocalDataSource.clearAllMovies()
        moveLocalDataSource.saveMovies(newListOfMovies)
        moviePersistLocalDataSource.saveMovies(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMoviesFromAPI(): List<Movie> {
        val movieList = mutableListOf<Movie>()
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList.addAll(body.movies)
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return movieList
    }

    private suspend fun getMoviesFromDB(): List<Movie> {
        val movieList = mutableListOf<Movie>()
        try {

            val dbMovies = moveLocalDataSource.getMovies()
            movieList.addAll(dbMovies)
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            val apiMovies = getMoviesFromAPI()
            movieList.addAll(apiMovies)
            moveLocalDataSource.saveMovies(movieList)
        }

        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        val movieList = mutableListOf<Movie>()




        try {
            val memoryMovies = moviePersistLocalDataSource.getMovies()
            movieList.addAll(memoryMovies)
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            val dbMovies = getMoviesFromDB()
            movieList.addAll(dbMovies)
            moviePersistLocalDataSource.saveMovies(movieList)
        }

        return movieList
    }
}