package net.jahez.data.datasource.remote.api

import net.jahez.data.model.Restaurant
import retrofit2.http.GET

interface RestaurantService {
    @GET("restaurants.json")
    suspend fun getRestaurants(): List<Restaurant>
}