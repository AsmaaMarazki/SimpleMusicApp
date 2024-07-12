package com.vama.albums.home.presentation.model

import com.vama.albums.home.domain.model.AlbumModel

sealed class AlbumsFeedState {
    data object Loading : AlbumsFeedState()
    class Success (val albums: List<AlbumModel>): AlbumsFeedState()
    class Error(val message: String): AlbumsFeedState()

}