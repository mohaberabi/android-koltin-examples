package com.example.moviescleanarchitcture.presentation

import android.app.Application
import com.example.moviescleanarchitcture.BuildConfig
import com.example.moviescleanarchitcture.core.di.Injecter
import com.example.moviescleanarchitcture.core.di.artist.ArtistSubComponenet
import com.example.moviescleanarchitcture.core.di.core.AppComponent
import com.example.moviescleanarchitcture.core.di.core.AppModule
import com.example.moviescleanarchitcture.core.di.core.DaggerAppComponent
import com.example.moviescleanarchitcture.core.di.core.NetworkModule
import com.example.moviescleanarchitcture.core.di.core.RemoteDataSourceModule
import com.example.moviescleanarchitcture.core.di.movie.MovieSubComponent

class MyApp : Application(), Injecter {

    private lateinit var appComp: AppComponent

    override fun onCreate() {
        appComp =
            DaggerAppComponent.builder()
                .appModule(AppModule(applicationContext))
                .networkModule(
                    NetworkModule(BuildConfig.baseURL)
                ).remoteDataSourceModule(RemoteDataSourceModule(BuildConfig.movieApi)).build()
        super.onCreate()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComp.movieSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponenet {
        return appComp.artistSubComponent().create()
    }


}