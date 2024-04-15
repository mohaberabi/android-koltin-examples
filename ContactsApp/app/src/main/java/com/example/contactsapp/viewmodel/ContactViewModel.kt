package com.example.contactsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactsapp.data.model.Contact
import com.example.contactsapp.repository.ContactRepository
import com.example.contactsapp.util.SingleLifeEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContactViewModel(
    private val contactRepository: ContactRepository
) : ViewModel() {


    val contacts = contactRepository.contacts

    val inputName = MutableLiveData("")

    val inputEmail = MutableLiveData("")

    private val choosedContact = MutableLiveData<Contact?>(null)

    val saveOrUpdateButton = MutableLiveData("Save")
    val clearOrDeleteButton = MutableLiveData("Clear All")


    private val _statusMessage = MutableLiveData<SingleLifeEvent<String>>()

    val statusMessage: LiveData<SingleLifeEvent<String>>
        get() = _statusMessage

    fun chooseContact(contact: Contact) {
        choosedContact.value = contact
    }


    fun insertContact() {

        if (inputName.value!!.isEmpty() || inputEmail.value!!.isEmpty()) {

            _statusMessage.value = SingleLifeEvent("Please enter needed inputs")
        } else {
            viewModelScope.launch(Dispatchers.IO) {
                val name = inputName.value!!
                val email = inputEmail.value!!
                contactRepository.insertContact(Contact(0, name, email))
                withContext(Dispatchers.Main) {
                    _statusMessage.value = SingleLifeEvent("DATA SAVED")
                }
            }

        }
    }

    fun deleteContact(contact: Contact) =
        viewModelScope.launch(Dispatchers.IO) {
            contactRepository.deleteContact(contact)
        }

    private fun updateContact(contact: Contact) =
        viewModelScope.launch(Dispatchers.IO) {
            contactRepository.updateContact(contact)
            _statusMessage.value = SingleLifeEvent("DATA SAVED")
        }


    fun clearAllContacts() =
        viewModelScope.launch(Dispatchers.IO) {
            contactRepository.deleteAll()
        }

//    fun clearContact() {
//        choosedContact.value = null
//    }
//
//    private fun clearFormField() {
//        inputEmail.value = ""
//        inputEmail.value = ""
//    }
}