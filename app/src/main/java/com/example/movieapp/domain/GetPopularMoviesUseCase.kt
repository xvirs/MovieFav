package com.example.movieapp.domain


import com.example.movieapp.data.repository.PopularMovieRepository
import com.example.movieapp.domain.model.Movie
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(private val repository: PopularMovieRepository) {
    suspend operator fun invoke():List<Movie> {
        val result: List<Movie> = repository.getAllPopularMovie()
        return result
    }

}