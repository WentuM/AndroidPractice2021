package com.example.androidpractice2021.ui.main.home.profile.settings

import com.example.androidpractice2021.ui.main.ScreensMainActivity
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class SettingsPresenter(
    private val router: Router
) : MvpPresenter<SettingsView>() {

    fun onPrevClick() {
        router.backTo(ScreensMainActivity.ProfileFragmentScreen)
    }
}