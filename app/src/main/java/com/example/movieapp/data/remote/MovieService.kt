package com.example.movieapp.data.remote


import com.example.movieapp.data.model.Popular
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieSevice @Inject constructor(private val api: PopularMovieApiClient) {

    suspend fun getMovies(): Popular {
        return withContext(Dispatchers.IO) {
            val response = api.getPopularMovies(
                "e34e542dda9bfc0d277e4f73eddfeaee",
                "en-US",
//                "${(1..500).random()}"
                "3"
            )
            response.body()!!
        }
    }
}

/*
* https://api.themoviedb.org/3/movie/popular?api_key=e34e542dda9bfc0d277e4f73eddfeaee&language=en-US&page=1
* https://api.themoviedb.org/3/movie/popular?api_key=e34e542dda9bfc0d277e4f73eddfeaee&language=en-US&page=1
* */