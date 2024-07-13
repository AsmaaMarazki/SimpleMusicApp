package com.vama.database.albums.doa

import com.vama.database.albums.entity.AlbumEntity
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy

internal class AlbumsLocalDataSourceImpl(private val realm: Realm) : AlbumsLocalDataSource {
    override suspend fun insertAlbums(albumEntities: List<AlbumEntity>) {
        realm.write {
            albumEntities.forEach { copyToRealm(it, UpdatePolicy.ALL) }
        }
    }

    override suspend fun getAlbums(): List<AlbumEntity>? {
        val albums = realm.query(AlbumEntity::class).find()
        return if (albums.isEmpty())
            null
        else albums
    }

    override suspend fun clear() {
        realm.write {
            delete(AlbumEntity::class)
        }
    }

}