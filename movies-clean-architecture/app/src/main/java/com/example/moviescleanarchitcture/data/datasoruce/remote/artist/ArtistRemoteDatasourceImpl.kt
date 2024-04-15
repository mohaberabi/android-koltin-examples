package com.example.moviescleanarchitcture.data.datasoruce.remote.artist

import com.example.moviescleanarchitcture.data.api.AppApiService
import com.example.moviescleanarchitcture.data.model.artist.TredningArtists
import retrofit2.Response

class ArtistRemoteDatasourceImpl(
    private val apiService: AppApiService,
    private val api: String,
) :
    ArtistRemoteDataSource {

    override suspend fun getArtists(): Response<TredningArtists> =
        apiService.getTrendingArtists(api)
}