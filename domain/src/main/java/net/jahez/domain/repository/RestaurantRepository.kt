package net.jahez.domain.repository

import net.jahez.domain.entity.RestaurantUIModel
import kotlinx.coroutines.flow.Flow

interface RestaurantRepository {
    suspend fun fetchRestaurants(): Flow<RestaurantUIModel>

    suspend fun deleteSavedRestaurant()
}