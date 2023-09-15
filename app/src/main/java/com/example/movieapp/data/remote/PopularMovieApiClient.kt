package com.example.movieapp.data.remote


import com.example.movieapp.data.model.Popular
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularMovieApiClient {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: String
    ): Response<Popular>
}