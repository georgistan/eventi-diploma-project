package com.example.eventi.di

import com.example.eventi.data.EntityMapper
import com.example.eventi.data.network.EventApi
import com.example.eventi.repository.events.EventRepository
import com.example.eventi.repository.events.EventRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(
        eventApi: EventApi,
        mapper: EntityMapper
    ): EventRepository {
        return EventRepositoryImpl(eventApi, mapper)
    }

}