package net.jahez.data.repository

import net.jahez.data.datasource.local.restaurant.RestaurantLocalDataSource
import net.jahez.data.datasource.remote.network.restaurant.RestaurantRemoteDataSource
import net.jahez.data.mapper.RestaurantMapper
import net.jahez.domain.entity.RestaurantEntity
import net.jahez.domain.entity.RestaurantUIModel
import net.jahez.domain.repository.RestaurantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RestaurantRepositoryImpl @Inject constructor(
    private val localSource: RestaurantLocalDataSource,
    private val remoteDataSource: RestaurantRemoteDataSource
) : RestaurantRepository {

    @Throws(Exception::class)
    override suspend fun fetchRestaurants(): Flow<RestaurantUIModel> = flow {
        //fetch it, map it and release it to Domain with flow
        try {
            val data = remoteDataSource.getRestaurants()
            localSource.deleteAll()
            localSource.saveAll(data.list)

            val lst = ArrayList<RestaurantEntity>()
            //mapping it into domain type pojo convention and emit
            localSource.getRestaurants().forEach {
                lst.add(RestaurantMapper.fromDataToDomainType(it))
            }

            val response = RestaurantUIModel(lst)
            emit(response)
        } catch (exception: Exception) {
            throw exception
        }
    }


    override suspend fun deleteSavedRestaurant() {
        localSource.deleteAll()
    }
}