package net.jahez.jahezchallenge.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.jahez.domain.repository.RestaurantRepository
import net.jahez.domain.usecase.FetchRestaurantCase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {

    @Singleton
    @Provides
    fun provideFetchRestaurantCase(restaurantRepository: RestaurantRepository) =
        FetchRestaurantCase(restaurantRepository)
}