package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun ReviewItemReview(
    review: String?,
    modifier: Modifier = Modifier
) {
    review?.let {
        Text(
            modifier = modifier.fillMaxWidth(),
            text = review,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}

@Preview
@Composable
fun ReviewItemReviewPrev() {
    MoviesTheme {
        ReviewItemReview(
            review = "Sad night tonight. After 80-odd years, this was the last film to show in my local cinema before it closed down. Doubly sad because it’s also not actually very good. The conceptualisation behind the hybrid styles of animation is spectacular and executed in an highly polished fashion - as you’d expect. The story is all over the pace though, and the proliferation of Spidey’s seemed designed more to allow the narrative to become more culturally inclusive (and bankable) rather than to develop any meaningful characterisations. What personas there are spend their time wallowing in a mire of unrequited and/or confused familial love, or teenage angst more suitable in a soap. The dialogue has it’s moments - assuming you can catch it - and there’s a bit of humour to be found but I found the audio mix made following all that was said became a bit wearisome after a first hour that really does depend on your having watched (and remembering) the first - in my view far better - instalment. This whole “multiverse” theme can keep on recycling itself ad nauseam but if the writing remains at this unremarkable level then I’m not sure I’ll be bothering with the next set of repetitively set-piece adventures for “Miles” and his parents, love interest and fellow Spider-folk."
        )
    }
}