package com.example.newsapp.features.news.domain.usecase

import com.example.newsapp.features.news.domain.repository.NewsRepository

class SearchNewsUseCase(
    private val newsRepository: NewsRepository
) {


    suspend fun execute(q: String) = newsRepository.searchNews(q)
}