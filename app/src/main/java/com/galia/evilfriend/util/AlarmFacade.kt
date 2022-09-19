package com.galia.evilfriend.util

import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import java.util.*

class AlarmFacade(val context: Context, val intent: Intent, val notificationManager: NotificationManager) {

    private val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as? AlarmManager

    fun cancel(requestId: Int) {
        val pendingIntent = PendingIntent.getBroadcast(context, requestId, intent, 0)
        alarmManager?.cancel(pendingIntent)
    }

    fun start(requestId: Int, text: String, hour: Int, minute: Int) {
        val calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
        }
        intent.apply {
            putExtra(TEXT_MESSAGE_BODY, text)
            putExtra(ID_MESSAGE_BODY, requestId)
        }
        val pendingIntent = PendingIntent.getBroadcast(context, requestId, intent, 0)
        alarmManager?.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, AlarmManager.INTERVAL_DAY, pendingIntent)
    }

    fun sendNotification(text: String, id: Int) {
        notificationManager.sendNotification(
            text,
            id,
            context
        )
    }
}