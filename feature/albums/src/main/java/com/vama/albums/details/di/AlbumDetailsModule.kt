package com.vama.albums.details.di

import com.vama.albums.details.data.mapper.AlbumDetailsMapper
import com.vama.albums.details.data.repository.AlbumDetailsRepositoryImpl
import com.vama.albums.details.domain.repository.AlbumDetailsRepository
import com.vama.albums.details.domain.usecase.GetAlbumDetailsUseCase
import com.vama.database.albums.details.doa.AlbumDetailsLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(ViewModelComponent::class)
class AlbumDetailsModule {

    @Provides
    @ViewModelScoped
    fun providesGetAlbumDetailsUseCase(
        repository: AlbumDetailsRepository,
        ioDispatcher: CoroutineDispatcher
    ) = GetAlbumDetailsUseCase(repository, ioDispatcher)

    @Provides
    @ViewModelScoped
    fun providesAlbumDetailsRepository(
        albumDetailsLocalDataSource: AlbumDetailsLocalDataSource,
        mapper: AlbumDetailsMapper
    ): AlbumDetailsRepository = AlbumDetailsRepositoryImpl(albumDetailsLocalDataSource, mapper)
}