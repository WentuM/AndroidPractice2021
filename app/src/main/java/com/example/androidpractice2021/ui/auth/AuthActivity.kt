package com.example.androidpractice2021.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.androidpractice2021.ApplicationDelegate
import com.example.androidpractice2021.R
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Screen
import ru.terrakok.cicerone.android.support.SupportAppScreen
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward

class AuthActivity : AppCompatActivity() {

    private var email: String = ""
    private var password: String = ""

    private lateinit var controller: NavController
    private val navigator = object : Navigator {

        override fun applyCommands(commands: Array<out Command>) {
            commands.forEach {
                when (it) {
                    is Forward -> onForward(it.screen)
                    else -> {
                    }
                }
            }
        }

        private fun onForward(screen: Screen) {

            when (screen as SupportAppScreen) {
                is ScreensAuthActivity.SplashActivityScreen -> {
                    screen.getActivityIntent(this@AuthActivity)?.let {
                        startActivity(it)
                    }
                }
                is ScreensAuthActivity.RegistrationFragmentScreen -> {
                    findNavController(R.id.auth_host_fragment).navigate(R.id.action_loginFragment_to_registrationFragment)
                }
                is ScreensAuthActivity.LoginFragmentScreen -> {
                    findNavController(R.id.auth_host_fragment).navigate(R.id.action_registrationFragment_to_loginFragment)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        controller =
            (supportFragmentManager.findFragmentById(R.id.auth_host_fragment) as NavHostFragment).navController
    }

    override fun onResume() {
        super.onResume()
        ApplicationDelegate.INSTANCE.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        ApplicationDelegate.INSTANCE.navigatorHolder.removeNavigator()
        super.onPause()
    }
}