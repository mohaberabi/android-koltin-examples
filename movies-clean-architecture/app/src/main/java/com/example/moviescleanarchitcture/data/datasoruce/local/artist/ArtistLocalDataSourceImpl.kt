package com.example.moviescleanarchitcture.data.datasoruce.local.artist

import com.example.moviescleanarchitcture.data.database.dao.ArtistDao
import com.example.moviescleanarchitcture.data.database.dao.MovieDao
import com.example.moviescleanarchitcture.data.model.artist.Artist
import com.example.moviescleanarchitcture.data.model.movie.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao) : ArtistLocalDataSource {
    override suspend fun getArtists(): List<Artist> = artistDao.getArtists()

    override suspend fun clearAllArtists() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteArtists()
        }
    }

    override suspend fun saveArtists(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO)
            .launch {
                artistDao.saveArtists(artists)
            }
    }
}