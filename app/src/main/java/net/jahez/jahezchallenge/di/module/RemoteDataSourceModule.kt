package net.jahez.jahezchallenge.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.jahez.data.datasource.remote.network.restaurant.RestaurantRemoteDataSource
import net.jahez.data.datasource.remote.network.restaurant.RestaurantRemoteDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    @Singleton
    abstract fun provideRemoteDataSource(remoteDataSource: RestaurantRemoteDataSourceImpl): RestaurantRemoteDataSource

}