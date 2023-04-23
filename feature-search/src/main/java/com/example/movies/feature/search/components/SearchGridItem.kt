package com.example.movies.feature.search.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun SearchGridItem(
    image: String?,
    name: String,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(4.dp)
) {

    Column(
        modifier = modifier
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        //image
        Poster(image = image, shape = shape)

        //name
        Name(name = name, textAlign = TextAlign.Center)
    }
}

@Preview
@Composable
fun SearchGridItemPrev() {
    MoviesTheme {
        SearchGridItem(name = "fsadfsafasdf", image = "", onItemClick = {})
    }
}