package com.example.feature.cast.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.feature.cast.R

@Composable
fun CastItem(
    image: String?,
    name: String?,
    characterName: String?,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.7f)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
        ) {
            CastImage(image = image)
            name?.let {
                CastItemSection(titleId = R.string.cast_name_title, value = name)
            }
            characterName?.let {
                CastItemSection(titleId = R.string.character_name_title, value = characterName)
            }
        }
    }
}

@Preview
@Composable
fun CastItemPrev() {
    MoviesTheme {
        CastItem(image = "", name = "Name", characterName = "Character Name")
    }
}