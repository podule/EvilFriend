package com.galia.evilfriend.ui.viewmodels

import androidx.lifecycle.*
import com.galia.evilfriend.data.model.PromptAndNotification
import com.galia.evilfriend.data.repository.PromptRepository
import com.galia.evilfriend.domain.FormatNotificationUseCase
import com.galia.evilfriend.domain.PromptLevelUseCase
import javax.inject.Inject

class PromptListViewModel @Inject constructor(
    private val repository: PromptRepository,
    val formatNotificationUseCase: FormatNotificationUseCase,
    val promptLevelUseCase: PromptLevelUseCase
): ViewModel() {

    val promptWithLevelListLiveData: LiveData<List<PromptAndNotification>> by lazy {
        repository.getAllPromptAndNotification().asLiveData()
    }
}