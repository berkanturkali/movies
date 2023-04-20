package com.example.movies.feature.search.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.icon.MoviesIcons
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.core.model.search.recent_search.RecentSearch

@Composable
fun RecentSearchItem(
    recentSearch: RecentSearch,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
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
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = MoviesIcons.ARROW_INWARD),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview
@Composable
fun RecentSearchItemPrev() {
    MoviesTheme {
        RecentSearchItem(recentSearch = RecentSearch("Recent Search"))
    }
}