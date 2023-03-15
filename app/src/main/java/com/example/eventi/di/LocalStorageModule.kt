package com.example.eventi.di

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

    private const val REALM_VERSION = 0L
    @Provides
    @Singleton
    fun provideRealmConfig(): RealmConfiguration {
        return RealmConfiguration.Builder()
            .name("eventi.db")
            .schemaVersion(REALM_VERSION)
            .deleteRealmIfMigrationNeeded()
            .compactOnLaunch()
            .build()
    }

    @Provides
    fun provideRealm(configuration: RealmConfiguration): Realm {
        return Realm.getInstance(configuration)
    }

}