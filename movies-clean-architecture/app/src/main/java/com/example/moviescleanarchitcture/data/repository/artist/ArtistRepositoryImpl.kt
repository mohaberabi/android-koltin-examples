package com.example.moviescleanarchitcture.data.repository.artist

import com.example.moviescleanarchitcture.domain.artist.repository.ArtistRepository
import android.util.Log
import com.example.moviescleanarchitcture.data.datasoruce.local.artist.ArtistLocalDataSource
import com.example.moviescleanarchitcture.data.datasoruce.persist.artist.PersistArtistDataSource
import com.example.moviescleanarchitcture.data.datasoruce.remote.artist.ArtistRemoteDataSource
import com.example.moviescleanarchitcture.data.model.artist.Artist

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDatasource: ArtistLocalDataSource,
    private val artistPersistDataSource: PersistArtistDataSource,
) :
    ArtistRepository {
    override suspend fun getArtists(): List<Artist> = getInMemoryArtists()
    override suspend fun saveArtists(): List<Artist> {
        val newArtists = getRemoteMovies()
        artistLocalDatasource.clearAllArtists()
        artistLocalDatasource.saveArtists(newArtists)
        artistPersistDataSource.saveArtists(newArtists)
        return newArtists
    }

    private suspend fun getRemoteMovies(): List<Artist> {

        lateinit var artists: List<Artist>


        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                artists = body.artists
            }
        } catch (e: Exception) {
            Log.i("movies", e.message.toString())
        }


        return artists
    }

    private suspend fun getLocalArtists(): List<Artist> {

        lateinit var artists: List<Artist>


        try {
            artists = artistLocalDatasource.getArtists()
            return artists.ifEmpty {
                artists = getRemoteMovies()
                artistLocalDatasource.saveArtists(artists)
                artists
            }
        } catch (e: Exception) {
            Log.i("movies", e.message.toString())
        }


        return artists
    }


    private suspend fun getInMemoryArtists(): List<Artist> {

        lateinit var artists: List<Artist>

        try {
            artists = artistPersistDataSource.getArtists()

        } catch (e: Exception) {
            Log.i("movies", e.message.toString())
        }

        return artists.ifEmpty {

            artists = getLocalArtists()
            artistPersistDataSource.saveArtists(artists)
            artists
        }
    }
}