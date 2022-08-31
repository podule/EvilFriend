package com.galia.evilfriend.domain

import com.galia.evilfriend.data.model.Notification
import javax.inject.Inject

class FormatNotificationUseCase @Inject constructor() {
    operator fun invoke(notification: Notification): String {
        return "${if (notification.wakeHour < 10) "0${notification.wakeHour}" else notification.wakeHour}:${if (notification.wakeMinutes < 10) "0${notification.wakeMinutes}" else notification.wakeMinutes}"
    }
}