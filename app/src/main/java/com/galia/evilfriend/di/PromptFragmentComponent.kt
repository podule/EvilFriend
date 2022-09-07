package com.galia.evilfriend.di

import com.galia.evilfriend.ui.view.PromptFragment
import com.galia.evilfriend.ui.view.PromptListFragment
import dagger.Subcomponent

@Subcomponent(modules = [ViewModelModule::class])
@PromptFragmentScope
interface PromptFragmentComponent {

    fun inject(promptListFragment: PromptListFragment)
    fun inject(promptFragment: PromptFragment)
}