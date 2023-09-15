package com.example.movieapp.data.repository



import com.example.movieapp.data.model.movie.MovieModel
import com.example.movieapp.data.remote.MovieSevice
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.toDomain
import javax.inject.Inject

class PopularMovieRepository @Inject constructor(private val api: MovieSevice) {
    suspend fun getAllPopularMovie(): List<Movie>{
        val response : List<MovieModel> = api.getMovies().results
        return response.map { it.toDomain() }
    }
}