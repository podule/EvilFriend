package com.galia.evilfriend.di

import com.galia.evilfriend.ui.view.MainActivity
import dagger.Subcomponent

@Subcomponent
@ActivityScope
interface ActivityComponent {

    fun promptFragmentComponent(): PromptFragmentComponent
}
