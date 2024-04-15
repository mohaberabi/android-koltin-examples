package com.example.moviescleanarchitcture.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviescleanarchitcture.data.model.movie.Movie

@Dao
interface MovieDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM movies")
    suspend fun deleteMovies()

    @Query("SELECT * FROM movies")
    suspend fun getMovies(): List<Movie>
}