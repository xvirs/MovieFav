package com.example.movieapp.domain

import com.example.movieapp.data.repository.PopularMovieRepository
import com.example.movieapp.domain.model.Movie
import javax.inject.Inject

class GetRandomMovieUseCase @Inject constructor(private val popularMovieRepository: PopularMovieRepository) {

    suspend operator fun invoke(): Movie {
        val movies = popularMovieRepository.getAllPopularMovie()
        val randomNumber = (movies.indices).random()
        return movies[randomNumber]
    }
}