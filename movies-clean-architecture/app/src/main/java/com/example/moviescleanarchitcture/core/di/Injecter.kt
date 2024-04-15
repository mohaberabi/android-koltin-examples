package com.example.moviescleanarchitcture.core.di

import com.example.moviescleanarchitcture.core.di.artist.ArtistSubComponenet
import com.example.moviescleanarchitcture.core.di.movie.MovieSubComponent


interface Injecter {
    fun createMovieSubComponent(): MovieSubComponent
    fun createArtistSubComponent(): ArtistSubComponenet

}