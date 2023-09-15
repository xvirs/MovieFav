package com.example.movieapp.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.ui.theme.poppins



@Composable
fun VotePopular(movie: Movie) {
    var vote : Int? = movie.voteAverage?.div(2)!!.toInt()
    val stars = vote
    Row{
        Text(
            text = "( ${vote.toString()} )",
            style = TextStyle(
                fontFamily = poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                letterSpacing = 0.5.sp,
                textAlign = TextAlign.Left
            ),
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        for (i in 1..5) {
            Icon(Icons.Filled.Star, contentDescription = "Star", tint = if(i <= stars!!) Color.Yellow else Color.Gray)
        }
    }
}

@Composable
fun VoteEstreno(movie: Movie) {
    var vote : Int? = movie.voteAverage?.div(2)!!.toInt()
    val stars = vote
    Row{
        Text(
            text = "(${vote.toString()})",
            style = TextStyle(
                fontFamily = poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                letterSpacing = 0.5.sp,
                textAlign = TextAlign.Left
            ),
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        for (i in 1..5) {
            Icon(Icons.Filled.Star, contentDescription = "Star", tint = if(i <= stars!!) Color.Yellow else Color.Gray, modifier = Modifier.size(20.dp))
        }
    }
}