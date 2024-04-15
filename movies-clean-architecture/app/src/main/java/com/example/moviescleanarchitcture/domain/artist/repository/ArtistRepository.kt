package com.example.moviescleanarchitcture.domain.artist.repository

import com.example.moviescleanarchitcture.data.model.artist.Artist

interface ArtistRepository {


    suspend fun getArtists(): List<Artist>


    suspend fun saveArtists(): List<Artist>

}