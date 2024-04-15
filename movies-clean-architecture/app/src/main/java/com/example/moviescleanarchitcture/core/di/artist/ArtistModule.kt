package com.example.moviescleanarchitcture.core.di.artist

import com.example.moviescleanarchitcture.domain.artist.usecase.GetArtistsUseCase
import com.example.moviescleanarchitcture.domain.artist.usecase.SaveArtistsUseCase
import com.example.moviescleanarchitcture.presentation.artist.viewmodel.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module

class ArtistModule {


    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(

        getArtistsUseCase: GetArtistsUseCase,
        saveArtistsUseCase: SaveArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            saveArtistsUseCase
        )
    }
}