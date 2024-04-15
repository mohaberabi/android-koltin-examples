package com.example.moviescleanarchitcture.data.model.artist


import com.example.moviescleanarchitcture.data.model.artist.Artist
import com.google.gson.annotations.SerializedName

data class TredningArtists(
    @SerializedName("results")
    val artists: List<Artist>
)