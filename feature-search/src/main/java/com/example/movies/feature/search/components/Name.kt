package com.example.movies.feature.search.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun Name(
    name: String,
    modifier: Modifier = Modifier,
    childModifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
) {

    Text(
        text = name,
        modifier = modifier.then(childModifier),
        color = MaterialTheme.colorScheme.onPrimary,
        style = MaterialTheme.typography.bodyMedium,
        maxLines = 3,
        overflow = TextOverflow.Ellipsis,
        textAlign = textAlign
    )

}

@Preview
@Composable
fun NamePrev() {
    MoviesTheme {
        Name(
            name = "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
                    " sed do eiusmod tempor incididunt" +
                    " ut labore et dolore magna aliqua." +
                    " Ut enim ad minim veniam, quis nostrud exercitation ullamco"
        )
    }
}