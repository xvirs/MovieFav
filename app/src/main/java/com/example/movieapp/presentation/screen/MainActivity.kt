package com.example.movieapp.presentation.screen

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.presentation.components.BottomNavigationBar
import com.example.movieapp.presentation.navegation.AppNavigation
import com.example.movieapp.presentation.navegation.AppScreens
import com.example.movieapp.presentation.screen.dashboard.DashboardViewModel
import com.example.movieapp.presentation.screen.list.ListsViewModel
import com.example.movieapp.presentation.screen.movie.MovieViewModel
import com.example.movieapp.presentation.screen.search.SearchViewModel
import com.example.movieapp.ui.theme.MovieAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val dashboardViewModel: DashboardViewModel by viewModels()
    private val movieViewModel: MovieViewModel by viewModels()
    private val searchViewModel: SearchViewModel by viewModels()
    private val listsViewModel: ListsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        setContent {
            MovieAppTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    MainScreen(dashboardViewModel, movieViewModel, searchViewModel, listsViewModel)
//                    DashboardScreen(dashboardViewModel = dashboardViewModel)
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(dashboardViewModel: DashboardViewModel, movieViewModel: MovieViewModel, searchViewModel: SearchViewModel, listsViewModel: ListsViewModel){

    val navController = rememberNavController()

    val navigationItems = listOf(
        AppScreens.Dashboard,
        AppScreens.Lists,
        AppScreens.Search
    )

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController, items = navigationItems , ) }
    ){
        AppNavigation(dashboardViewModel, movieViewModel, searchViewModel, listsViewModel, navController)
    }
}