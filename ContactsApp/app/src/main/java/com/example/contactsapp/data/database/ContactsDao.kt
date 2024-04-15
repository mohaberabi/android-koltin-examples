package com.example.contactsapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.contactsapp.data.model.Contact

@Dao

interface ContactsDao {


    @Insert
    suspend fun insertContact(contact: Contact): Long


    @Update
    suspend fun updateContact(contact: Contact)


    @Delete
    suspend fun deleteContact(contact: Contact)


    @Query("DELETE FROM contacts ")
    suspend fun deleteAll()

    @Query("SELECT * FROM contacts")
    fun listenToAllContacts(): LiveData<List<Contact>>

}