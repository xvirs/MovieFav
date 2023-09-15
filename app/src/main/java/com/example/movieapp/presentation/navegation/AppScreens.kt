package com.example.movieapp.presentation.navegation


import androidx.compose.material.icons.Icons
import android.net.Uri
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement


sealed class AppScreens(val route: String, val title: String?, val icon: ImageVector?) {

    //Items tab navigation.
    object Dashboard: AppScreens("dashboard_screen", "Home", Icons.Filled.Home )
    object Search: AppScreens("search_screen","Search", Icons.Filled.Search)
    object Lists: AppScreens("lists_screen","Lists", Icons.Filled.List)


    //Navigation to movie details.
    object Movie: AppScreens("movie_screen/{${NavArgs.Movie.key}}", null, null ) {
        fun createRoute(movieSelected: com.example.movieapp.domain.model.Movie?) = "movie_screen/${
            Uri.encode(
                Json.encodeToJsonElement(movieSelected).toString()
            )
        }"
    }
    object DetailMovie: AppScreens("detailmovie_screen",null, null)
}



//Parametro Movie
enum class NavArgs(val key: String) {
    Movie("movie")
}
