package com.vama.albums.details.presentation.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vama.albums.details.presentation.model.AlbumDetailsEvent
import com.vama.albums.details.presentation.model.AlbumDetailsState
import com.vama.albums.details.presentation.ui.topbar.AlbumDetailsTopBar
import com.vama.albums.details.presentation.ui.error.AlbumDetailsErrorView
import com.vama.albums.details.presentation.viewmodel.AlbumDetailsViewModel
import com.vama.ui.loading.FullScreenCircularLoading

@Composable
fun AlbumDetailsScreen(
    albumId: String?,
    albumDetailsViewModel: AlbumDetailsViewModel = hiltViewModel(), onBackClicked: () -> Unit
) {
    LaunchedEffect(Unit) {
        albumDetailsViewModel.onTriggerEvent(AlbumDetailsEvent.GetAlbumDetails(albumId))
    }
    Scaffold(topBar = { AlbumDetailsTopBar(onBackClicked) }) {
        Box(modifier = Modifier.padding(it)) {
            when (val state =
                albumDetailsViewModel.albumDetailsState.collectAsStateWithLifecycle().value) {
                is AlbumDetailsState.Loading -> {
                    FullScreenCircularLoading()
                }

                is AlbumDetailsState.Success -> {
                    AlbumDetailsView(state.albumDetailsModel)
                }

                is AlbumDetailsState.Error -> {
                    AlbumDetailsErrorView(
                        message = stringResource(id = state.message),
                        onBackClicked
                    )
                }
            }
        }
    }


}

