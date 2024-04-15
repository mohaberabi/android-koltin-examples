package com.example.newsapp.features.news.domain.usecase

import com.example.newsapp.features.news.data.model.Article
import com.example.newsapp.features.news.domain.repository.NewsRepository

class SaveNewsUSeCase(
    private val newsRepository: NewsRepository,
) {

    suspend fun execute(vararg articles: Article) = newsRepository.saveNews(*articles)

}