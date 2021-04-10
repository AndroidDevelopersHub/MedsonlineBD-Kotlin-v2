package com.user.medsonlinebd

import android.app.Application

class MedsonlineBD : Application() {

    companion object {
        lateinit var instance: MedsonlineBD
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}