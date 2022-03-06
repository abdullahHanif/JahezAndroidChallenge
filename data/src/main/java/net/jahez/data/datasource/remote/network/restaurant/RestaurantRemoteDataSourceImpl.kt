package net.jahez.data.datasource.remote.network.restaurant

import net.jahez.data.datasource.remote.api.RestaurantService
import net.jahez.data.model.Restaurant
import javax.inject.Inject

class RestaurantRemoteDataSourceImpl @Inject constructor(private val service: RestaurantService) :
    RestaurantRemoteDataSource {

    @Throws(Exception::class)
    override suspend fun getRestaurants(): List<Restaurant> {
        return try {
            service.getRestaurants()
        } catch (exception: Exception) {
            throw exception
        }
    }
}

