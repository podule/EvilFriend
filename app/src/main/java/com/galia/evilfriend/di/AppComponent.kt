package com.galia.evilfriend.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DatabaseModule::class])
@AppScope
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): AppComponent
    }

    fun activityComponent(): ActivityComponent
}