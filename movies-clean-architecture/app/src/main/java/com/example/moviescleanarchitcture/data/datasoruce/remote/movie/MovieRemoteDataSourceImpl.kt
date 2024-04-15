package com.example.moviescleanarchitcture.data.datasoruce.remote.movie

import com.example.moviescleanarchitcture.data.api.AppApiService
import com.example.moviescleanarchitcture.data.model.movie.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val moviesService: AppApiService,
    private val api: String,
) :
    MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> = moviesService.getPopularMovies(api)
}