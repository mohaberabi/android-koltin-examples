package com.example.hiltexample

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DataModule {


    @Provides
    fun providesDatasource(): Datasource {

        return Datasource()
    }
}