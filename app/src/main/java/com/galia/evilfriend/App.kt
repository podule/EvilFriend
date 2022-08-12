package com.galia.evilfriend

import android.app.Application
import com.galia.evilfriend.data.repository.PromptDatabaseRepository

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        PromptDatabaseRepository.initialize(this)
    }
}