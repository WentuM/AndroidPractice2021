package com.example.androidpractice2021.ui.auth.registration

import android.os.Bundle
import android.view.View
import com.example.androidpractice2021.ApplicationDelegate
import com.example.androidpractice2021.R
import kotlinx.android.synthetic.main.fragment_registration.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class RegistrationFragment: MvpAppCompatFragment(R.layout.fragment_registration), RegistrationView {

    @InjectPresenter
    lateinit var presenter: RegistrationPresenter

    @ProvidePresenter
    fun providePresenter(): RegistrationPresenter = initPresenter()

    private fun initPresenter() = RegistrationPresenter(
        router = ApplicationDelegate.INSTANCE.router
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        txv_redirect_registration.setOnClickListener { presenter.onLoginClick() }
        btn_main_activity.setOnClickListener { presenter.onMainActivityClick() }
    }

    override fun navigateToMainActivity() {
        TODO("Not yet implemented")
    }

    override fun navigateToLogin() {
        TODO("Not yet implemented")
    }

}