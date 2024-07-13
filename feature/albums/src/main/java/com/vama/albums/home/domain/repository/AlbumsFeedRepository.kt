package com.vama.albums.home.domain.repository

import com.vama.albums.home.domain.model.AlbumModel
import kotlinx.coroutines.flow.Flow

interface AlbumsFeedRepository {
    suspend fun getAlbumsFeed(): Flow<List<AlbumModel>?>
}