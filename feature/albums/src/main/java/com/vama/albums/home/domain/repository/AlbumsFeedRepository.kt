package com.vama.albums.home.domain.repository

import com.vama.albums.home.domain.model.AlbumsFeedModel

interface AlbumsFeedRepository {
    suspend fun getAlbumsFeed(): AlbumsFeedModel
}