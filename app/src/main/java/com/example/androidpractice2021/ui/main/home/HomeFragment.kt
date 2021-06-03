package com.example.androidpractice2021.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidpractice2021.ApplicationDelegate
import com.example.androidpractice2021.R
import com.example.androidpractice2021.ui.main.home.profile.settings.SettingsPresenter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_login.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class HomeFragment : MvpAppCompatFragment(R.layout.fragment_home), HomeView {

    @InjectPresenter
    lateinit var presenter: HomePresenter

    @ProvidePresenter
    fun providePresenter(): HomePresenter = initPresenter()

    private fun initPresenter() = HomePresenter(
        router = ApplicationDelegate.INSTANCE.router
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        btn_next.setOnClickListener {
            presenter.onNextClick()
        }
    }

    override fun navigateToProfile() {
        TODO("Not yet implemented")
    }
}