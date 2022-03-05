package net.jahez.domain.usecase

import net.jahez.domain.entity.RestaurantUIModel
import net.jahez.domain.repository.RestaurantRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchRestaurantCase @Inject constructor(private val restaurantRepository: RestaurantRepository) {

    suspend operator fun invoke(): Flow<RestaurantUIModel> =
        restaurantRepository.fetchRestaurants()
}