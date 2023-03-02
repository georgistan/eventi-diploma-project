package com.example.eventi.di

import com.example.eventi.data.network.events.EventApi
import com.example.eventi.data.network.model.EntityMapper
import com.example.eventi.repository.events.EventRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(eventApi: EventApi): EventRepositoryImpl {
        return EventRepositoryImpl(eventApi)
    }

}