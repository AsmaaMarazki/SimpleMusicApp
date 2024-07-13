package com.vama.database.albums.details.doa

import com.vama.database.albums.entity.AlbumEntity
import io.realm.kotlin.Realm
import javax.inject.Inject

class AlbumDetailsLocalDataSourceImpl @Inject constructor(private val realm: Realm) :
    AlbumDetailsLocalDataSource {
    override suspend fun getAlbum(albumId: String): AlbumEntity? {
        return realm.query(AlbumEntity::class, "id == $0", albumId).first().find()
    }
}