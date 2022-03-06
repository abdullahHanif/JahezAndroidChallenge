package net.jahez.jahezchallenge.home.view

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import net.jahez.jahezchallenge.R
import net.jahez.jahezchallenge.home.vm.HomeActivityViewModel
import net.jahez.jahezchallenge.utils.EventObserver
import java.util.*

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private val activityViewModel: HomeActivityViewModel by viewModels<HomeActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragNavHost) as NavHostFragment
        val navController = navHostFragment.navController

        activityViewModel.switchLangauge.observe(this, EventObserver{
            val lang = if (it.second == HomeActivityViewModel.Language.ENGLISH ) "en" else "ar"

            val locale = Locale(lang)
            Locale.setDefault(locale)
            val config = Configuration()
            config.locale = locale

            baseContext.resources.updateConfiguration(
                config,
                baseContext.resources.displayMetrics
            )

            val newActivity = Intent(this, HomeActivity::class.java)
            finish()
            startActivity(newActivity)
        } )
    }
}