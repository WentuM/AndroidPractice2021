package com.example.androidpractice2021.ui.main.home.profile

import android.os.Bundle
import android.view.View
import com.example.androidpractice2021.ApplicationDelegate
import com.example.androidpractice2021.R
import kotlinx.android.synthetic.main.fragment_profile.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class ProfileFragment: MvpAppCompatFragment(R.layout.fragment_profile), ProfileView {

    @InjectPresenter
    lateinit var presenter: ProfilePresenter

    @ProvidePresenter
    fun providePresenter(): ProfilePresenter = initPresenter()

    private fun initPresenter() = ProfilePresenter(
        router = ApplicationDelegate.INSTANCE.router
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        btn_prev.setOnClickListener { presenter.onPrevClick() }
        btn_next.setOnClickListener { presenter.onNextClick() }
    }

    override fun navigateToSettings() {
        TODO("Not yet implemented")
    }

    override fun navigateToHome() {
        TODO("Not yet implemented")
    }
}