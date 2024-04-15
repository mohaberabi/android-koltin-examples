package com.example.contactsapp.util

open class SingleLifeEvent<out T>(private val content: T) {


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