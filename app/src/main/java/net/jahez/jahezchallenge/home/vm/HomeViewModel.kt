package net.jahez.jahezchallenge.home.vm

import android.util.Log
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

    private val _navigation = MutableLiveData<Event<HomeViewModelNavigationState>>()
    val navigation: LiveData<Event<HomeViewModelNavigationState>> = _navigation

    fun fetchRestaurant(restaurantSorting :SortBy ) {
        viewModelScope.launch {
            fetchRestaurantCase.invoke(restaurantSorting).collectLatest { result ->
                Log.d("HomeViewModel" ,"List Size :: "+result.list.size)
                _restaurants.value = Event(result)
            }.runCatching {
                Log.d("HomeViewModel" ,"List Error")
            }
        }
    }

    fun onMenuOptionsClicked(){
        _navigation.value = Event(HomeViewModelNavigationState.NavigateToSettingsDialog)
    }
}

sealed class HomeViewModelNavigationState {
    object NavigateToSettingsDialog : HomeViewModelNavigationState()
}