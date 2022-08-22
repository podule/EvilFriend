package com.galia.evilfriend.di

import com.galia.evilfriend.ui.view.PromptListFragment
import dagger.Subcomponent

@Subcomponent
@PromptFragmentScope
interface PromptFragmentComponent {

    fun inject(promptListFragment: PromptListFragment)
}