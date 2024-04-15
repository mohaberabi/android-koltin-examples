package com.example.newsapp.features.news.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.MainActivity

import com.example.newsapp.R
import com.example.newsapp.core.util.AppResult
import com.example.newsapp.databinding.FragmentNewsBinding
import com.example.newsapp.features.news.presentation.viewmodel.NewsViewModel


class NewsFragment : Fragment() {
    private lateinit var viewModel: NewsViewModel
    private lateinit var binding: FragmentNewsBinding
    private lateinit var newsAdapter: NewsAdapter


    private var loading = false
    private var page = 1
    private var pages = 1

    private var isLastPage = false
    private val scrollListener = object : RecyclerView.OnScrollListener() {

        override fun onScrollStateChanged(
            recyclerView: RecyclerView,
            newState: Int
        ) {
            super.onScrollStateChanged(recyclerView, newState)
            if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                isScrolling = true
            }
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val manager = binding.recView.layoutManager as LinearLayoutManager

            val sizeOfCurrentList = manager.itemCount

            val visibleCount = manager.childCount
            val topPosition = manager.findFirstVisibleItemPosition()
            val hasReachedToEnd = topPosition + visibleCount >= sizeOfCurrentList

            val shouldPaginate = !loading && !isLastPage && hasReachedToEnd && isScrolling
            if (shouldPaginate) {
                page++
                viewModel.getNews("eg", page)
                isScrolling = false
            }


        }
    }
    private var isScrolling = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNewsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsBinding.bind(view)
        viewModel = (requireActivity() as MainActivity).viewModel
        newsAdapter = NewsAdapter {

            findNavController().navigate(

                NewsFragmentDirections.actionNewsFragmentToNewsInfoFragment(it.url)
            )
        }
        initRecycleView()
        getNews()
    }

    private fun initRecycleView() {
        binding.recView.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
            addOnScrollListener(this@NewsFragment.scrollListener)
        }

    }

    private fun showHidProgressBar(show: Boolean) {
        binding.progressBar.visibility = if (show) View.VISIBLE else View.INVISIBLE
    }

    private fun getNews() {

        viewModel.getNews(
            "eg", page
        )
        viewModel.news.observe(viewLifecycleOwner) { data ->
            when (data) {
                is AppResult.Done -> {
                    showHidProgressBar(false)
                    data.data?.let {
                        newsAdapter.differ.submitList(it.articles)
                        if (it.totalResults % 20 == 0) {
                            pages = it.totalResults / 20
                        } else {
                            pages = it.totalResults / 20 + 1
                        }

                        isLastPage = page == pages
                    }
                }

                is AppResult.Error -> {

                    showHidProgressBar(false)
                    Toast.makeText(context, data.message, Toast.LENGTH_SHORT).show()
                }

                is AppResult.Loading -> {
                    showHidProgressBar(true)
                }

            }
        }
    }
}