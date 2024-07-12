package com.vama.albums.home.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vama.albums.home.domain.usecase.GetAlbumsFeedUseCase
import com.vama.albums.home.presentation.model.AlbumsFeedEvent
import com.vama.albums.home.presentation.model.AlbumsFeedState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel @Inject constructor(private val getAlbumsFeedUseCase: GetAlbumsFeedUseCase) :
    ViewModel() {
    private val _albumsFeedHomeState =
        MutableStateFlow<AlbumsFeedState>(AlbumsFeedState.Loading)

    val albumsFeedHomeState: StateFlow<AlbumsFeedState> = _albumsFeedHomeState

    fun onTriggerEvent(event: AlbumsFeedEvent) {
        when (event) {
            AlbumsFeedEvent.GET_ALBUMS_FEED -> getAlbumsFeed()
        }
    }

    private fun getAlbumsFeed() {
        viewModelScope.launch {
            _albumsFeedHomeState.emit(AlbumsFeedState.Loading)
            try {
                val albums = getAlbumsFeedUseCase()
                Log.d("ALBUMS:SUCCESS:", albums.toString())
                _albumsFeedHomeState.value = AlbumsFeedState.Success(albums.albums)
            } catch (e: Exception) {
                Log.d("ALBUMS:ERROR:", e.message ?: "")
                _albumsFeedHomeState.value = AlbumsFeedState.Error(e.message ?: "")

            }
        }
    }
}