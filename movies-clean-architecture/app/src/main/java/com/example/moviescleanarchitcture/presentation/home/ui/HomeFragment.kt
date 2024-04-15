package com.example.moviescleanarchitcture.presentation.home.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.moviescleanarchitcture.R
import com.example.moviescleanarchitcture.databinding.FragmentHomeBinding
import com.example.moviescleanarchitcture.presentation.home.viewmodel.HomeNavState
import com.example.moviescleanarchitcture.presentation.home.viewmodel.HomeViewModel


class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        val binding: FragmentHomeBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_home,
                container,
                false
            )

        binding.viewmodel = homeViewModel
        binding.lifecycleOwner = this



        homeViewModel.navState.observe(viewLifecycleOwner) {
            it.getWhenNotDone()?.let {

                    state ->
                if (state == HomeNavState.MOVIES) {
                    findNavController().navigate(R.id.action_homeFragment_to_moviesFragment2)

                } else {
                    findNavController().navigate(R.id.action_homeFragment_to_artistFragment2)

                }
            }

        }
        return binding.root

    }

}