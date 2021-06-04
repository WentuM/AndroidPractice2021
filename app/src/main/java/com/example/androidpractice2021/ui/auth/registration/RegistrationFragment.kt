package com.example.androidpractice2021.ui.auth.registration

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
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
        btn_main_activity.setOnClickListener { onSplashActivityClick() }
    }

    private fun onSplashActivityClick() {
        val action = RegistrationFragmentDirections.actionRegistrationFragmentToSplashActivity(
            edtx_email.text.toString(),
            edtx_password.text.toString()
        )
        findNavController().navigate(action)
    }

    override fun navigateToMainActivity() {
        TODO("Not yet implemented")
    }

    override fun navigateToLogin() {
        TODO("Not yet implemented")
    }

}