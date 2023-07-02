package com.example.movies.feature.home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.examle.movies.core.ui.icon.MoviesIcon

@Composable
fun SectionTitle(
    title: String,
    modifier: Modifier = Modifier,
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                vertical = dimensionResource(id = com.examle.movies.core.ui.R.dimen.dimen_16),
                horizontal = dimensionResource(
                    id = com.examle.movies.core.ui.R.dimen.dimen_8
                )
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimary,
            fontWeight = FontWeight.Bold
        )

        Icon(
            painter = painterResource(id = MoviesIcon.NEXT),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}