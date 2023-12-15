package com.example.movieapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.moobeez.R
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.ui.theme.Primario
import com.example.movieapp.ui.theme.poppins

@Composable
fun MovieImage(movieSelected: Movie) {
    AsyncImage(
        model = "https://image.tmdb.org/t/p/w500${movieSelected.posterPath}",
        contentDescription = "${movieSelected.title}",
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .graphicsLayer { alpha = 0.99f }
            .drawWithContent {
                val colors = listOf(
                    Color.Black,
                    Color.Transparent
                )
                drawContent()
                drawRect(
                    brush = Brush.verticalGradient(colors),
                    blendMode = BlendMode.DstIn
                )
            }
    )
}

@Composable
fun back(navController: NavController) {
    Icon(
        painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
        contentDescription = "Back",
        tint = Primario,
        modifier = Modifier
            .size(40.dp)
            .padding(top = 5.dp)
            .clickable { navController.popBackStack() }
    )

}

@Composable
fun addList() {
    Icon(
        painter = painterResource(id = R.drawable.outline_bookmark_border_24),
        contentDescription = "Add",
        tint = Primario,
        modifier = Modifier
            .size(40.dp)
            .padding(top = 5.dp)
            .clickable { }

    )
}

@Composable
fun TitleMovieScreen(movie: Movie) {
    val title = movie.title.toString()
    Text(
        text = title,
        maxLines = 3,
        style = TextStyle(
            fontFamily = poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            letterSpacing = 0.5.sp,
            textAlign = TextAlign.Left
        )
    )
}


@Composable
fun DescriptionMovieScreen(movie: Movie, navToDetailMovieScreen: (() -> Unit?)?) {
    Box(modifier = Modifier
        .padding(vertical = 5.dp)
        .clickable {
            if (navToDetailMovieScreen != null) {
                navToDetailMovieScreen()
            }
        }) {
        Text(text = movie.overview.toString(), overflow = TextOverflow.Ellipsis)
    }
}