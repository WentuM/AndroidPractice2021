package com.example.androidpractice2021.ui.main.home.profile.settings

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution

@AddToEndSingle
interface SettingsView: MvpView {

    @OneExecution
    fun navigateToProfile()
}