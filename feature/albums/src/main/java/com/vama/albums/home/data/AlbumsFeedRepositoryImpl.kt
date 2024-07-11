package com.vama.albums.home.data

import com.vama.albums.home.data.source.remote.AlbumsRemoteDataSource
import com.vama.albums.home.domain.model.AlbumModel
import com.vama.albums.home.domain.repository.AlbumsFeedRepository

class AlbumsFeedRepositoryImpl(private val albumsRemoteDataSource: AlbumsRemoteDataSource) :
    AlbumsFeedRepository {
    override suspend fun getAlbumsFeed(): List<AlbumModel> {
        TODO("Not yet implemented")
    }
}