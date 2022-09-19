package com.galia.evilfriend.ui.viewmodels

import androidx.lifecycle.*
import com.galia.evilfriend.data.model.Level
import com.galia.evilfriend.data.model.Notification
import com.galia.evilfriend.data.model.Prompt
import com.galia.evilfriend.data.model.PromptAndNotification
import com.galia.evilfriend.data.repository.PromptRepository
import com.galia.evilfriend.domain.FormatNotificationUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class PromptViewModel @Inject constructor(
    private val repository: PromptRepository,
    val formatNotificationUseCase: FormatNotificationUseCase
) : ViewModel() {

    private var _promptId = MutableLiveData<Int?>()
    val promptId = _promptId
    val title = MutableLiveData<String>()
    val hour = MutableLiveData<Int>()
    val minute = MutableLiveData<Int>()

    private val _level = MutableLiveData<String>()
    val level: LiveData<String> = _level
    private val _isActive = MutableLiveData(true)
    val isActive: LiveData<Boolean> = _isActive

    private val _dataLoading = MutableLiveData<Boolean>()

    private var _promptAndNotification: LiveData<PromptAndNotification?> =
        Transformations.switchMap(_promptId) { promptId ->
            promptId?.let { repository.getPromptAndNotification(it).asLiveData() }
        }
    val promptAndNotification: LiveData<PromptAndNotification?> =
        Transformations.map(_promptAndNotification) {
            it?.let { onPromptLoaded(it) }
            it
        }

    private val _promptSaved = MutableLiveData<Boolean>()
    val promptSaved: LiveData<Boolean> = _promptSaved

    val levels: List<String> = Level.getLevels()

    fun init(promptId: Int?) {
        if (_dataLoading.value == true) {
            return
        }
        if (promptId == null) {
            return
        }
        _dataLoading.value = true
        _promptId.value = promptId
    }

    private fun onPromptLoaded(promptAndNotification: PromptAndNotification) {
        title.value = promptAndNotification.prompt.title
        _level.value = promptAndNotification.prompt.level
        hour.value = promptAndNotification.notification.wakeHour
        minute.value = promptAndNotification.notification.wakeMinutes
        _isActive.value = promptAndNotification.prompt.isActive
    }

    fun setLevelLiveData(value: CharSequence) {
        _level.value = value.toString()
    }

    fun setActiveLiveData(checked: Boolean) {
        _isActive.value = checked
    }

    fun savePrompt() {
        if (_promptId.value == null) {
            createPrompt()
        } else {
            updatePrompt()
        }
    }

    private fun createPrompt() = viewModelScope.launch {
        val prompt = Prompt(title = title.value!!, level = level.value!!)
        val notification = Notification(
            wakeHour = hour.value ?: 8,
            wakeMinutes = minute.value ?: 0,
            fidPrompt = prompt.id
        )
        viewModelScope.launch {
            promptId.value = repository.addPromptAndNotification(prompt, notification)
            _promptSaved.value = true
        }
    }

    private fun updatePrompt() {
        if (promptAndNotification.value == null) {
            throw RuntimeException("Обновление вызвано для нового напоминания")
        }
        promptAndNotification.value!!.let {
            it.prompt.title = title.value!!
            it.prompt.level = level.value!!
            it.notification.wakeHour = hour.value!!
            it.notification.wakeMinutes = minute.value!!
            it.prompt.isActive = isActive.value!!
        }
        viewModelScope.launch {
            repository.updatePromptAndNotification(
                promptAndNotification.value!!.prompt,
                promptAndNotification.value!!.notification
            )
            _promptSaved.value = true
        }
    }

}