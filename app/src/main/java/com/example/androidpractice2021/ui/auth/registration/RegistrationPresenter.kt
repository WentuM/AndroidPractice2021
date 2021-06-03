package com.example.androidpractice2021.ui.auth.registration

import com.example.androidpractice2021.ui.auth.ScreensAuthActivity
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router


class RegistrationPresenter(
    private val router: Router
): MvpPresenter<RegistrationView>() {

    fun onLoginClick() {
        router.navigateTo(ScreensAuthActivity.LoginFragmentScreen)
    }

    fun onMainActivityClick() {
        router.navigateTo(ScreensAuthActivity.SplashActivityScreen)
    }
}