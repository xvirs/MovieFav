package com.example.movieapp.data.model

import com.example.movieapp.data.model.movie.MovieModel

data class Popular(
    val page: Int,
    val results: List<MovieModel>,
    val total_pages: Int,
    val total_results: Int
)