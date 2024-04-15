package com.example.newsapp.features.news.domain.usecase

import com.example.newsapp.features.news.data.model.Article
import com.example.newsapp.features.news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(
    private val newsRepository: NewsRepository
) {

    fun execute(): Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }
}