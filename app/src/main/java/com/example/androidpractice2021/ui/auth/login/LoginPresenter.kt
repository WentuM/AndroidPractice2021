package com.example.androidpractice2021.ui.auth.login

import android.content.Context
import com.example.androidpractice2021.ui.auth.ScreensAuthActivity
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class LoginPresenter(
    private val router: Router,
    private val context: Context
): MvpPresenter<LoginView>() {

    fun onRegistrationClick() {
        router.navigateTo(ScreensAuthActivity.RegistrationFragmentScreen)
    }
}