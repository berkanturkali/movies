package com.example.movies.feature.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.icon.MoviesIcons
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.core.model.search.SearchCategory

@Composable
fun SearchCategoriesTopBar(
    query: TextFieldValue,
    focused: Boolean,
    onBackButtonClick: () -> Unit,
    onCancelButtonClick: () -> Unit,
    onTrailingIconClick: () -> Unit,
    onFocusChanged: (Boolean) -> Unit,
    onSearchQueryChanged: (TextFieldValue) -> Unit,
    onSearchButtonClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {


    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(horizontal = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackButtonClick) {
                Icon(
                    painter = painterResource(id = MoviesIcons.BACK),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary,
                )
            }
            SearchBar(
                query = query,
                focused = focused,
                onQueryChanged = onSearchQueryChanged,
                onTrailingIconClick = onTrailingIconClick,
                onFocusChanged = onFocusChanged,
                onSearchButtonClick = onSearchButtonClick,
                onCancelButtonClick = onCancelButtonClick,
            )
        }
    }
}

@Preview
@Composable
fun SearchCategoriesContentPrev() {
    MoviesTheme {
        SearchCategoriesTopBar(
            query = TextFieldValue(""),
            focused = false,
            onBackButtonClick = {},
            onCancelButtonClick = {},
            onFocusChanged = {},
            onSearchButtonClick = {},
            onSearchQueryChanged = {},
            onTrailingIconClick = {}
        )
    }
}