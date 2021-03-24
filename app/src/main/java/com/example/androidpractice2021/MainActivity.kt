package com.example.androidpractice2021

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.androidpractice2021.router.AppRouter
import com.example.androidpractice2021.ui.home.DetailCharacterFragment

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
    }

//    override fun openUserDetails(userId: Int) {
//        navController.navigate(R.id.action_navigation_home_to_navigation_detail_character, DetailCharacterFragment.getBundle(userId))
//    }
}