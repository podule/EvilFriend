package com.galia.evilfriend.adapters

import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import androidx.appcompat.widget.SwitchCompat
import androidx.databinding.BindingAdapter
import com.galia.evilfriend.R
import com.galia.evilfriend.data.model.Prompt
import com.galia.evilfriend.domain.FormatNotificationUseCase

@BindingAdapter("app:validateTextLiveDataNotEmpty")
fun validateTextNotEmpty(view: EditText, validateTextLiveDataNotEmpty: String?) {

    if ((validateTextLiveDataNotEmpty == null) || validateTextLiveDataNotEmpty.isBlank()) {
        view.error = "Обязательно для заполнения"
    } else {
        view.error = null
    }
}

@BindingAdapter(value = ["app:entries", "app:level"], requireAll = true)
fun setEntries(view: AppCompatAutoCompleteTextView, entries: List<Any>, level: String?) {
    val adapter = ArrayAdapter(view.context, R.layout.level_list_item, entries)
    view.setAdapter(adapter)

    level?.let {
        view.setText(level, false)
    }
}

@BindingAdapter(value = ["app:formatterTime", "app:hour", "app:minute"], requireAll = true)
fun formatTime(view: Button, formatNotificationUseCase: FormatNotificationUseCase, hour: Int?, minute: Int?) {
    view.text = if (hour == null || minute == null) "--:--" else formatNotificationUseCase.formatTime(hour, minute)
}

@BindingAdapter("app:saveButton")
fun saveButton(view: Button, prompt: Prompt?) {
    view.text = if (prompt == null) "сохранить" else "обновить"
}

@BindingAdapter(value = ["app:title", "app:level"], requireAll = true)
fun validateSaveButton(view: Button,  title: String?, level: String?) {
    view.isEnabled = title != null && level != null && title.isBlank() == false && level.isBlank() == false
}

@BindingAdapter("app:isActive")
fun isActive(view: SwitchCompat, value: Boolean) {
    view.isChecked = value
}
