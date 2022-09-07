package com.galia.evilfriend.di

import com.galia.evilfriend.data.repository.PromptDatabaseRepository
import com.galia.evilfriend.data.repository.PromptRepository
import dagger.Binds
import dagger.Module

@Module
interface ActivityModule {

    @Binds
    fun repository(repository: PromptDatabaseRepository): PromptRepository
}