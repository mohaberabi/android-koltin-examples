package com.example.moviescleanarchitcture.data.datasoruce.persist.artist

import com.example.moviescleanarchitcture.data.model.artist.Artist
import com.example.moviescleanarchitcture.data.model.movie.Movie

class PersistArtistDataSourceImpl : PersistArtistDataSource {

    private val inMemoryMovies = mutableListOf<Artist>()
    override suspend fun getArtists(): List<Artist> = inMemoryMovies

    override suspend fun saveArtists(movies: List<Artist>) {

        inMemoryMovies.clear()
        inMemoryMovies.addAll(movies)
    }
}