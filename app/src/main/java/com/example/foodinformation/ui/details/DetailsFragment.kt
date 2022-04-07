package com.example.foodinformation.ui.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodinformation.R
import com.example.foodinformation.databinding.DetailsFragmentBinding

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = DetailsFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val selectedFood = DetailsFragmentArgs.fromBundle(requireArguments()).selectedFood
        val viewModelFactory = DetailsViewModelFactory(selectedFood)
        val viewModel = ViewModelProvider(
            this, viewModelFactory).get(DetailsViewModel::class.java)
        binding.viewModel = viewModel
        return binding.root
    }


}