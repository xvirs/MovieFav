package com.example.movieapp.presentation.screen.movie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.presentation.components.DescriptionMovieScreen
import com.example.movieapp.presentation.components.MovieImage
import com.example.movieapp.presentation.components.TitleMovieScreen
import com.example.movieapp.presentation.components.VotePopular
import com.example.movieapp.presentation.components.addList
import com.example.movieapp.presentation.components.back

@Composable
fun MovieScreen(movieViewModel: MovieViewModel, navToDetailMovieScreen: () -> Unit, navController: NavController) {

    var movieSelected = movieViewModel.movieSelected.value
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(bottom = 30.dp)
        ) {
            MovieImage(movieSelected!!)
            Column(Modifier.fillMaxSize().padding(10.dp), verticalArrangement = Arrangement.SpaceBetween) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    back(navController)
                    addList()
                }

                Column(modifier = Modifier.padding(bottom = 20.dp)) {
                    TitleMovieScreen(movieSelected)
                    VotePopular(movieSelected)
                    DescriptionMovieScreen(movieSelected, navToDetailMovieScreen)
                }

            }
        }
    }
}


