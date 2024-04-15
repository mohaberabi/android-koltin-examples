package com.example.moviescleanarchitcture.core.di.core

import android.content.Context
import androidx.room.Room
import com.example.moviescleanarchitcture.data.database.AppDatabase
import com.example.moviescleanarchitcture.data.database.dao.ArtistDao
import com.example.moviescleanarchitcture.data.database.dao.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {


    @Provides

    @Singleton

    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "movieApp.db"
        )
            .build()
    }


    @Provides
    @Singleton
    fun provideMovieDao(
        appDatabase:
        AppDatabase
    ): MovieDao {
        return appDatabase.moviesDao
    }

    @Provides
    @Singleton
    fun provideArtistDao(
        appDatabase:
        AppDatabase
    ): ArtistDao {
        return appDatabase.artistDao
    }
}