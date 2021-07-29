package com.marcocastope.scoringteam

import android.app.Application
import com.marcocastope.scoringteam.data.networking.RemoteApi
import com.marcocastope.scoringteam.data.networking.buildApiService

class App : Application() {

    companion object {
        private lateinit var instance: App
        private val apiService by lazy { buildApiService() }
        val remoteApi by lazy { RemoteApi(apiService) }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}