package com.vama.albums.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vama.albums.home.domain.usecase.GetAlbumsFeedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AlbumsViewModel(private val getAlbumsFeedUseCase: GetAlbumsFeedUseCase) : ViewModel() {
    private val _albumsFeedHomeState =
        MutableStateFlow<AlbumsFeedHomeState>(AlbumsFeedHomeState.Loading)

    fun getAlbumsFeed() {
        viewModelScope.launch {
            try {
                val albums = getAlbumsFeedUseCase()
                _albumsFeedHomeState.value = AlbumsFeedHomeState.Success(albums)
            } catch (e: Exception) {
                _albumsFeedHomeState.value = AlbumsFeedHomeState.Error(e.message ?: "")
            }
        }
    }
}