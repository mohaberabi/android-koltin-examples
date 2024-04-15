package com.example.moviescleanarchitcture.presentation.artist.viewmodel

import com.example.moviescleanarchitcture.domain.artist.usecase.GetArtistsUseCase
import com.example.moviescleanarchitcture.domain.artist.usecase.SaveArtistsUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ArtistViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val saveArtistsUseCase: SaveArtistsUseCase
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(ArtistViewModel::class.java)) {
            return ArtistViewModel(getArtistsUseCase, saveArtistsUseCase) as T
        }

        throw IllegalArgumentException("ERROR")
    }
}