package com.example.androidpractice2021.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class DetailCharacterFragment: Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        private const val KEY_USER_ID = "userId"

        fun getBundle(userId: Int): Bundle {
            return Bundle().apply {
                putInt(KEY_USER_ID, userId)
            }
        }
    }

}