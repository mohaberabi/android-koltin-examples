package com.example.newsapp.features.news.domain.usecase

import com.example.newsapp.features.news.data.model.Article
import com.example.newsapp.features.news.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(
    private val newsRepository: NewsRepository
) {

    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}