package com.example.movies.feature.search.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.core.model.search.keyword.Keyword

@Composable
fun KeywordItem(
    keyword: Keyword,
    onKeywordItemClick: (Keyword) -> Unit,
    modifier: Modifier = Modifier
) {
    keyword.name?.let { name ->
        Text(
            modifier = modifier
                .fillMaxWidth()
                .clickable {
                    onKeywordItemClick(keyword)
                }
                .padding(8.dp),
            text = name,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview
@Composable
fun KeywordItemPrev() {
    MoviesTheme {
        KeywordItem(keyword = Keyword(1, "Name"), onKeywordItemClick = {})
    }
}