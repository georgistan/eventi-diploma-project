package com.example.eventi.di

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.example.eventi.RecentInterests
import com.example.eventi.repository.interests.LocalStorageRepository
import com.example.eventi.repository.interests.LocalStorageRepositoryImpl
import com.google.protobuf.InvalidProtocolBufferException
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.io.InputStream
import java.io.OutputStream

@Module
@InstallIn(SingletonComponent::class)
class LocalStorageModule {

    @Suppress("BlockingMethodInNonBlockingContext")
    object RecentInterestsSerializer : Serializer<RecentInterests> {
        override val defaultValue: RecentInterests = RecentInterests.getDefaultInstance()

        override suspend fun readFrom(input: InputStream): RecentInterests {
            try {
                return RecentInterests.parseFrom(input)
            } catch (exception: InvalidProtocolBufferException) {
                throw CorruptionException("Cannot read proto.", exception)
            } catch (e: java.io.IOException) {
                e.printStackTrace()
                throw e
            }
        }

        override suspend fun writeTo(t: RecentInterests, output: OutputStream) = t.writeTo(output)
    }

    private val Context.recentInterestsDataStore: DataStore<RecentInterests> by dataStore(
        fileName = "RecentInterests.pb",
        serializer = RecentInterestsSerializer
    )

    @Provides
    @Reusable
    fun provideProtoDataStore(@ApplicationContext context: Context) =
        context.recentInterestsDataStore

    @Provides
    @Reusable
    internal fun providesDataRepository(
        @ApplicationContext context: Context,
        RecentInterestsDataStore: DataStore<RecentInterests>
    ): LocalStorageRepository {
        return LocalStorageRepositoryImpl(
            context,
            RecentInterestsDataStore
        )
    }
}