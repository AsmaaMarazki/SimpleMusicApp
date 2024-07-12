package com.vama.albums.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vama.albums.home.presentation.ui.screen.AlbumsFeedHomeScreen

@Composable
fun AlbumsNavHost(startScreen: String = AlbumsScreensRoutes.ALBUMS_HOME_SCREEN) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startScreen) {

        composable(AlbumsScreensRoutes.ALBUMS_HOME_SCREEN) {
            AlbumsFeedHomeScreen()
        }
    }
}