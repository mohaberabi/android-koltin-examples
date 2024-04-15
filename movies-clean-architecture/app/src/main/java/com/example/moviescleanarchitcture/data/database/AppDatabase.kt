package com.example.moviescleanarchitcture.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviescleanarchitcture.data.database.dao.ArtistDao
import com.example.moviescleanarchitcture.data.database.dao.MovieDao
import com.example.moviescleanarchitcture.data.model.artist.Artist
import com.example.moviescleanarchitcture.data.model.movie.Movie


@Database(
    [Movie::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract val moviesDao: MovieDao

    abstract val artistDao: ArtistDao


}