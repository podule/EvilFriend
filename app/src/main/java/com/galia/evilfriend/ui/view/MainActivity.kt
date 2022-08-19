package com.galia.evilfriend.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.galia.evilfriend.App
import com.galia.evilfriend.R
import com.galia.evilfriend.di.ActivityComponent
import com.galia.evilfriend.ui.viewmodels.PromptViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: ActivityComponent
        private set

    @Inject
    lateinit var viewModel: PromptViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent = (applicationContext as App).appComponent.activityComponent()
        activityComponent.inject(this)

        setContentView(R.layout.activity_main)
    }
}