package com.vama.albums.home.presentation.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.vama.albums.home.presentation.model.AlbumsFeedEvent
import com.vama.albums.home.presentation.model.AlbumsFeedState
import com.vama.albums.home.presentation.ui.error.AlbumsFeedErrorView
import com.vama.albums.home.presentation.ui.loading.AlbumsFeedLoadingView
import com.vama.albums.home.presentation.ui.topbar.AlbumsFeedTopBar
import com.vama.albums.home.presentation.viewmodel.AlbumsViewModel
import com.vama.albums.navigation.Routes.ALBUM_DETAILS_SCREEN

@Composable
fun AlbumsFeedHomeScreen(
    navController: NavHostController,
    albumsViewModel: AlbumsViewModel = hiltViewModel()
) {
    Scaffold(topBar = {
        AlbumsFeedTopBar()
    }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            LaunchedEffect(Unit) {
                albumsViewModel.onTriggerEvent(AlbumsFeedEvent.GET_ALBUMS_FEED)
            }
            when (val state =
                albumsViewModel.albumsFeedHomeState.collectAsStateWithLifecycle().value) {
                is AlbumsFeedState.Loading -> {
                    AlbumsFeedLoadingView()
                }

                is AlbumsFeedState.Success -> {
                    AlbumsFeedGridView(state.albums) {
                        navController.navigate("${ALBUM_DETAILS_SCREEN}${it}")
                    }
                }

                is AlbumsFeedState.Error -> {
                    AlbumsFeedErrorView(message = stringResource(id = state.message)) {
                        albumsViewModel.onTriggerEvent(AlbumsFeedEvent.GET_ALBUMS_FEED)
                    }
                }
            }
        }
    }
}

