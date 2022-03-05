package net.jahez.jahezchallenge

import android.app.Application
import android.net.ConnectivityManager
import dagger.hilt.android.HiltAndroidApp
import net.jahez.jahezchallenge.utils.NetworkUtility
import javax.inject.Inject

@HiltAndroidApp
class AppClass : Application() {

    @Inject
    lateinit var connectivityManager: ConnectivityManager

    override fun onCreate() {
        super.onCreate()

        NetworkUtility.initialize(connectivityManager)

    }
}

