package com.example.androidpractice2021.ui.main.home.profile

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution

@AddToEndSingle
interface ProfileView: MvpView {

    @OneExecution
    fun navigateToSettings()

    @OneExecution
    fun navigateToHome()
}