package net.jahez.jahezchallenge.home.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import net.jahez.domain.entity.RestaurantUIModel
import net.jahez.domain.usecase.FetchRestaurantCase
import net.jahez.domain.usecase.SortBy
import net.jahez.jahezchallenge.utils.Event
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchRestaurantCase: FetchRestaurantCase
) : ViewModel() {

    private val _restaurants = MutableLiveData<Event<RestaurantUIModel>>()
    val restaurants: LiveData<Event<RestaurantUIModel>> get() = _restaurants

    var restaurantSorting  : SortBy = SortBy.RATING


    fun fetchRestaurant(restaurantSorting : SortBy) {
        viewModelScope.launch {
            fetchRestaurantCase.invoke(restaurantSorting).collectLatest { result ->
                _restaurants.value = Event(result)
            }
        }
    }
}