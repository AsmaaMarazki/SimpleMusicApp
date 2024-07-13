package com.vama.albums.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vama.albums.details.presentation.ui.screen.AlbumDetailsScreen
import com.vama.albums.home.presentation.ui.screen.AlbumsFeedHomeScreen

@Composable
fun AlbumsNavHost(startScreen: String = AlbumsScreensRoutes.AlbumsFeedScreenRoute.route) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startScreen) {

        composable(AlbumsScreensRoutes.AlbumsFeedScreenRoute.route) {
            AlbumsFeedHomeScreen(navController)
        }
        composable(
            AlbumsScreensRoutes.AlbumDetailsScreenRoute.route,
            arguments = listOf(navArgument(Arguments.ALBUM_ID) {
                type = NavType.StringType
            })
        ) {
            AlbumDetailsScreen(albumId = it.arguments?.getString(Arguments.ALBUM_ID)) {
                navController.popBackStack()
            }
        }
    }
}