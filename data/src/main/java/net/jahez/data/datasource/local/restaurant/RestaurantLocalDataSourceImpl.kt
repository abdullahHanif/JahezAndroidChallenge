package net.jahez.data.datasource.local.restaurant

import net.jahez.data.db.dao.RestaurantDao
import net.jahez.data.model.Restaurant
import javax.inject.Inject

class RestaurantLocalDataSourceImpl @Inject constructor(private val restaurantDao: RestaurantDao) :
    RestaurantLocalDataSource {

    override suspend fun getRestaurants(): List<Restaurant> = restaurantDao.getAll()

    override suspend fun saveAll(restaurants: List<Restaurant>) {
        restaurants.forEach {
            restaurantDao.insert(it)
        }
    }

    override suspend fun deleteAll() = restaurantDao.truncate()
}