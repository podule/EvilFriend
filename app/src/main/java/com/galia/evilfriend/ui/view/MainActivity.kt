package com.galia.evilfriend.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.galia.evilfriend.App
import com.galia.evilfriend.R
import com.galia.evilfriend.di.ActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: ActivityComponent
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent = (applicationContext as App).appComponent.activityComponent()

        setContentView(R.layout.activity_main)
    }
}