package com.example.newsapp.features.news.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.core.util.NetworkConnectionChecker
import com.example.newsapp.features.news.domain.usecase.GetNewsUseCase

class NewsViewModelFactory(
    private val getNewsUseCase: GetNewsUseCase,
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            return NewsViewModel(getNewsUseCase) as T

        }
        throw IllegalArgumentException("ERROR")
    }
}