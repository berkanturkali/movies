package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import com.examle.movies.core.ui.theme.MoviesTheme

const val MINIMIZED_TEXT_LINES = 8

@Composable
fun ReviewItemReview(
    review: String?,
    modifier: Modifier = Modifier
) {
    var cutText by remember(review) { mutableStateOf<String?>(null) }
    val expanded by remember { mutableStateOf(false) }
    val textLayoutResultState = remember { mutableStateOf<TextLayoutResult?>(null) }
    val seeMoreSizeState = remember { mutableStateOf<IntSize?>(null) }
    val seeMoreOffsetState = remember { mutableStateOf<Offset?>(null) }

    val textLayoutResult = textLayoutResultState.value
    val seeMoreSize = seeMoreSizeState.value
    val seeMoreOffset = seeMoreOffsetState.value

    review?.let {
        LaunchedEffect(review, expanded, textLayoutResult, seeMoreSize) {
            val lastLineIndex = MINIMIZED_TEXT_LINES - 1
            if (!expanded && textLayoutResult != null && seeMoreSize != null
                && lastLineIndex + 1 == textLayoutResult.lineCount
                && textLayoutResult.isLineEllipsized(lastLineIndex)
            ) {
                var lastCharIndex =
                    textLayoutResult.getLineEnd(lastLineIndex, visibleEnd = true) + 1
                var charRect: Rect
                do {
                    lastCharIndex -= 1
                    charRect = textLayoutResult.getCursorRect(lastCharIndex)
                } while (
                    charRect.left > textLayoutResult.size.width - seeMoreSize.width
                )
                seeMoreOffsetState.value =
                    Offset(charRect.left, charRect.bottom - seeMoreSize.height)
                cutText = review.substring(startIndex = 0, endIndex = lastCharIndex)
            }
        }

        Box(modifier) {
            Text(
                maxLines = if (expanded) Int.MAX_VALUE else MINIMIZED_TEXT_LINES,
                text = cutText ?: review,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                overflow = TextOverflow.Ellipsis,
                onTextLayout = { textLayoutResultState.value = it },
            )
            if (!expanded) {
                val density = LocalDensity.current
                Text(
                    "... See more",
                    onTextLayout = { seeMoreSizeState.value = it.size },
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                        .then(
                            if (seeMoreOffset != null)
                                Modifier.offset(
                                    x = with(density) { seeMoreOffset.x.toDp() },
                                    y = with(density) { seeMoreOffset.y.toDp() },
                                )
                            else
                                Modifier
                        )
                        .clickable {
                            // TODO: on see more button click
                        }
                        .alpha(if (seeMoreOffset != null) 1f else 0f)
                )
            }
        }


    }
}

@Preview
@Composable
fun ReviewItemReviewPrev() {
    MoviesTheme {
        ReviewItemReview(
            review = "Sad night tonight. After 80-odd years," +
                    " this was the last film to show in my local cinema before it closed down" +
                    ". Doubly sad because it’s also not actually very good." +
                    " The conceptualisation behind the hybrid styles of animation is spectacular" +
                    " and executed in an highly polished fashion - as you’d expect." +
                    " The story is all over the pace though" +
                    ", and the proliferation of Spidey’s seemed designed more to allow the narrative" +
                    " to become more culturally inclusive (and bankable) rather than" +
                    " to develop any meaningful characterisations. What personas there are" +
                    " spend their time wallowing in a mire of unrequited and/or confused" +
                    " familial love, or teenage angst more suitable in a soap." +
                    " The dialogue has it’s moments - assuming you can catch it" +
                    " - and there’s a bit of humour to be found but I found the audio mix" +
                    " made following all that was said became a bit wearisome after a" +
                    " first hour that really does depend on your having watched (and remembering)" +
                    " the first - in my view far better - instalment. This whole" +
                    " “multiverse” theme can keep on recycling itself ad nauseam but" +
                    " if the writing remains at this unremarkable level then" +
                    " I’m not sure I’ll be bothering with the next set of repetitively " +
                    "set-piece adventures for “Miles” and his parents, love interest and" +
                    " fellow Spider-folk."
        )
    }
}