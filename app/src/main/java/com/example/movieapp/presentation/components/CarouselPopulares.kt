package com.example.movieapp.presentation.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.ui.theme.poppins

@Composable
fun CarouselPupular (movies: List<Movie>, navToMovieScreen: (Movie) -> Unit) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(start = 10.dp)
    ) {
        items(movies.size) { page ->
            Box(modifier = Modifier.clickable {
                navToMovieScreen(movies[page])
            }) {
                Column(
                    modifier = Modifier.width(300.dp),
                ) {
                    ImageBackdrop(movies[page])
                    Title(movies[page])
                    VotePopular(movies[page])
                }
            }
        }
    }
}


@Composable
fun ImageBackdrop(movie: Movie) {
    val imageUrl = "https://image.tmdb.org/t/p/w500${movie.backdropPath}"
    AsyncImage(
        model = imageUrl,
        contentDescription = movie.title,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
    )
}

@Composable
fun Title(movie: Movie) {
    val title = movie.title.toString()
    Box(modifier = Modifier.height(60.dp)) {
        Text(
            text = title,
            maxLines = 2,
            style = TextStyle(
                fontFamily = poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                letterSpacing = 0.5.sp,
                textAlign = TextAlign.Left
            ),
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(end = 5.dp)
                .align(alignment = Alignment.Center)
        )
    }
}