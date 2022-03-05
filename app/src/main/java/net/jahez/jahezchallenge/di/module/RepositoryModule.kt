package net.jahez.jahezchallenge.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.jahez.data.repository.RestaurantRepositoryImpl
import net.jahez.domain.repository.RestaurantRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideRepository(repository: RestaurantRepositoryImpl): RestaurantRepository

}