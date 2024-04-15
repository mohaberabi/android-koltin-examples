package com.example.newsapp.features.news.presentation.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.core.util.AppResult
import com.example.newsapp.core.util.NetworkConnectionChecker
import com.example.newsapp.features.news.data.model.Article
import com.example.newsapp.features.news.data.model.NewsResponse
import com.example.newsapp.features.news.domain.usecase.GetNewsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(
    private val getNewsUseCase: GetNewsUseCase,
) : ViewModel() {


    val news = MutableLiveData<AppResult<NewsResponse>>()


    fun getNews(
        country: String, page: Int
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                news.postValue(AppResult.Loading())
                val res = getNewsUseCase.execute(country, page)
                news.postValue(res)

            } catch (e: Exception) {

                news.postValue(AppResult.Error("${e.message}"))

            }

        }
    }
}
