package com.galia.evilfriend.di

import dagger.Subcomponent

@Subcomponent(modules = [ActivityModule::class])
@ActivityScope
interface ActivityComponent {

    fun promptFragmentComponent(): PromptFragmentComponent
}
