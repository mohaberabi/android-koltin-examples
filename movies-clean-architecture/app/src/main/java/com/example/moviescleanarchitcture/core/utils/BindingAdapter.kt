package com.example.moviescleanarchitcture.core.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviescleanarchitcture.R
import com.example.moviescleanarchitcture.presentation.movie.ui.MovieViewHolder

@BindingAdapter("imgUrl")
fun bindNetworkImage(imageView: ImageView, url: String?) {
    if (url != null) {
        Glide.with(imageView).load(url).error(R.drawable.img)
            .placeholder(R.drawable.img).into(imageView)
    } else {
        imageView.setImageResource(R.drawable.img)
    }

}