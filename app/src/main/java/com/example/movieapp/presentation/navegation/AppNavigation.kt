@file:Suppress("DEPRECATION")

package com.example.movieapp.presentation.navegation

import android.net.Uri
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.presentation.screen.dashboard.DashboardScreen
import com.example.movieapp.presentation.screen.dashboard.DashboardViewModel
import com.example.movieapp.presentation.screen.list.ListsScreen
import com.example.movieapp.presentation.screen.list.ListsViewModel
import com.example.movieapp.presentation.screen.movie.DetailMovieScreen
import com.example.movieapp.presentation.screen.movie.MovieScreen
import com.example.movieapp.presentation.screen.movie.MovieViewModel
import com.example.movieapp.presentation.screen.search.SearchScreen
import com.example.movieapp.presentation.screen.search.SearchViewModel
import kotlinx.serialization.json.Json

@Composable
fun AppNavigation(
    dashboardViewModel: DashboardViewModel?,
    movieViewModel: MovieViewModel,
    searchViewModel: SearchViewModel,
    listsViewModel: ListsViewModel,
    navController: NavHostController
) {
    NavHost(navController, AppScreens.Dashboard.route) {


        composable(AppScreens.Dashboard.route)
        {
            DashboardScreen( dashboardViewModel!!, navToMovieScreen ={
                    movieViewModel.setMovieSelected(it)
                    navController.navigate(AppScreens.Movie.createRoute(it))
            })
        }
        composable(AppScreens.Search.route){ SearchScreen(searchViewModel)}
        composable(AppScreens.Lists.route){ ListsScreen(listsViewModel) }


        composable(AppScreens.Movie.route, arguments = listOf(navArgument("movie") {type = ItemNavType}))
        { navBackStackEntry ->
            val movieSelected = navBackStackEntry.arguments?.getParcelable<Movie>("movie")
            requireNotNull(movieSelected)
            MovieScreen(movieViewModel,
                navToDetailMovieScreen = {
                navController.navigate(AppScreens.DetailMovie.route)
            }, navController)
        }
        composable(AppScreens.DetailMovie.route){ DetailMovieScreen(movieViewModel, navController) }

    }
}


val ItemNavType = object : NavType<Movie>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Movie? {
        return bundle.getParcelable(key) as Movie?
    }

    override fun parseValue(value: String): Movie {
        return Json.decodeFromString(Uri.decode(value))
    }

    override fun put(bundle: Bundle, key: String, value: Movie) {
        bundle.putParcelable(key, value)
    }

}