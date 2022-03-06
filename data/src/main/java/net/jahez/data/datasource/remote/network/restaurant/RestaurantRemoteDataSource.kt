package net.jahez.data.datasource.remote.network.restaurant

import net.jahez.data.model.Restaurant

interface RestaurantRemoteDataSource {
    @Throws(Exception :: class)
    suspend fun getRestaurants(): List<Restaurant>
}