package com.example.foodinformation.ui.overview

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.foodinformation.R
import com.example.foodinformation.databinding.OverviewFragmentBinding

class OverviewFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val application = requireNotNull(activity).application
        val binding = OverviewFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val viewModelFactory = OverviewViewModelFactory(application)
        val viewModel= ViewModelProvider(
            this, viewModelFactory).get(OverviewViewModel::class.java)

        binding.viewModel = viewModel
        binding.listFood.adapter = FoodListAdapter(FoodListAdapter.OnClickListener {
            viewModel.displayFoodDetails(it)
        })

        viewModel.navigateToSelectedFoodDetails.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                findNavController().navigate(OverviewFragmentDirections.actionOverviewFragmentToDetailsFragment(it))
                viewModel.displayFoodDetailsComplete()
            }
        })
        return binding.root
    }


}