package com.galia.evilfriend.di

import android.content.Context
import com.galia.evilfriend.util.AlarmReceiver
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DatabaseModule::class, AlarmModule::class])
@AppScope
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): AppComponent
    }

    fun activityComponent(): ActivityComponent
    fun inject(receiver: AlarmReceiver)
}