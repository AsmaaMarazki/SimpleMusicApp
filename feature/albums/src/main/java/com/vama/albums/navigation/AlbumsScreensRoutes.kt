package com.vama.albums.navigation

import com.vama.albums.navigation.Arguments.ALBUM_ID
import com.vama.albums.navigation.Routes.ALBUMS_HOME_SCREEN
import com.vama.albums.navigation.Routes.ALBUM_DETAILS_SCREEN

sealed class AlbumsScreensRoutes(val route: String) {
    data object AlbumsFeedScreenRoute : AlbumsScreensRoutes(ALBUMS_HOME_SCREEN)
    data object AlbumDetailsScreenRoute :
        AlbumsScreensRoutes("$ALBUM_DETAILS_SCREEN{$ALBUM_ID}")

}
object Routes{
    const val ALBUMS_HOME_SCREEN = "albumsHomeScreen"
    const val ALBUM_DETAILS_SCREEN = "albumDetailsScreen/"
}
object Arguments {
    const val ALBUM_ID = "albumId"
}