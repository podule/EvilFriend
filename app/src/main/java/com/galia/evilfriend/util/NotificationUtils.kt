package com.galia.evilfriend.util

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.galia.evilfriend.R

fun NotificationManager.sendNotification(messageBody: String, id: Int, applicationContext: Context) {

    val builder = NotificationCompat.Builder(
        applicationContext,
        applicationContext.getString(R.string.notification_channel_id)
    )
        .setSmallIcon(R.drawable.ic_notification)
        .setContentTitle(applicationContext.getString(R.string.notification_title))
        .setContentText(messageBody)
        .setAutoCancel(true)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
    notify(id, builder.build())
}

fun NotificationManager.cancelNotification(id: Int) {
    cancel(id)
}
