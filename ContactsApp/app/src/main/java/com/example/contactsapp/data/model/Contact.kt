package com.example.contactsapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val email: String
)
