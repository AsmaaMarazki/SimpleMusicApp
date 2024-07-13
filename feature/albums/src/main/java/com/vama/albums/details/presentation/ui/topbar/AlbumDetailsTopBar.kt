package com.vama.albums.details.presentation.ui.topbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.vama.albums.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlbumDetailsTopBar(onBackClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text(stringResource(id = R.string.album_details_topbar_title))
        }, navigationIcon = {
            IconButton(onClick = onBackClicked) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
        })
}

@Preview
@Composable
fun AlbumDetailsMapperTopBarPreview() {
    AlbumDetailsTopBar {}
}