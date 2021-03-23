package com.example.androidpractice2020.router

import android.content.Context

class ResourceManagerImpl(
    val context: Context
): ResourceManager {

    override fun getString(id: Int): String {
        return context.getString(id)
    }
}