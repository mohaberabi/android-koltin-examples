package com.example.newsapp.features.news.domain.usecase

import com.example.newsapp.features.news.domain.repository.NewsRepository

class GetNewsUseCase(
    private val newsRepository: NewsRepository
) {

    suspend fun execute(

        country: String, page: Int

    ) = newsRepository.getNews(country, page)
}