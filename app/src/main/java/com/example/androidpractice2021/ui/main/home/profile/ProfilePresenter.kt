package com.example.androidpractice2021.ui.main.home.profile

import com.example.androidpractice2021.ui.main.ScreensMainActivity
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class ProfilePresenter(
    private val router: Router
): MvpPresenter<ProfileView>() {

    fun onNextClick() {
        router.navigateTo(ScreensMainActivity.SettingsFragmentScreen)
    }

    fun onPrevClick() {
        router.navigateTo(ScreensMainActivity.HomeFragmentScreen)
    }
}