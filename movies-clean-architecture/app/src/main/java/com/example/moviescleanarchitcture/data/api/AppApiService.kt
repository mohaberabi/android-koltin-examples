package com.example.moviescleanarchitcture.data.api

import com.example.moviescleanarchitcture.core.utils.CommonParams
import com.example.moviescleanarchitcture.data.model.movie.MovieList
import com.example.moviescleanarchitcture.data.model.rated.TopRatedMovies
import com.example.moviescleanarchitcture.data.model.artist.TredningArtists
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


object ApiEndPoints {

    const val popularMovies = "movie/popular"
    const val topRatedMovies = "movie/top_rated"
    const val trendingArtists = "person/popular"


}

interface AppApiService {


    @GET(ApiEndPoints.popularMovies)
    suspend fun getPopularMovies(@Query(CommonParams.apiKey) apiKey: String): Response<MovieList>

    @GET(ApiEndPoints.trendingArtists)
    suspend fun getTrendingArtists(@Query(CommonParams.apiKey) apiKey: String): Response<TredningArtists>

    @GET(ApiEndPoints.topRatedMovies)
    suspend fun getTopRatedMovies(@Query(CommonParams.apiKey) apiKey: String): Response<TopRatedMovies>

}

