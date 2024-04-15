package com.example.contactsapp.data.database

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactsapp.data.model.Contact
import kotlinx.coroutines.InternalCoroutinesApi


@Database(
    entities = [Contact::class], version = 1,
    exportSchema = false
)
abstract class ContactDatabase : RoomDatabase() {

    abstract val contactsDao: ContactsDao


    companion object {


        private const val dbName = "contactsDb.db"

        //volatile is for allowing thread safety and mutiple  threads can access the instance
        @Volatile

        private var INSTANCE: ContactDatabase? = null


        fun getInstance(context: Context): ContactDatabase {
            synchronized(this) {

                var instance: ContactDatabase? = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        dbName
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }

        }

    }

}