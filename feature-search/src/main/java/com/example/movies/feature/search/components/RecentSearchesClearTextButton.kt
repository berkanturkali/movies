package com.example.movies.feature.search.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies_compose.feature.search.R

@Composable
fun RecentSearchesClearTextButton(
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = { /*TODO clean up the history*/ },
        modifier = modifier
            .height(20.dp),
        contentPadding = PaddingValues(0.dp),
        shape = CircleShape,
        colors = ButtonDefaults.textButtonColors(
            containerColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.4f),
            contentColor = MaterialTheme.colorScheme.onPrimary,
        )
    ) {
        Text(
            text = stringResource(
                id = R.string.recent_searches_clear_text_button_text
            ),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun RecentSearchesClearTextButtonPrev() {
    MoviesTheme {
        RecentSearchesClearTextButton()
    }
}