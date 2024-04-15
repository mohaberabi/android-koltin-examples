package com.example.moviescleanarchitcture.presentation.movie.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.moviescleanarchitcture.R
import com.example.moviescleanarchitcture.core.di.Injecter
import com.example.moviescleanarchitcture.databinding.FragmentMoviesBinding
import com.example.moviescleanarchitcture.presentation.movie.viewmodel.MoviesViewModel
import com.example.moviescleanarchitcture.presentation.movie.viewmodel.MoviesViewModelFactory
import javax.inject.Inject


class MoviesFragment : Fragment() {

    @Inject
    lateinit var moviesViewModelFactory: MoviesViewModelFactory

    private lateinit var moviesViewModel: MoviesViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        (requireActivity().application as Injecter).createMovieSubComponent()
            .inject(this)

        moviesViewModel =
            ViewModelProvider(this, moviesViewModelFactory)[MoviesViewModel::class.java]

        val binding: FragmentMoviesBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_movies,
                container,
                false
            )
        val movies = moviesViewModel.getMovies()
        val adapter = MoviesAdapter()
        binding.movieRecyclerView.adapter = adapter
        binding.lifecycleOwner = this
        movies.observe(viewLifecycleOwner) {
            Log.i("movie", it.toString())
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        }
        return binding.root
    }

}