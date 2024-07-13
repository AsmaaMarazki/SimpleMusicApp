package com.vama.database.albums.details.doa

import com.vama.database.albums.entity.AlbumEntity

interface AlbumDetailsLocalDataSource {
    suspend fun getAlbum(albumId: String): AlbumEntity?

}