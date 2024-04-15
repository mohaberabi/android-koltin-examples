package com.example.newsapp.features.news.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.databinding.NewsItemBinding
import com.example.newsapp.features.news.data.model.Article

class NewsAdapter(private val onClick: (Article) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {


    private val callback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(
            oldItem: Article,
            newItem: Article
        ): Boolean = oldItem.url == newItem.url

        override fun areContentsTheSame(
            oldItem: Article,
            newItem: Article
        ): Boolean = oldItem == newItem

    }

    val differ = AsyncListDiffer(this, callback)

    inner class NewsViewHolder(
        private val binding: NewsItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article) {
            binding.tvTitle.text = article.title
            binding.tvDescription.text = article.title
            binding.tvPublishedAt.text = article.publishedAt
            binding.tvSource.text = article.source.name
            Glide.with(binding.ivArticleImage.context).load(article.url)
                .into(binding.ivArticleImage)

            binding.root.setOnClickListener {
                onClick.invoke(article)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsViewHolder {

        val binding = NewsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(
        holder: NewsViewHolder,
        position: Int
    ) {

        val artilce = differ.currentList[position]
        holder.bind(artilce)
    }
}