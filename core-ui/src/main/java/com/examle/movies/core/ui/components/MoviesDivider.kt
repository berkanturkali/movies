package com.examle.movies.core.ui.components

import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.theme.Divider

@Composable
fun MoviesDivider(
    modifier: Modifier = Modifier,
    color: Color = Divider,
    thickness: Dp = 0.5.dp
) {

    Divider(
        modifier = modifier,
        color = color,
        thickness = thickness
    )

}