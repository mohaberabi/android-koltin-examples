package com.example.moviescleanarchitcture.domain.artist.usecase

import com.example.moviescleanarchitcture.domain.artist.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute() = artistRepository.getArtists()
}