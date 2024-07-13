package com.vama.albums.details.presentation.viewmodel

import app.cash.turbine.test
import com.vama.MainCoroutineScopeRule
import com.vama.albums.R
import com.vama.albums.details.domain.model.AlbumDetailsModel
import com.vama.albums.details.domain.usecase.GetAlbumDetailsUseCase
import com.vama.albums.details.presentation.model.AlbumDetailsEvent
import com.vama.albums.details.presentation.model.AlbumDetailsState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doAnswer
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class AlbumDetailsViewModelTest {
    @get:Rule
    val coroutineRule = MainCoroutineScopeRule()

    @Mock
    lateinit var getAlbumDetailsUseCase: GetAlbumDetailsUseCase

    private lateinit var albumDetailsViewModel: AlbumDetailsViewModel

    @Before
    fun setup() {
        albumDetailsViewModel = AlbumDetailsViewModel(
            getAlbumDetailsUseCase
        )
    }


    @Test
    fun getAlbumDetails_withValidAlbumId_expectedReturnSuccessOfAlbumDetailsModel() {
        runTest {
            //arrange
            val albumId = "123"
            val result = AlbumDetailsModel(
                name = "albumName",
                artist = "artistName",
                genre = "music",
                albumImageUrl = "/albumImageUrl",
                releaseDate = "11-11-2011",
                copyright = "Apple"
            )
            doAnswer { result }
                .whenever(getAlbumDetailsUseCase)
                .invoke(albumId)


            //assert
            albumDetailsViewModel.albumDetailsState.test {
                Assert.assertEquals(AlbumDetailsState.Loading, awaitItem())
                cancelAndIgnoreRemainingEvents()
            }

            //act
            albumDetailsViewModel.onTriggerEvent(AlbumDetailsEvent.GetAlbumDetails(albumId))
            advanceUntilIdle()

            //assert
            albumDetailsViewModel.albumDetailsState.test {
                val item = awaitItem()
                Assert.assertTrue(item is AlbumDetailsState.Success)
                Assert.assertEquals((item as AlbumDetailsState.Success).albumDetailsModel, result)
                cancelAndIgnoreRemainingEvents()
            }

            verify(getAlbumDetailsUseCase, times(1)).invoke(albumId)
        }
    }

    @Test
    fun getAlbumDetails_withValidAlbumIdNotExist_expectedReturnError() {
        runTest {
            //arrange
            val albumId = "1"

            doAnswer { null }
                .whenever(getAlbumDetailsUseCase)
                .invoke(albumId)


            //assert
            albumDetailsViewModel.albumDetailsState.test {
                Assert.assertEquals(AlbumDetailsState.Loading, awaitItem())
                cancelAndIgnoreRemainingEvents()
            }

            //act
            albumDetailsViewModel.onTriggerEvent(AlbumDetailsEvent.GetAlbumDetails(albumId))
            advanceUntilIdle()

            //assert
            albumDetailsViewModel.albumDetailsState.test {
                val item = awaitItem()
                Assert.assertTrue(item is AlbumDetailsState.Error)
                Assert.assertEquals(
                    (item as AlbumDetailsState.Error).message,
                    R.string.album_details_error_empty_message
                )
                cancelAndIgnoreRemainingEvents()
            }

            verify(getAlbumDetailsUseCase, times(1)).invoke(albumId)
        }
    }

    @Test
    fun getAlbumDetails_withInValidAlbumId_expectedReturnError() {
        runTest {
            //arrange
            val albumId = ""

            //assert
            albumDetailsViewModel.albumDetailsState.test {
                Assert.assertEquals(AlbumDetailsState.Loading, awaitItem())
                cancelAndIgnoreRemainingEvents()
            }

            //act
            albumDetailsViewModel.onTriggerEvent(AlbumDetailsEvent.GetAlbumDetails(albumId))
            advanceUntilIdle()

            //assert
            albumDetailsViewModel.albumDetailsState.test {
                val item = awaitItem()
                Assert.assertTrue(item is AlbumDetailsState.Error)
                Assert.assertEquals(
                    (item as AlbumDetailsState.Error).message,
                    R.string.album_details_error_invalid_message
                )
                cancelAndIgnoreRemainingEvents()
            }

            verify(getAlbumDetailsUseCase, times(0)).invoke(albumId)
        }
    }

    @Test
    fun getAlbumDetails_withValidAlbumIdButErrorOccur_expectedReturnError() {
        runTest {
            //arrange
            val albumId = "123"

            doAnswer { RuntimeException("error") }
                .whenever(getAlbumDetailsUseCase)
                .invoke(albumId)


            //assert
            albumDetailsViewModel.albumDetailsState.test {
                Assert.assertEquals(AlbumDetailsState.Loading, awaitItem())
                cancelAndIgnoreRemainingEvents()
            }

            //act
            albumDetailsViewModel.onTriggerEvent(AlbumDetailsEvent.GetAlbumDetails(albumId))
            advanceUntilIdle()

            //assert
            albumDetailsViewModel.albumDetailsState.test {
                val item = awaitItem()
                Assert.assertTrue(item is AlbumDetailsState.Error)
                Assert.assertEquals(
                    (item as AlbumDetailsState.Error).message,
                    R.string.error_general_message
                )
                cancelAndIgnoreRemainingEvents()
            }

            verify(getAlbumDetailsUseCase, times(1)).invoke(albumId)
        }
    }

}