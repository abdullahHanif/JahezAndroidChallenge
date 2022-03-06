package net.jahez.jahezchallenge.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.jahez.domain.entity.RestaurantEntity
import net.jahez.jahezchallenge.databinding.FragmentHomeBinding
import net.jahez.jahezchallenge.home.adapters.RestaurantListingAdapter
import net.jahez.jahezchallenge.home.vm.HomeViewModel

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var adapter: RestaurantListingAdapter
    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()

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
    }

    private fun initObservers() {
        adapter.insertItems(
            listOf(
                RestaurantEntity(
                    17,
                    "Enjoy fast delivery from Jahez. Order now, or schedule your order any time you want",
                    4.290354402958331,
                    true,
                    "05:00 AM - 04:59 AM",
                    "https://jahez-other-oniiphi8.s3.eu-central-1.amazonaws.com/17.jpg",

                    "Burger Square",
                    "9 Ø±ÙŠØ§Ù„",
                    8.0
                ), RestaurantEntity(
                    18,
                    "Enjoy fast delivery from Jahez. Order now, or schedule your order any time you want",
                    4.290354402958331,
                    true,
                    "05:00 AM - 04:59 AM",
                    "https://jahez-other-oniiphi8.s3.eu-central-1.amazonaws.com/17.jpg",

                    "Burger Square",
                    "9 Ø±ÙŠØ§Ù„",
                    8.0
                ), RestaurantEntity(
                    19,
                    "Enjoy fast delivery from Jahez. Order now, or schedule your order any time you want",
                    4.290354402958331,
                    true,
                    "05:00 AM - 04:59 AM",
                    "https://jahez-other-oniiphi8.s3.eu-central-1.amazonaws.com/17.jpg",

                    "Burger Square",
                    "9 Ø±ÙŠØ§Ù„",
                    8.0
                )

            )
        )
    }

    private fun setupAdapter() {
        adapter = RestaurantListingAdapter()
        binding.recyclerviewRestaurants.adapter = adapter
    }
}