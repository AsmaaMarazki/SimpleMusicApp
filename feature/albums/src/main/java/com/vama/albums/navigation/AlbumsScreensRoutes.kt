package com.vama.albums.navigation

sealed class AlbumsScreensRoutes(val route: String) {
    data object AlbumsFeedScreenRoute : AlbumsScreensRoutes("albumsHomeScreen")
    data object AlbumDetailsScreenRoute :
        AlbumsScreensRoutes("albumDetailsScreen")

}

object Arguments {
    const val ALBUM_ID = "albumId"
}