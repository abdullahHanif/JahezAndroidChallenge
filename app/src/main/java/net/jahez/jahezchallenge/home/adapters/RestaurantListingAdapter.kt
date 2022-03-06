package net.jahez.jahezchallenge.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.jahez.domain.entity.RestaurantEntity
import net.jahez.domain.entity.RestaurantUIModel
import net.jahez.jahezchallenge.databinding.ListItemRestaurantBinding

class RestaurantListingAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var restaurants: RestaurantUIModel = RestaurantUIModel(arrayListOf())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RestaurantItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = restaurants.list[position]
        (holder as RestaurantItemViewHolder).bind(item)
    }

    override fun getItemCount(): Int {
        return restaurants.list.size
    }

    fun insertItems(newRestaurants: List<RestaurantEntity>) {
        if (restaurants.list.addAll(newRestaurants)) {
            notifyItemInserted(restaurants.list.size - 1)
        }
    }

    fun clear() {
        restaurants.list.clear()
        notifyDataSetChanged()
    }

    fun isNotEmpty(): Boolean {
        return restaurants.list.isNotEmpty()
    }

    class RestaurantItemViewHolder private constructor(
        val binding: ListItemRestaurantBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RestaurantEntity) {
            binding.model = item

            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): RestaurantItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemRestaurantBinding.inflate(layoutInflater, parent, false)
                binding.imageRestaurant.clipToOutline = true
                return RestaurantItemViewHolder(binding)
            }
        }
    }
}