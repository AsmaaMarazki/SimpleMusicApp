package com.vama.musicapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vama.albums.navigation.AlbumsNavHost

@Composable
fun VamaMusicNavHost(startScreen: String = VamaScreensRoutes.HOME_SCREEN) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startScreen) {

        composable(VamaScreensRoutes.HOME_SCREEN) {
            AlbumsNavHost()
        }

    }
}