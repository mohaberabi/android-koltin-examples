package com.example.moviescleanarchitcture.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.moviescleanarchitcture.data.model.movie.Movie
import com.example.moviescleanarchitcture.domain.movie.usecase.GetMoviesUseCase
import com.example.moviescleanarchitcture.domain.movie.usecase.SaveMoviesUseCase
import com.example.moviescleanarchitcture.getOrAwaitValue
import com.example.moviescleanarchitcture.presentation.movie.viewmodel.MoviesViewModel
import com.example.moviescleanarchitcture.repository.FakeMovieRepository
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


object MoviesDummy {


    val movies = listOf<Movie>(
        Movie(1, "asdsa", "asdasdasd", "sadasdasd", "sadsadasd"),
        Movie(1, "asdsa", "asdasdasd", "sadasdasd", "sadsadasd"),
        Movie(1, "asdsa", "asdasdasd", "sadasdasd", "sadsadasd"),
        Movie(1, "asdsa", "asdasdasd", "sadasdasd", "sadsadasd"),
        Movie(1, "asdsa", "asdasdasd", "sadasdasd", "sadsadasd"),
        Movie(1, "asdsa", "asdasdasd", "sadasdasd", "sadsadasd"),
    )
    val movies2 = listOf<Movie>(
        Movie(2, "asdsadsadsa", "asdasdasdasdasd", "sadasdasd", "sadsadasd"),
        Movie(2, "asdsadsadsa", "asdasdasdasdasd", "sadasdasd", "sadsadasd"),
        Movie(2, "asdsadsadsa", "asdasdasdasdasd", "sadasdasd", "sadsadasd"),
        Movie(2, "asdsadsadsa", "asdasdasdasdasd", "sadasdasd", "sadsadasd"),
        Movie(2, "asdsadsadsa", "asdasdasdasdasd", "sadasdasd", "sadsadasd"),
        Movie(2, "asdsadsadsa", "asdasdasdasdasd", "sadasdasd", "sadsadasd"),

        )
}

@RunWith(AndroidJUnit4::class)

class MoviesViewModelTest {


    @get:Rule
    val instant = InstantTaskExecutorRule()


    private lateinit var movieViewModel: MoviesViewModel

    @Before
    fun setup() {


        val fakeRepo = FakeMovieRepository()

        val getMoviesUseCase = GetMoviesUseCase(fakeRepo)
        val saveMoviesUseCase = SaveMoviesUseCase(fakeRepo)

        movieViewModel = MoviesViewModel(getMoviesUseCase, saveMoviesUseCase)
    }


    @Test
    fun `whenn repo requested movies it returns them okay`() {

        val modelMovies = movieViewModel.getMovies().getOrAwaitValue()

        Truth.assertThat(modelMovies).isEqualTo(MoviesDummy.movies)

    }

}