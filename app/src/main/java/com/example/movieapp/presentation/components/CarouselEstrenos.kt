package com.example.movieapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.ParagraphIntrinsics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.ui.theme.poppins

@Composable
fun CarouselEstreno(movies: List<Movie>, navToMovieScreen: (Movie) -> Unit) {
    val listState = rememberLazyListState()
    Box(modifier = Modifier
        .fillMaxWidth()
//      .height(300.dp)
    ){
        LazyRow(
            horizontalArrangement = Arrangement.Center,
            state = listState,
            modifier = Modifier.fillMaxSize()
        ) {
            items(movies.size) { page ->
                Box(modifier = Modifier
                    .fillParentMaxWidth()
//                    .height(IntrinsicSize.Max),
                ){
                    Row(modifier = Modifier
                        .clickable { navToMovieScreen(movies[page]) })
                    {
                        Box(modifier = Modifier) {
                            getImagePoster(movies[page])
                        }
                        Box(modifier = Modifier) {
                            Column {
                                Title(movies[page])
                                VoteEstreno(movies[page])
                                DescriptionMovieScreen(movies[page], null)
                            }
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun getImagePoster(movie: Movie) {
    val imageUrl = "https://image.tmdb.org/t/p/w500${movie.posterPath}"
    AsyncImage(
        model = imageUrl,
        contentDescription = movie.title,
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .padding(horizontal = 5.dp)
    )
}

fun calculate(){

}