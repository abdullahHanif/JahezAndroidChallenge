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
    var shouldChangeLanguage : Pair<Boolean, Language> = Pair(false, Language.ENGLISH)
    val sorting = MutableLiveData<Event<SortBy>>(Event(SortBy.DISTANCE))
    val switchLangauge = MutableLiveData<Event<Pair<Boolean, Language>>>()

    val shouldRefreshList = MutableLiveData<Event<Boolean>>(Event(false))

    fun applyChanges(){

        if(shouldChangeLanguage.first){
            switchLangauge.value = Event(shouldChangeLanguage)
        }

        shouldRefreshList.value = Event(true)
    }

    fun changeLanguage(language: Language) {
        shouldChangeLanguage = Pair(true, language)
    }

}