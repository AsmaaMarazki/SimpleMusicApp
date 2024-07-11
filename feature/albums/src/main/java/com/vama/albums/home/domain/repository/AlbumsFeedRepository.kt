package com.vama.albums.home.domain.repository

import com.vama.albums.home.domain.model.AlbumModel

interface AlbumsFeedRepository {
    suspend fun getAlbumsFeed(): List<AlbumModel>
}