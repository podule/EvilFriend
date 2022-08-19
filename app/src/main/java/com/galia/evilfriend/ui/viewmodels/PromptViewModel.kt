package com.galia.evilfriend.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.galia.evilfriend.data.repository.PromptDatabaseRepository
import com.galia.evilfriend.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class PromptViewModel @Inject constructor(
    private val repository: PromptDatabaseRepository
): ViewModel() {

    val promptListLiveData = repository.getAllPrompts()

    val promptWithLevelListLiveData = repository.getAllLevelAndPrompt()
}