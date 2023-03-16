package com.example.eventi.di

import com.example.eventi.data.EntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object EntityMapperModule {

    @Provides
    @Singleton
    fun provideEntityMapper(): EntityMapper = EntityMapper()

}