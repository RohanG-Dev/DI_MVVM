package com.example.mydaggerapp

import android.app.Application
import com.example.mydaggerapp.di.ApplicationComponent
import com.example.mydaggerapp.di.DaggerApplicationComponent

class FakerApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent =  DaggerApplicationComponent.builder().build()
    }
}