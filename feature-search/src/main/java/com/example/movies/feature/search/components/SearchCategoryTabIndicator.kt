package com.example.movies.feature.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchCategoryTabIndicator(modifier: Modifier = Modifier) {
    Spacer(
        modifier = modifier
            .padding(horizontal = 24.dp)
            .height(2.dp)
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(topStartPercent = 100, topEndPercent = 100)
            )
    )
}