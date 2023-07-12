package com.example.movies.feature.details.movie.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailsListSection(
    @StringRes sectionTitleId: Int,
    content: @Composable (() -> Unit),
    modifier: Modifier = Modifier,
    count: Int? = null,
    showSeeAllContent: Boolean = false,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {
            SectionTitle(
                titleId = sectionTitleId,
            )
            if (showSeeAllContent) {
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    SeeAllButton(onItemClick = {})
                    count?.let {
                        Text(
                            text = "($count)",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.offset(y = 3.dp)
                        )
                    }
                }
            }
        }
        content()
    }


}