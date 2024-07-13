package com.vama.albums.details.data.repository

import com.vama.albums.details.data.mapper.AlbumDetailsMapper
import com.vama.albums.details.domain.model.AlbumDetailsModel
import com.vama.albums.details.domain.repository.AlbumDetailsRepository
import com.vama.database.albums.details.doa.AlbumDetailsLocalDataSource
import javax.inject.Inject

class AlbumDetailsRepositoryImpl @Inject constructor(
    private val albumDetailsLocalDataSource: AlbumDetailsLocalDataSource,
    private val mapper: AlbumDetailsMapper
) :
    AlbumDetailsRepository {
    override suspend fun getAlbumDetails(albumId: String): AlbumDetailsModel? {
        albumDetailsLocalDataSource.getAlbum(albumId)?.let {
            return mapper.mapFrom(it)
        }
        return null
    }
}