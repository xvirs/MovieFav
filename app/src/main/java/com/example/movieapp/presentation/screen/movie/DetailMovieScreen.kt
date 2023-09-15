package com.example.movieapp.presentation.screen.movie

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.presentation.components.BackgroundMovieDetail
import com.example.movieapp.presentation.components.DescriptionMovieScreen
import com.example.movieapp.presentation.components.TitleMovieScreen
import com.example.movieapp.presentation.components.VotePopular
import com.example.movieapp.presentation.components.addList
import com.example.movieapp.presentation.components.back

@Composable
fun DetailMovieScreen(movieViewModel: MovieViewModel,navController: NavController){

    var movieSelected = movieViewModel.movieSelected.value
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(bottom = 30.dp)
        ) {
            BackgroundMovieDetail(movieSelected!!)
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(10.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    back(navController)
                    addList()
                }
                Column(modifier = Modifier.padding(bottom = 40.dp)) {
                    Spacer(modifier = Modifier.height(40.dp))
                    TitleMovieScreen(movieSelected)
                    Spacer(modifier = Modifier.height(8.dp)) // Espaciado de 8dp
                    VotePopular(movieSelected)
                    Spacer(modifier = Modifier.height(16.dp)) // Espaciado de 16dp
                    DescriptionMovieScreen(movieSelected, null)
                    Spacer(modifier = Modifier.height(16.dp)) // Espaciado de 16dp
                    ReleaseDate(movieSelected)
                    Spacer(modifier = Modifier.height(8.dp)) // Espaciado de 8dp
                    OriginalLanguage(movieSelected)
                    Spacer(modifier = Modifier.height(8.dp)) // Espaciado de 8dp
                    Genre(movieSelected)
                    Spacer(modifier = Modifier.height(8.dp)) // Espaciado de 8dp
                    Adult(movieSelected)
                }

            }
        }
    }
}


@Composable
fun ReleaseDate(movieSelected : Movie){
    val relaseDate = movieSelected.releaseDate!!
    Text(
        text = AnnotatedString("Fecha de Lanzamiento: ") + AnnotatedString(
            relaseDate
        )
    )
}

@Composable
fun OriginalLanguage(movieSelected: Movie) {
    val originalLanguage = movieSelected.originalLanguage!!
    Text(
        text = AnnotatedString("Idioma Original: ") + AnnotatedString(
            originalLanguage
        )
    )
}

@Composable
fun Genre(movieSelected: Movie) {
    val genres = movieSelected.genreIds?.joinToString(", ")
    Text(
        text = AnnotatedString("Géneros: ") + AnnotatedString(
            genres ?: ""
        )
    )
}

@Composable
fun Adult(movieSelected: Movie) {
    val isAdult = movieSelected.adult
    val adultText = if (isAdult) "Sí" else "No"
    Text(
        text = AnnotatedString("Para Adultos: ") + AnnotatedString(
            adultText
        )
    )
}
