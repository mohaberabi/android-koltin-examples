package com.example.moviescleanarchitcture.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviescleanarchitcture.data.model.artist.Artist
import com.example.moviescleanarchitcture.data.model.movie.Movie

@Dao
interface ArtistDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(movies: List<Artist>)

    @Query("DELETE FROM artists")
    suspend fun deleteArtists()

    @Query("SELECT * FROM artists")
    suspend fun getArtists(): List<Artist>
}