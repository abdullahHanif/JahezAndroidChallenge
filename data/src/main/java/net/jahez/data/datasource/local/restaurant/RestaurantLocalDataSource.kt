package net.jahez.data.datasource.local.restaurant

import net.jahez.data.model.Restaurant


interface RestaurantLocalDataSource {
    suspend fun getRestaurants(): List<Restaurant>

    suspend fun saveAll(restaurants: List<Restaurant>)

    suspend fun deleteAll()
}