package com.example.mojaposlasticarnica

import android.app.Application
import com.example.mojaposlasticarnica.data.SharedPreferencesHelper

class MojaPoslasticarnicaApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val sharedPreferencesHelper = SharedPreferencesHelper(this)

        // Initialize the predefined data on the first launch
        sharedPreferencesHelper.initializeDataIfFirstLaunch()
    }
}
