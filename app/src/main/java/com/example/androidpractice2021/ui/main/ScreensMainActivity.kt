package com.example.androidpractice2021.ui.main

import androidx.fragment.app.Fragment
import com.example.androidpractice2021.R
import ru.terrakok.cicerone.android.support.SupportAppScreen

object ScreensMainActivity {

    object HomeFragmentScreen: SupportAppScreen() {
        override fun getFragment(): Fragment {
            return Fragment(R.layout.fragment_home)
        }
    }

    object ProfileFragmentScreen: SupportAppScreen() {
        override fun getFragment(): Fragment {
            return Fragment(R.layout.fragment_profile)
        }
    }

    object SettingsFragmentScreen: SupportAppScreen() {
        override fun getFragment(): Fragment {
            return Fragment(R.layout.fragment_settings)
        }
    }
}