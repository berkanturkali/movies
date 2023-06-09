package com.example.movies.feature.search.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.icon.MoviesIcons
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun SearchItem(
    image: String?,
    name: String,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    val interactionSource = remember { MutableInteractionSource() }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        ),

        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(16.dp)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    onItemClick()
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = if (image == null) Arrangement.SpaceAround else Arrangement.spacedBy(
                12.dp
            )
        ) {
            //image
            image?.let {
                Poster(
                    image = image,
                    modifier = Modifier
                        .weight(2f)
                )
            }
            //name
            Name(
                name = name, modifier = Modifier
                    .then(Modifier.weight(2f))
            )

            Icon(
                painter = painterResource(id = MoviesIcons.PLAY),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Preview
@Composable
fun SearchItemPrev() {
    MoviesTheme {
        SearchItem(image = null, name = "Sonnenfeld Josephson Worldwide Entertainment ", onItemClick = {})
    }
}