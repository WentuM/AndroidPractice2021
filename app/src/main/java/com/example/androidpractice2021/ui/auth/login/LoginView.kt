package com.example.androidpractice2021.ui.auth.login

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution

@AddToEndSingle
interface LoginView: MvpView {

    @OneExecution
    fun navigateToMainActivity()

    @OneExecution
    fun navigateToRegistration()
}
