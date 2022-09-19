package com.galia.evilfriend.ui.viewmodels

import androidx.lifecycle.*
import com.galia.evilfriend.data.model.PromptAndNotification
import com.galia.evilfriend.data.repository.PromptRepository
import com.galia.evilfriend.domain.FormatNotificationUseCase
import com.galia.evilfriend.domain.PromptLevelUseCase
import com.galia.evilfriend.util.PromptFilterType
import kotlinx.coroutines.launch
import javax.inject.Inject

class PromptListViewModel @Inject constructor(
    private val repository: PromptRepository,
    val formatNotificationUseCase: FormatNotificationUseCase,
    val promptLevelUseCase: PromptLevelUseCase
) : ViewModel() {

    private val _promptWithLevelListLiveData: LiveData<List<PromptAndNotification>> by lazy {
        repository.getAllPromptAndNotification().asLiveData()
    }

    private val _filter: MutableLiveData<PromptFilterType> =
        Transformations.switchMap(_promptWithLevelListLiveData) {
            MutableLiveData(PromptFilterType.ACTIVE_PROMPT)
        } as MutableLiveData<PromptFilterType>

    val promptWithLevelListLiveData: LiveData<List<PromptAndNotification>> =
        Transformations.switchMap(_filter) {
            load()
        }

    fun setFilter(type: PromptFilterType) {
        _filter.value = type
    }

    private fun load(): LiveData<List<PromptAndNotification>> {
        val result = MutableLiveData<List<PromptAndNotification>>()
        viewModelScope.launch {
            result.value = filterPrompts(_promptWithLevelListLiveData.value, _filter.value!!)
        }

        return result
    }


    private fun filterPrompts(
        prompts: List<PromptAndNotification>?,
        filterType: PromptFilterType
    ): List<PromptAndNotification> {
        val result = mutableListOf<PromptAndNotification>()
        prompts?.let {
            for (item in prompts) {
                when (filterType) {
                    PromptFilterType.ACTIVE_PROMPT -> if (item.prompt.isActive) {
                        result.add(item)
                    }
                    PromptFilterType.ARCHIVE_PROMPT -> if (!item.prompt.isActive) {
                        result.add(item)
                    }
                }
            }
        }

        return result
    }

}