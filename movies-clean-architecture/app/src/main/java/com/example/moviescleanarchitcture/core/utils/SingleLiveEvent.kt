package com.example.moviescleanarchitcture.core.utils


open class SingleLiveEvent<out T>(private val content: T) {


    private var isDone = false

    fun getWhenNotDone(): T? {
        return if (isDone) {
            null
        } else {
            isDone = true
            content
        }
    }

    fun peekContent(): T = content
}