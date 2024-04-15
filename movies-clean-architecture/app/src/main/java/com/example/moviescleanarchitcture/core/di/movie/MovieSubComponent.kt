package com.example.moviescleanarchitcture.core.di.movie

import com.example.moviescleanarchitcture.presentation.artist.ui.ArtistFragment
import com.example.moviescleanarchitcture.presentation.movie.ui.MoviesFragment
import dagger.Subcomponent


@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(moviesFragment: MoviesFragment)


    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }

}