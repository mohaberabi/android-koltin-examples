package com.example.moviescleanarchitcture.data.datasoruce.remote.movie

import com.example.moviescleanarchitcture.data.model.movie.Movie
import com.example.moviescleanarchitcture.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {


    suspend fun getMovies(): Response<MovieList>
}