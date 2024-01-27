package com.example.movieapp.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import com.example.moobeez.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen() {
    val items = ArrayList<Page>()
    items.add(
        Page(
            R.raw.animation1,
            "Bienvenido a Moobeez",
            "En esta app podrás ver y descubrir un sin fin de películas, escribir reseñas, y seguir a otros cinéfilos"
        )
    )
    items.add(
        Page(
            R.raw.animation2,
            "Entérate de Nuevos Lanzamientos",
            "Mantente al día con las últimas películas en la industria del cine. Explora tráilers, fechas de estreno y sinopsis de emocionantes nuevos lanzamientos."
        )
    )
    items.add(
        Page(
            R.raw.animation3,
            "Conecta con Otros Cinéfilos",
            "Comparte tu pasión por el cine al conectar con otros apasionados cinéfilos. Únete a conversaciones emocionantes, comparte tus opiniones y descubre nuevas perspectivas en Moobeez."
        )
    )
    items.add(
        Page(
            R.raw.animation4,
            "Explora Joyas Cinematográficas",
            "¡Vamos a sumergirnos en el emocionante mundo del séptimo arte!"
        )
    )
    val pagerState = rememberPagerState(
        initialPage = 0
    )
    OnBoardingPager(
        item = items, pagerState = pagerState
    )
}
