package net.jahez.domain.usecase

import kotlinx.coroutines.flow.*
import net.jahez.domain.entity.RestaurantEntity
import net.jahez.domain.entity.RestaurantUIModel
import net.jahez.domain.repository.RestaurantRepository
import javax.inject.Inject

class FetchRestaurantCase @Inject constructor(private val restaurantRepository: RestaurantRepository) {

    suspend operator fun invoke(restaurantSorting: SortBy): Flow<RestaurantUIModel>  =

        restaurantRepository.fetchRestaurants().map { uiModel->

            val sorted  = uiModel.list

            when(restaurantSorting){
                SortBy.DISTANCE ->{
                     sorted.sortBy { it.distance }
                }
                SortBy.RATING ->{
                    sorted.sortBy { it.rating }
                }
                SortBy.OFFER ->{
                    sorted.sortBy { it.hasOffer }
                }
            }

            RestaurantUIModel(sorted)
        }
    }


enum class SortBy {
    DISTANCE, RATING,OFFER
}