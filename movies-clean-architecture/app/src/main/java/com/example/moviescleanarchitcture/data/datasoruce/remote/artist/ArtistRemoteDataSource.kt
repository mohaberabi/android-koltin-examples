package com.example.moviescleanarchitcture.data.datasoruce.remote.artist

import com.example.moviescleanarchitcture.data.model.artist.TredningArtists
import com.example.moviescleanarchitcture.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDataSource {


    suspend fun getArtists(): Response<TredningArtists>
}