package com.example.newsapp.features.news.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentNewsBinding
import com.example.newsapp.databinding.FragmentNewsInfoBinding


class NewsInfoFragment : Fragment() {


    private lateinit var binding: FragmentNewsInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val args: NewsInfoFragmentArgs by navArgs()

        var url = args.url
        binding = FragmentNewsInfoBinding.inflate(
            layoutInflater,
            container,
            false
        )

        binding.artivleWebView.apply {
            webViewClient = WebViewClient()
            loadUrl(url)

        }

        return binding.root
    }

}