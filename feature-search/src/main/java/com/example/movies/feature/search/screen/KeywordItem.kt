package com.example.movies.feature.search.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun KeywordItem(
    keyword: String,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }

    OutlinedButton(
        modifier = modifier.clickable(
            interactionSource = interactionSource,
            indication = null
        ) {},
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = MaterialTheme.colorScheme.surface,

            ),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 8.dp
        ),
        border = BorderStroke(
            0.5.dp,
            color = MaterialTheme.colorScheme.onSurface
        ),
        onClick = {},
        interactionSource = interactionSource,
        contentPadding = PaddingValues(
            horizontal = 8.dp,
            vertical = 4.dp
        )
    ) {
        Text(
            text = keyword,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun KeywordItemPrev() {
    MoviesTheme {
        KeywordItem(keyword = "Keyword")
    }
}