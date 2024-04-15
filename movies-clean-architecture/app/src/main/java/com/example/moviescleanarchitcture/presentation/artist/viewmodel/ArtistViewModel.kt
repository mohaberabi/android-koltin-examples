package com.example.moviescleanarchitcture.presentation.artist.viewmodel

import com.example.moviescleanarchitcture.domain.artist.usecase.GetArtistsUseCase
import com.example.moviescleanarchitcture.domain.artist.usecase.SaveArtistsUseCase
import androidx.lifecycle.ViewModel

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val saveArtistsUseCase: SaveArtistsUseCase

) : ViewModel() {
}