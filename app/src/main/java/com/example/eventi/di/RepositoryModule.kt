package com.example.eventi.di

import com.example.eventi.data.EntityMapper
import com.example.eventi.data.network.EventApi
import com.example.eventi.repository.events.EventRepository
import com.example.eventi.repository.events.EventRepositoryImpl
import com.example.eventi.repository.interests.LocalStorageRepository
import com.example.eventi.repository.interests.LocalStorageRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideEventRepository(
        eventApi: EventApi,
        mapper: EntityMapper
    ): EventRepository {
        return EventRepositoryImpl(eventApi, mapper)
    }

    @Provides
    @Singleton
    fun provideLocalStorageRepository(
        realm: Provider<Realm>,
        mapper: EntityMapper,
        @DispatcherIO dispatcher: CoroutineDispatcher
    ): LocalStorageRepository {
        return LocalStorageRepositoryImpl(realm, mapper, dispatcher)
    }

}