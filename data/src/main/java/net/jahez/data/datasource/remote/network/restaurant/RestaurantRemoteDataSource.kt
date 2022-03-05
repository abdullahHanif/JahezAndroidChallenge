package net.jahez.data.datasource.remote.network.restaurant

import net.jahez.data.model.RestaurantResponse

interface RestaurantRemoteDataSource {
    @Throws(Exception :: class)
    suspend fun getRestaurants(): RestaurantResponse
}