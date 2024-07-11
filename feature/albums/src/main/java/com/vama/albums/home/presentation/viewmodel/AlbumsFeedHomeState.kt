package com.vama.albums.home.presentation.viewmodel

import com.vama.albums.home.domain.model.AlbumModel

sealed class AlbumsFeedHomeState {
    data object Loading : AlbumsFeedHomeState()
    class Success (val albums: List<AlbumModel>): AlbumsFeedHomeState()
    class Error(val message: String): AlbumsFeedHomeState()

}
