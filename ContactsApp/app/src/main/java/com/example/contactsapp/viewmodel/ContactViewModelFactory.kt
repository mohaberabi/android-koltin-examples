package com.example.contactsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.contactsapp.repository.ContactRepository

class ContactViewModelFactory(
    private val contactsRepository: ContactRepository
) :
    ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactViewModel::class.java)) {
            return ContactViewModel(contactsRepository) as T
        }
        throw IllegalArgumentException("ERROR")
    }
}