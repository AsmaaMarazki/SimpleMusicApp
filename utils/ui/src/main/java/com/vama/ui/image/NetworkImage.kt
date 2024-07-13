package com.vama.ui.image

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage

@Composable
fun NetworkImage(
    url: String?,
    modifier: Modifier = Modifier,
    contentDescription: String? = "",
    contentScale: ContentScale = ContentScale.Inside,
    placeholderColor: Painter = ColorPainter(Color.Gray)
) {
    AsyncImage(
        modifier = modifier,
        model = url,
        contentDescription = contentDescription,
        placeholder = placeholderColor,
        contentScale = contentScale
    )
}

@Preview
@Composable
fun NetworkImagePreview() {
    NetworkImage("https://is1-ssl.mzstatic.com/image/thumb/Music211/v4/2e/14/d4/2e14d494-34c3-d6ee-2189-9710afff7906/093624839996.jpg/100x100bb.jpg")
}