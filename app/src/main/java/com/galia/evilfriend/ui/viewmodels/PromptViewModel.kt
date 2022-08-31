package com.galia.evilfriend.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.galia.evilfriend.data.model.PromptAndNotification
import com.galia.evilfriend.data.repository.PromptRepository
import com.galia.evilfriend.di.PromptFragmentScope
import com.galia.evilfriend.domain.FormatNotificationUseCase
import com.galia.evilfriend.domain.PromptLevelUseCase
import javax.inject.Inject

@PromptFragmentScope
class PromptViewModel @Inject constructor(
    private val repository: PromptRepository,
    val formatNotificationUseCase: FormatNotificationUseCase,
    val promptLevelUseCase: PromptLevelUseCase
): ViewModel() {

    val promptWithLevelListLiveData: LiveData<List<PromptAndNotification>> = repository.getAllPromptAndNotification().asLiveData()
}