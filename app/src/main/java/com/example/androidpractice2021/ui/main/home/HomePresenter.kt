package com.example.androidpractice2021.ui.main.home

import com.example.androidpractice2021.ui.main.ScreensMainActivity
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class HomePresenter(
    private val router: Router
): MvpPresenter<HomeView>() {

    fun onNextClick() {
        router.navigateTo(ScreensMainActivity.ProfileFragmentScreen)
    }
}