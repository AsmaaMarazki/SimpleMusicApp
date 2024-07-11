package com.vama.albums.home.data.source.remote

import javax.inject.Inject

class AlbumsRemoteDataSource @Inject constructor(private val albumsService: AlbumsServiceApi) {
    suspend fun getAlbumsFeed() = albumsService.getAlbumsFeed()
}