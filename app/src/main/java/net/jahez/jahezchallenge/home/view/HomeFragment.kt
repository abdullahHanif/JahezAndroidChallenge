package net.jahez.jahezchallenge.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import net.jahez.domain.usecase.SortBy
import net.jahez.jahezchallenge.R
import net.jahez.jahezchallenge.databinding.FragmentHomeBinding
import net.jahez.jahezchallenge.home.adapters.RestaurantListingAdapter
import net.jahez.jahezchallenge.home.vm.HomeActivityViewModel
import net.jahez.jahezchallenge.home.vm.HomeViewModel
import net.jahez.jahezchallenge.home.vm.HomeViewModelNavigationState
import net.jahez.jahezchallenge.utils.EventObserver

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var adapter: RestaurantListingAdapter
    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()
    private val activityViewModel: HomeActivityViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            this.lifecycleOwner = this@HomeFragment.viewLifecycleOwner
            this.viewModel = this@HomeFragment.viewModel

        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
        initObservers()

        viewModel.fetchRestaurant(SortBy.DISTANCE)
    }

    private fun initObservers() {

        viewModel.navigation.observe(viewLifecycleOwner, EventObserver { state ->
            when (state) {
                HomeViewModelNavigationState.NavigateToSettingsDialog ->{
                    findNavController().navigate(R.id.settingsBottomSheet)
                }
                else ->{

                }

            }
        })

        viewModel.restaurants.observe(viewLifecycleOwner, EventObserver {
            adapter.insertItems(it.list)
        })

    }

    private fun setupAdapter() {
        adapter = RestaurantListingAdapter()
        binding.recyclerviewRestaurants.adapter = adapter
    }
}