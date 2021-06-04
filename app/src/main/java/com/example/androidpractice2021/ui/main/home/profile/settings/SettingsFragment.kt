package com.example.androidpractice2021.ui.main.home.profile.settings

import android.os.Bundle
import android.view.View
import com.example.androidpractice2021.ApplicationDelegate
import com.example.androidpractice2021.R
import com.example.androidpractice2021.ui.auth.login.LoginPresenter
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_settings.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class SettingsFragment : MvpAppCompatFragment(R.layout.fragment_settings), SettingsView {

    @InjectPresenter
    lateinit var presenter: SettingsPresenter

    @ProvidePresenter
    fun providePresenter(): SettingsPresenter = initPresenter()

    private fun initPresenter() = SettingsPresenter(
        router = ApplicationDelegate.INSTANCE.router
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        btn_prev.setOnClickListener { presenter.onPrevClick() }
    }

    override fun navigateToProfile() {
        TODO("Not yet implemented")
    }
}