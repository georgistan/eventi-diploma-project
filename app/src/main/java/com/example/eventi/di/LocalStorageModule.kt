package com.example.eventi.di

import com.example.eventi.data.EntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalStorageModule {

    @Provides
    @Singleton
    fun provideRealm(): Realm {
        val config = RealmConfiguration.Builder()
            .name("eventi.db")
            .allowQueriesOnUiThread(true)
            .allowWritesOnUiThread(true)
            .schemaVersion(1)
            .build()

        Realm.setDefaultConfiguration(config)

        return Realm.getDefaultInstance()
    }

    @Provides
    @Singleton
    fun provideEntityMapper(): EntityMapper = EntityMapper()

}