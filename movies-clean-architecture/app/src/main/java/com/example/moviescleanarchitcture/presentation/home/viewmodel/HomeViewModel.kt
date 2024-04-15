package com.example.moviescleanarchitcture.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviescleanarchitcture.core.utils.SingleLiveEvent


enum class HomeNavState {
    IDLE,
    MOVIES,
    ARTISTS
}

class HomeViewModel : ViewModel() {


    private val _navState = MutableLiveData<SingleLiveEvent<HomeNavState>>()

    val navState: LiveData<SingleLiveEvent<HomeNavState>>
        get() = _navState

    fun goToMovies() {
        _navState.value = SingleLiveEvent(HomeNavState.MOVIES)
    }


    fun goArtists() {
        _navState.value = SingleLiveEvent(HomeNavState.ARTISTS)
    }

}