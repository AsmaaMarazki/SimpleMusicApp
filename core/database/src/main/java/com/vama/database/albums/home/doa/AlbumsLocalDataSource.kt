package com.vama.database.albums.home.doa

import com.vama.database.albums.entity.AlbumEntity

interface AlbumsLocalDataSource {
    suspend fun insertAlbums(albumEntities: List<AlbumEntity>)
    suspend fun getAlbums(): List<AlbumEntity>?
    suspend fun clear()

}

