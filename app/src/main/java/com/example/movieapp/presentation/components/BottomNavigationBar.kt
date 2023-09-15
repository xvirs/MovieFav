package com.example.movieapp.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.movieapp.presentation.navegation.AppScreens

@Composable
fun BottomNavigationBar(navController: NavController, items: List<AppScreens>) {
    val currentScreen = navController.currentDestination?.route ?: ""
    BottomNavigation(
        backgroundColor = Color.Transparent,
        contentColor = Color.Magenta,
        modifier = Modifier.fillMaxWidth()
    ) {
        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    screen.icon?.let {
                        Icon(
                            imageVector = it,
                            contentDescription = screen.title
                        )
                    }
                },
                label = { screen.title },
                selected = currentScreen == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
                alwaysShowLabel = false
            )
        }

    }
}