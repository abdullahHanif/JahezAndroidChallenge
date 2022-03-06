package net.jahez.jahezchallenge.home.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import net.jahez.domain.usecase.SortBy
import net.jahez.jahezchallenge.utils.Event
import javax.inject.Inject

@HiltViewModel
class HomeActivityViewModel @Inject constructor() : ViewModel() {
    enum class Language {
        ENGLISH, ARABIC
    }
    val language = MutableLiveData<Event<Language>>(Event(Language.ENGLISH))
    val sorting = MutableLiveData<Event<SortBy>>(Event(SortBy.DISTANCE))

    val shouldRefreshList = MutableLiveData<Event<Boolean>>(Event(false))

    fun applyChanges(){
        shouldRefreshList.value = Event(true)
    }

}