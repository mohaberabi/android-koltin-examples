package com.example.moviescleanarchitcture.core.di.core

import android.content.Context
import com.example.moviescleanarchitcture.core.di.artist.ArtistSubComponenet
import com.example.moviescleanarchitcture.core.di.movie.MovieSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(
    subcomponents = [
        MovieSubComponent::class,
        ArtistSubComponenet::class,
    ]
)
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideAppContext(): Context {
        return context.applicationContext
    }

}