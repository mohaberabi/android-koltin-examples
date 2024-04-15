package com.example.newsapp.core.util

sealed class AppResult<T>(
    val data: T? = null,

    val message: String? = null


) {


    class Done<T>(data: T) : AppResult<T>(data = data)
    class Loading<T>(data: T? = null) : AppResult<T>(data = data)
    class Error<T>(message: String, data: T? = null) : AppResult<T>(data = data, message = message)

}