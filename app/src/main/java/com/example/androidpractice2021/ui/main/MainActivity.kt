package com.example.androidpractice2021.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.androidpractice2021.ApplicationDelegate
import com.example.androidpractice2021.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Screen
import ru.terrakok.cicerone.android.support.SupportAppScreen
import ru.terrakok.cicerone.commands.BackTo
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward

class MainActivity : AppCompatActivity() {

    private lateinit var controller: NavController

    private val navigator = object : Navigator {

        override fun applyCommands(commands: Array<out Command>) {
            commands.forEach {
                when (it) {
                    is Forward -> onForward(it.screen)
                    is BackTo -> onBack(it.screen)
                    else -> {
                    }
                }
            }
        }

        private fun onForward(screen: Screen) {

            when (screen as SupportAppScreen) {
                is ScreensMainActivity.ProfileFragmentScreen -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.action_navigation_home_to_navigation_profile)
                }
                is ScreensMainActivity.HomeFragmentScreen -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.action_navigation_profile_to_navigation_home)
                }
                is ScreensMainActivity.SettingsFragmentScreen -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.action_navigation_profile_to_navigation_settings)
                }
            }
        }

        private fun onBack(screen: Screen) {

            when (screen as SupportAppScreen) {
                is ScreensMainActivity.ProfileFragmentScreen -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.action_navigation_settings_to_navigation_profile)
                }
                is ScreensMainActivity.HomeFragmentScreen -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.action_navigation_profile_to_navigation_home)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        controller =
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController

        nav_view.setupWithNavController(controller)
    }

    override fun onResume() {
        super.onResume()
        ApplicationDelegate.INSTANCE.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        ApplicationDelegate.INSTANCE.navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onSupportNavigateUp(): Boolean = controller.navigateUp()
}