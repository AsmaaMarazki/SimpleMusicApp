package com.vama.albums.details.domain.repository

import com.vama.albums.details.domain.model.AlbumDetailsModel

interface AlbumDetailsRepository {
    suspend fun getAlbumDetails(albumId: String): AlbumDetailsModel?
}