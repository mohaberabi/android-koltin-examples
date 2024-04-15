package com.example.moviescleanarchitcture.data.model.rated


import com.example.moviescleanarchitcture.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class TopRatedMovies(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)