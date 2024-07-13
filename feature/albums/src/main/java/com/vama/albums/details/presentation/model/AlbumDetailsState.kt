package com.vama.albums.details.presentation.model

import androidx.annotation.StringRes
import com.vama.albums.details.domain.model.AlbumDetailsModel

sealed class AlbumDetailsState {
    data object Loading : AlbumDetailsState()
    class Error(@StringRes val message: Int) : AlbumDetailsState()
    class Success(val albumDetailsModel: AlbumDetailsModel) : AlbumDetailsState()
}