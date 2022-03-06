package net.jahez.restaurant

import com.google.common.truth.Truth
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import net.jahez.domain.repository.RestaurantRepository
import net.jahez.domain.usecase.FetchRestaurantCase
import net.jahez.domain.usecase.SortBy
import org.junit.Before
import org.junit.Test

class FetchRestaurantUseCaseTest {

    private val mockRestaurantRepository = mock<RestaurantRepository>()

    private lateinit var fetchRestaurantCase: FetchRestaurantCase

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        fetchRestaurantCase = FetchRestaurantCase(mockRestaurantRepository)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check if When Sorting is DISTANCE, the UI Model item must have it sorted`() {
        TestCoroutineDispatcher().runBlockingTest {
            //ARRANGE
            whenever(mockRestaurantRepository.fetchRestaurants())
                .thenReturn(flow { FakeDataProvider.getRestaurant() })

            //ACT
            val result = fetchRestaurantCase.invoke(SortBy.DISTANCE)


            result.collectLatest { response ->
                Truth.assertThat(response.list[0].id).isEqualTo(3)
            }
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check if When Sorting is OFFERS, the UI Model item must have it sorted`() {
        TestCoroutineDispatcher().runBlockingTest {
            //ARRANGE
            whenever(mockRestaurantRepository.fetchRestaurants())
                .thenReturn(flow { FakeDataProvider.getRestaurant() })

            //ACT
            val result = fetchRestaurantCase.invoke(SortBy.OFFER)

            //ASSERT
            result.collectLatest { response ->
                Truth.assertThat(response.list[0].id).isEqualTo(1)
            }
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check if When Sorting is RATINGS, the UI Model item must have it sorted`() {
        TestCoroutineDispatcher().runBlockingTest {
            //ARRANGE
            whenever(mockRestaurantRepository.fetchRestaurants())
                .thenReturn(flow { FakeDataProvider.getRestaurant() })

            //ACT
            val result = fetchRestaurantCase.invoke(SortBy.RATING)

            //ASSERT
            result.collectLatest { response ->
                Truth.assertThat(response.list[0].id).isEqualTo(1)
            }
        }
    }

}