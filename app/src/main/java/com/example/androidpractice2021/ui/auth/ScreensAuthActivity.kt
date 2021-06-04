package com.example.androidpractice2021.ui.auth

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.example.androidpractice2021.R
import com.example.androidpractice2021.ui.SplashActivity
import com.example.androidpractice2021.ui.main.MainActivity
import ru.terrakok.cicerone.android.support.SupportAppScreen

object ScreensAuthActivity {


    object SplashActivityScreen: SupportAppScreen() {
        override fun getActivityIntent(context: Context?): Intent {
            return Intent(context, SplashActivity::class.java)
        }
    }

    object MainActivityScreen: SupportAppScreen() {
        override fun getActivityIntent(context: Context?): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    object RegistrationFragmentScreen: SupportAppScreen() {
        override fun getFragment(): Fragment {
            return Fragment(R.layout.fragment_registration)
        }
    }

    object LoginFragmentScreen: SupportAppScreen() {
        override fun getFragment(): Fragment {
            return Fragment(R.layout.fragment_login)
        }
    }
}