package com.example.moviescleanarchitcture.data.datasoruce.local.artist

import com.example.moviescleanarchitcture.data.model.artist.Artist
import com.example.moviescleanarchitcture.data.model.movie.Movie

interface ArtistLocalDataSource {

    suspend fun getArtists(): List<Artist>

    suspend fun clearAllArtists()

    suspend fun saveArtists(artists: List<Artist>)

}