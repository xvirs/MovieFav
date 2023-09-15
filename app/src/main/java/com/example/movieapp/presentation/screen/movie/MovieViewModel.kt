package com.example.movieapp.presentation.screen.movie

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.GetPopularMoviesUseCase
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.presentation.navegation.NavArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase

) : ViewModel() {



    private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _movieSelected: MutableState<Movie?> = mutableStateOf(null)
    val movieSelected: State<Movie?> = _movieSelected

    init {
        onCreate()
    }

    fun onCreate(){
        viewModelScope.launch {

        }
    }

    fun setMovieSelected(movie : Movie){
        viewModelScope.launch {
            _movieSelected.value = movie
        }
    }





}