package com.example.contactsapp.repository

import com.example.contactsapp.data.database.ContactsDao
import com.example.contactsapp.data.model.Contact

class ContactRepository(
    private val contactsDao: ContactsDao
) {


    val contacts = contactsDao.listenToAllContacts()


    suspend fun insertContact(contact: Contact) {
        contactsDao.insertContact(contact)
    }

    suspend fun updateContact(contact: Contact) {
        contactsDao.updateContact(contact)
    }

    suspend fun deleteContact(contact: Contact) {
        contactsDao.deleteContact(contact)
    }


    suspend fun deleteAll() {
        contactsDao.deleteAll()
    }


}