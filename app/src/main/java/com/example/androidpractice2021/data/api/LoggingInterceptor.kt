package com.example.androidpractice2021.data.api

import com.example.androidpractice2021.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class LoggingInterceptor(
    private val loggingInterceptor: HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(
            if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        )
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response =
        loggingInterceptor.intercept(chain)
}