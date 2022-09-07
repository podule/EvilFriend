package com.galia.evilfriend.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.galia.evilfriend.ui.viewmodels.PromptListViewModel
import com.galia.evilfriend.ui.viewmodels.PromptViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PromptViewModel::class)
    internal abstract fun promptViewModel(viewModel: PromptViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PromptListViewModel::class)
    internal abstract fun promptListViewModel(viewModel: PromptListViewModel): ViewModel

}