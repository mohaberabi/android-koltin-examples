package com.example.newsapp

import com.example.newsapp.features.news.data.api.ArticleService
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArticleApiServiceTest {

    private lateinit var service: ArticleService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder().baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ArticleService::class.java)

    }

    private fun enqMockResponse(name: String) {
        val inputStream = javaClass.classLoader.getResourceAsStream(name)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun `returns response correctly`(): Unit = runBlocking {
        enqMockResponse("newsresponse.json")
        val body = service.getTopHeadlines("us", 1).body()
        val request = server.takeRequest()

        Truth.assertThat(body).isNotNull()


    }

    @Test
    fun `returns response correctly with the correct page size `(): Unit = runBlocking {
        enqMockResponse("newsresponse.json")
        val body = service.getTopHeadlines("us", 1).body()
        val list = body!!.articles
        Truth.assertThat(list.size).isEqualTo(20)


    }

}