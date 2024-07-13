package com.vama.albums.home.data.repository

import com.vama.albums.home.data.mapper.AlbumsFeedMapper
import com.vama.albums.home.data.source.remote.AlbumsRemoteDataSource
import com.vama.albums.home.domain.model.AlbumModel
import com.vama.albums.home.domain.repository.AlbumsFeedRepository
import com.vama.database.albums.home.doa.AlbumsLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AlbumsFeedRepositoryImpl(
    private val albumsRemoteDataSource: AlbumsRemoteDataSource,
    private val albumsFeedMapper: AlbumsFeedMapper,
    private val albumsLocalDataSource: AlbumsLocalDataSource
) : AlbumsFeedRepository {

    override suspend fun getAlbumsFeed(): Flow<List<AlbumModel>?> {
        return flow {
            val savedAlbums = albumsLocalDataSource.getAlbums()
            if (savedAlbums != null) {
                emit(albumsFeedMapper.mapFrom(savedAlbums))
            }
            val feedResponse = albumsRemoteDataSource.getAlbumsFeed().albumsFeedDto
            val albumsResponse = feedResponse?.albums
            if (feedResponse == null || albumsResponse.isNullOrEmpty()) {
                albumsLocalDataSource.clear()
                emit(null)
            } else {
                albumsLocalDataSource.insertAlbums(
                    albumEntities = albumsFeedMapper.mapFrom(albumsResponse, feedResponse.copyright)
                )
                emit(albumsFeedMapper.mapFrom(feedResponse))
            }
        }
    }
}