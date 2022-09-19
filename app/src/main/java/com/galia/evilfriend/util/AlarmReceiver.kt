package com.galia.evilfriend.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.galia.evilfriend.App
import javax.inject.Inject

const val TEXT_MESSAGE_BODY = "text_message_body"
const val ID_MESSAGE_BODY = "id_message_body"

class AlarmReceiver: BroadcastReceiver() {

    @Inject
    lateinit var alarmFacade: AlarmFacade

    override fun onReceive(context: Context, intent: Intent) {
        (context.applicationContext as App).appComponent.inject(this)
        alarmFacade.sendNotification(
            intent.getStringExtra(TEXT_MESSAGE_BODY)!!,
            intent.getIntExtra(ID_MESSAGE_BODY, 0),
        )
    }
}