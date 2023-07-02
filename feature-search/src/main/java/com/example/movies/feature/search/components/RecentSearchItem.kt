package com.example.movies.feature.search.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.icon.MoviesIcon
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.core.model.search.recentsearch.RecentSearch

@Composable
fun RecentSearchItem(
    recentSearch: RecentSearch,
    onRecentSearchItemClick: (RecentSearch) -> Unit,
    onRecentSearchInwardArrowIconClick: (RecentSearch) -> Unit,
    modifier: Modifier = Modifier
) {

    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                onRecentSearchItemClick(recentSearch)
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = recentSearch.text,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        Icon(
            modifier = Modifier
                .size(12.dp)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    onRecentSearchInwardArrowIconClick(recentSearch)
                },
            painter = painterResource(id = MoviesIcon.ARROW_INWARD),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview
@Composable
fun RecentSearchItemPrev() {
    MoviesTheme {
        RecentSearchItem(
            recentSearch = RecentSearch("Recent Search"),
            onRecentSearchItemClick = {},
            onRecentSearchInwardArrowIconClick = {})
    }
}