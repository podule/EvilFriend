package com.galia.evilfriend

import android.app.Application
import com.galia.evilfriend.di.AppComponent
import com.galia.evilfriend.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory()
            .create(context = this)

    }
}