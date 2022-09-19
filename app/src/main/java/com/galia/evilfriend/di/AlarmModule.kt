package com.galia.evilfriend.di

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.core.content.ContextCompat
import com.galia.evilfriend.R
import com.galia.evilfriend.util.AlarmFacade
import com.galia.evilfriend.util.AlarmReceiver
import dagger.Module
import dagger.Provides

@Module
interface AlarmModule {
    companion object {
        @Provides
        @AppScope
        fun getAlarmFacade(context: Context): AlarmFacade {
            val intent = Intent(context, AlarmReceiver::class.java)
            val notificationManager = ContextCompat.getSystemService(
                context,
                NotificationManager::class.java
            ) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notificationChannel = NotificationChannel(
                    context.getString(R.string.notification_channel_id),
                    context.getString(R.string.notification_channel),
                    NotificationManager.IMPORTANCE_HIGH
                )
                    .apply {
                        setShowBadge(false)
                    }

                notificationChannel.enableLights(true)
                notificationChannel.lightColor = Color.RED
                notificationChannel.enableVibration(true)
                notificationChannel.description = context.getString(R.string.notification_channel_description)

                notificationManager.createNotificationChannel(notificationChannel)

            }
            return AlarmFacade(context, intent, notificationManager)
        }

    }
}