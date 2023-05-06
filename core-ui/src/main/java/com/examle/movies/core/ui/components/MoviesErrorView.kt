package com.examle.movies.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.examle.movies.core.ui.R
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun MoviesErrorView(
    message: String,
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = message,
            maxLines = 3,
            style = androidx.compose.material3.MaterialTheme.typography.titleMedium,
            color = androidx.compose.material3.MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    dimensionResource(id = R.dimen.dimen_16),
                ),
            textAlign = TextAlign.Center,
        )
        Button(
            onClick = {
                onRetryClick()
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = androidx.compose.material3.MaterialTheme.colorScheme.onPrimary,
                contentColor = androidx.compose.material3.MaterialTheme.colorScheme.secondary
            ),
        ) {
            Text(
                text = stringResource(
                    id = R.string.try_again
                )
            )
        }
    }
}

@Preview
@Composable
fun ErrorViewPrev() {
    MoviesTheme {
        MoviesErrorView(message = "Something went wrong", onRetryClick = { })
    }
}