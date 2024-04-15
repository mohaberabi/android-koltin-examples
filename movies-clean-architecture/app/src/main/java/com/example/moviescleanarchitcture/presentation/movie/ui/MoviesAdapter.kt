package com.example.moviescleanarchitcture.presentation.movie.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviescleanarchitcture.R
import com.example.moviescleanarchitcture.data.model.movie.Movie
import com.example.moviescleanarchitcture.databinding.MovieItemBinding

class MoviesAdapter : RecyclerView.Adapter<MovieViewHolder>() {


    private val movies = mutableListOf<Movie>()


    fun setList(newMovies: List<Movie>) {
        movies.clear()
        movies.addAll(newMovies)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {


        val inflater = LayoutInflater.from(parent.context)
        val binding: MovieItemBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.movie_item,
                parent,
                false
            )

        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(
        holder: MovieViewHolder,
        position: Int
    ) {

        val movie = movies[position]
        return holder.bind(movie)
    }
}


class MovieViewHolder(
    private val binding: MovieItemBinding,
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.movie = movie
    }

}