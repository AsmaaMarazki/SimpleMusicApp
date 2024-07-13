package com.vama.database

import com.vama.database.albums.doa.AlbumsLocalDataSource
import com.vama.database.albums.doa.AlbumsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun providesRealmDatabase(): Realm {
        return Realm.open(
            DatabaseHelper.realmConfiguration
        )
    }

    @Provides
    @Singleton
    fun providesAlbumsDoa(
        db: Realm
    ): AlbumsLocalDataSource = AlbumsLocalDataSourceImpl(db)
}