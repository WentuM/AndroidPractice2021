package com.example.androidpractice2021.ui.auth.registration

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution

@AddToEndSingle
interface RegistrationView: MvpView {

    @OneExecution
    fun navigateToMainActivity()

    @OneExecution
    fun navigateToLogin()
}