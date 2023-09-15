package com.example.movieapp.presentation.screen.dashboard


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.presentation.components.CarouselEstreno
import com.example.movieapp.presentation.components.CarouselPupular
import com.example.movieapp.presentation.components.TitleListHome


@Composable
fun DashboardScreen(dashboardViewModel: DashboardViewModel, navToMovieScreen: (Movie) -> Unit) {

    var movies: List<Movie> = dashboardViewModel?.popularMovies!!.value

    MaterialTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(bottom = 60.dp)
            .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)) {
                Column {
                    TitleListHome("Populares")
                    CarouselPupular( movies, navToMovieScreen)
                }
            }
            Box(modifier = Modifier
                .fillMaxHeight()
                .padding(top = 30.dp)) {
                Column {
                    TitleListHome("Estreno")
                    CarouselEstreno( movies, navToMovieScreen)
                }
            }
        }
    }
}
