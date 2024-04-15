package com.example.moviescleanarchitcture.core.di.core

import com.example.moviescleanarchitcture.core.di.artist.ArtistSubComponenet
import com.example.moviescleanarchitcture.core.di.movie.MovieSubComponent
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [

        LocalDataSourceModule::class,
        NetworkModule::class,
        PersistDatasourceModule::class,
        NetworkModule::class,
        RemoteDataSourceModule::class,
        RepositoryModule::class,
        UseCaseModule::class,

        AppModule::class,
        DatabaseModule::class
    ]
)
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponenet.Factory

}