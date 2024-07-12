package com.vama.albums.home.data

import com.vama.albums.home.data.mapper.AlbumsFeedMapper
import com.vama.albums.home.data.source.remote.AlbumsRemoteDataSource
import com.vama.albums.home.domain.model.AlbumsFeedModel
import com.vama.albums.home.domain.repository.AlbumsFeedRepository

class AlbumsFeedRepositoryImpl(private val albumsRemoteDataSource: AlbumsRemoteDataSource,private  val albumsFeedMapper: AlbumsFeedMapper) :
    AlbumsFeedRepository {

    override suspend fun getAlbumsFeed(): AlbumsFeedModel {
        return albumsFeedMapper.mapFrom(albumsRemoteDataSource.getAlbumsFeed())
    }
}