package com.galia.evilfriend.domain

import com.galia.evilfriend.data.model.Notification
import javax.inject.Inject

class FormatNotificationUseCase @Inject constructor() {
    operator fun invoke(notification: Notification): String {
        return formatTime(notification.wakeHour, notification.wakeMinutes)
    }

    fun formatTime(hour: Int, minute: Int): String {
        return "${if (hour < 10) "0${hour}" else hour}:${if (minute < 10) "0${minute}" else minute}"
    }

}