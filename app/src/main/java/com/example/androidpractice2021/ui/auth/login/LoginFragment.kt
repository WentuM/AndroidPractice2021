package com.example.androidpractice2021.ui.auth.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.androidpractice2021.ApplicationDelegate
import com.example.androidpractice2021.R
import kotlinx.android.synthetic.main.fragment_login.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class LoginFragment: MvpAppCompatFragment(R.layout.fragment_login), LoginView {

    @InjectPresenter
    lateinit var presenter: LoginPresenter

    @ProvidePresenter
    fun providePresenter(): LoginPresenter = initPresenter()

    private fun initPresenter() = LoginPresenter(
        router = ApplicationDelegate.INSTANCE.router
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        txv_redirect_registration.setOnClickListener { presenter.onRegistrationClick() }
        btn_main_activity.setOnClickListener { presenter.onMainActivityClick() }
    }

    override fun navigateToMainActivity() {
        TODO("Not yet implemented")
    }

    override fun navigateToRegistration() {
        TODO("Not yet implemented")
    }
}