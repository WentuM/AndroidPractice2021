package com.example.androidpractice2021.ui.main.home

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution

@AddToEndSingle
interface HomeView: MvpView {

    @OneExecution
    fun navigateToProfile()
}