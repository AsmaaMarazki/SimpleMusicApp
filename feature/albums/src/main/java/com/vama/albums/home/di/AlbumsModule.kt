package com.vama.albums.home.di

import com.vama.albums.home.data.repository.AlbumsFeedRepositoryImpl
import com.vama.albums.home.data.mapper.AlbumsFeedMapper
import com.vama.database.albums.doa.AlbumsLocalDataSource
import com.vama.albums.home.data.source.remote.AlbumsRemoteDataSource
import com.vama.albums.home.data.source.remote.AlbumsServiceApi
import com.vama.albums.home.domain.repository.AlbumsFeedRepository
import com.vama.albums.home.domain.usecase.GetAlbumsFeedUseCase
import com.vama.network.NetworkManger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ViewModelComponent::class)
class AlbumsModule {

    @ViewModelScoped
    @Provides
    fun provideAlbumsService() = NetworkManger.createService(AlbumsServiceApi::class.java)

    @ViewModelScoped
    @Provides
    fun providesAlbumsFeedRepository(
        albumsRemoteDataSource: AlbumsRemoteDataSource,
        mapper: AlbumsFeedMapper,
        albumsLocalDataSource: AlbumsLocalDataSource
    ): AlbumsFeedRepository =
        AlbumsFeedRepositoryImpl(albumsRemoteDataSource, mapper, albumsLocalDataSource)

    @ViewModelScoped
    @Provides
    fun providesGetAlbumsFeedUseCase(
        albumsFeedRepository: AlbumsFeedRepository,
        dispatcher: CoroutineDispatcher
    ) = GetAlbumsFeedUseCase(albumsFeedRepository, dispatcher)

    @ViewModelScoped
    @Provides
    fun providesIoDispatcher() = Dispatchers.IO
}