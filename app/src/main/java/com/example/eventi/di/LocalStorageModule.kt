//package com.example.eventi.di
//
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import io.realm.Realm
//import io.realm.RealmConfiguration
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object LocalStorageModule {
//
//    @Provides
//    @Singleton
//    fun provideRealmConfig(): RealmConfiguration {
//        return RealmConfiguration.Builder()
//            .name("eventi.db")
//            .allowQueriesOnUiThread(true)
//            .allowWritesOnUiThread(true)
//            .schemaVersion(1)
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideRealm(configuration: RealmConfiguration): Realm {
//        Realm.setDefaultConfiguration(configuration)
//        return Realm.getDefaultInstance()
//    }
//
//}