package com.example.moviescleanarchitcture.data.datasoruce.persist.artist

import com.example.moviescleanarchitcture.data.model.artist.Artist
import com.example.moviescleanarchitcture.data.model.movie.Movie

interface PersistArtistDataSource {


    suspend fun getArtists(): List<Artist>


    suspend fun saveArtists(movies: List<Artist>)
}