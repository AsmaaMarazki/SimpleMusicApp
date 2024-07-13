package com.vama.albums.details.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vama.albums.R
import com.vama.albums.details.domain.usecase.GetAlbumDetailsUseCase
import com.vama.albums.details.presentation.model.AlbumDetailsEvent
import com.vama.albums.details.presentation.model.AlbumDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumDetailsViewModel @Inject constructor(private val getAlbumDetailsUseCase: GetAlbumDetailsUseCase) :
    ViewModel() {
    private val _albumDetailsState = MutableStateFlow<AlbumDetailsState>(AlbumDetailsState.Loading)
    val albumDetailsState: StateFlow<AlbumDetailsState> = _albumDetailsState

    fun onTriggerEvent(event: AlbumDetailsEvent) {
        when (event) {
            is AlbumDetailsEvent.GetAlbumDetails -> getAlbumDetails(event.albumId)
        }
    }

    private fun getAlbumDetails(albumId: String?) {
        viewModelScope.launch {
            if (albumId.isNullOrEmpty()) {
                _albumDetailsState.emit(AlbumDetailsState.Error(R.string.album_details_error_invalid_message))
            } else {
                try {
                    val albumDetails = getAlbumDetailsUseCase(albumId)
                    if (albumDetails == null)
                        _albumDetailsState.emit(AlbumDetailsState.Error(R.string.album_details_error_empty_message))
                    else
                        _albumDetailsState.emit(AlbumDetailsState.Success(albumDetails))

                } catch (e: Exception) {
                    _albumDetailsState.emit(AlbumDetailsState.Error(R.string.error_general_message))
                }
            }
        }
    }


}