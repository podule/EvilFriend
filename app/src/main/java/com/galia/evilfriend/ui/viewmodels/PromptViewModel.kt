package com.galia.evilfriend.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.galia.evilfriend.data.repository.PromptDatabaseRepository
import com.galia.evilfriend.di.PromptFragmentScope
import javax.inject.Inject

@PromptFragmentScope
class PromptViewModel @Inject constructor(
    private val repository: PromptDatabaseRepository
): ViewModel() {

    val promptListLiveData = repository.getAllPrompts()

    val promptWithLevelListLiveData = repository.getAllPromptAndNotification()
}