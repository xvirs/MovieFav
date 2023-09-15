package com.example.movieapp.data.model

import com.example.movieapp.data.model.movie.MovieModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieProvider @Inject constructor() {
    companion object {
        var movie: List<MovieModel> = emptyList()
    }
}