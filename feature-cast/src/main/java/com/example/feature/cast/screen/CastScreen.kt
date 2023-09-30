package com.example.feature.cast.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.examle.movies.core.ui.components.MoviesFab
import com.examle.movies.core.ui.components.MoviesScaffold
import com.examle.movies.core.ui.components.TopBarWithBackButton
import com.examle.movies.core.ui.icon.MoviesIcon
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.feature.cast.components.CastItem
import com.example.feature.cast.viewmodel.CastScreenViewModel
import com.example.movies.core.model.moviedetails.Cast
import com.example.movies.feature.cast.R
import kotlinx.coroutines.launch

@Composable
fun CastScreen(
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CastScreenViewModel = hiltViewModel()
) {

    val cast by viewModel.cast.observeAsState()

    val scope = rememberCoroutineScope()
    val listState = rememberLazyListState()

    val showScrollToTopButton by remember { derivedStateOf { listState.firstVisibleItemIndex > 0 } }

    MoviesScaffold(
        fab = {
            AnimatedVisibility(
                visible = showScrollToTopButton,
                enter = fadeIn(),
                exit = fadeOut(),
            ) {
                MoviesFab(
                    icon = MoviesIcon.UP,
                    onFabClick = {
                        scope.launch {
                            listState.scrollToItem(0)
                        }
                    })
            }
        }
    ) {
        cast?.let {
            CastScreenContent(
                castList = it, modifier = modifier, state = listState, onBackButtonClick = onBackButtonClick)
        }
    }
}

@Composable
fun CastScreenContent(
    castList: List<Cast>,
    state: LazyListState,
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        state = state,
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
        stickyHeader {
            TopBarWithBackButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 0.dp, vertical = 0.dp),
                onBackButtonClick = onBackButtonClick,
                title = String.format(
                    stringResource(id = R.string.cast_screen_title), castList.size.toString(),
                ),
                background = MaterialTheme.colorScheme.secondary.copy(alpha = 0.95f)
            )
        }
        items(castList) { castModel ->
            CastItem(
                image = castModel.image,
                name = castModel.name,
                characterName = castModel.characterName,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun CastScreenContentPrev() {
    MoviesTheme {
        val list = (0..5).map {
            Cast(image = "", name = "Name $it", characterName = "Character $it")
        }
        CastScreenContent(castList = list, state = rememberLazyListState(), onBackButtonClick = {})
    }
}