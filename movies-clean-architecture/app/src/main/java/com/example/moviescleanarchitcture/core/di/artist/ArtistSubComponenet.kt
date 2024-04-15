package com.example.moviescleanarchitcture.core.di.artist

import com.example.moviescleanarchitcture.presentation.artist.ui.ArtistFragment
import dagger.Subcomponent


@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponenet {

    fun inject(artistFragment: ArtistFragment)


    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponenet
    }

}