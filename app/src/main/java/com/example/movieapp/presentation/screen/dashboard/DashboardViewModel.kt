package com.example.movieapp.presentation.screen.dashboard


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.GetPopularMoviesUseCase
import com.example.movieapp.domain.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {


    private var _popularMovies: MutableState<List<Movie>> = mutableStateOf(emptyList())
    var popularMovies: State<List<Movie>> = _popularMovies



    private var _movieSelected : MutableState<Movie?> = mutableStateOf(null)
    var movieSelected: State<Movie?> = _movieSelected


    init {
        onCreate()
    }

    fun onCreate() {
        viewModelScope.launch {
            val result = getPopularMoviesUseCase()
            _popularMovies.value = result
        }
    }

    fun setMovieSelected(movie : Movie){
        viewModelScope.launch {
            _movieSelected.value = movie
        }
    }
}

