package com.example.moviescleanarchitcture.domain.artist.usecase

import com.example.moviescleanarchitcture.domain.artist.repository.ArtistRepository

class SaveArtistsUseCase(private val artistRepository: ArtistRepository) {


    suspend fun execute() = artistRepository.saveArtists()
}