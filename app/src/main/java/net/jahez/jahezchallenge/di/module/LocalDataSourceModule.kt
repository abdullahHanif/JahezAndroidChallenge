package net.jahez.jahezchallenge.di.module


import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.jahez.data.datasource.local.restaurant.RestaurantLocalDataSource
import net.jahez.data.datasource.local.restaurant.RestaurantLocalDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun provideLocalDataSource(restaurantLocalDataSource: RestaurantLocalDataSourceImpl): RestaurantLocalDataSource

}