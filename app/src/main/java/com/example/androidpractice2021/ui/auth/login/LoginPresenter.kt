package com.example.androidpractice2021.ui.auth.login

import com.example.androidpractice2021.ui.auth.ScreensAuthActivity
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class LoginPresenter(
    private val router: Router
): MvpPresenter<LoginView>() {

    fun onRegistrationClick() {
        router.navigateTo(ScreensAuthActivity.RegistrationFragmentScreen)
    }

    fun onMainActivityClick() {
        router.navigateTo(ScreensAuthActivity.SplashActivityScreen)
    }
}