package com.example.movies.feature.details.common.components

import androidx.annotation.FloatRange
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
@Suppress("MagicNumber")
fun ScoreView(
    @FloatRange(0.0, 1.0)
    score: Float?,
    modifier: Modifier = Modifier,
    radius: Dp = 50.dp,
    fontSize: TextUnit = (radius / 2).value.sp,
    backgroundIndicatorColor: Color = MaterialTheme.colorScheme.surface.copy(
        alpha = ContentAlpha.disabled
    ),
    foregroundIndicatorColor: Color = Color.Green,
    strokeWidth: Dp = radius / 3,
    animDuration: Int = 1000,
    animDelay: Int = 0,
) {
    score?.let {
        var animationPlayed by remember {
            mutableStateOf(true)
        }

        val curPercentage = animateFloatAsState(
            targetValue = if (animationPlayed) score else 0f,
            animationSpec = tween(durationMillis = animDuration, delayMillis = animDelay)
        )

        LaunchedEffect(key1 = true) {
            animationPlayed = true
        }

        Box(
            modifier = modifier
                .size(radius * 2)
                .background(color = Color.Black, shape = CircleShape)
                .padding(1.dp),
            contentAlignment = Alignment.Center,
        ) {

            Box(
                modifier = Modifier
                    .size(radius * 2)
                    .padding(5.dp)
                    .drawBehind {
                        backgroundIndicator(
                            indicatorColor = backgroundIndicatorColor,
                            indicatorStrokeWidth = strokeWidth,
                        )

                        foregroundIndicator(
                            sweepAngle = 360 * curPercentage.value,
                            indicatorColor = foregroundIndicatorColor,
                            indicatorStrokeWidth = strokeWidth,
                        )
                    },
            )

            val superScript = SpanStyle(
                baselineShift = BaselineShift.Superscript,
                fontSize = 8.sp,
            )
            Text(
                text = buildAnnotatedString {
                    append(
                        (score * 100).toInt()
                            .toString()
                    )
                    withStyle(superScript) {
                        append("%")
                    }
                },
                style = MaterialTheme.typography.titleSmall.copy(fontSize = fontSize),
                color = Color.White
            )

        }
    }
}

private fun DrawScope.backgroundIndicator(
    indicatorColor: Color,
    indicatorStrokeWidth: Dp,
) {
    drawArc(
        color = indicatorColor,
        startAngle = -90f,
        sweepAngle = 360f,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth.toPx(),
            cap = StrokeCap.Round
        )
    )
}

private fun DrawScope.foregroundIndicator(
    sweepAngle: Float,
    indicatorColor: Color,
    indicatorStrokeWidth: Dp,
) {
    drawArc(
        color = indicatorColor,
        startAngle = -90f,
        sweepAngle = sweepAngle,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth.toPx(),
            cap = StrokeCap.Round
        )
    )
}

@Preview
@Composable
fun ScoreViewPrev() {
    MoviesTheme {
        ScoreView(score = 0.5f, radius = 25.dp)
    }
}