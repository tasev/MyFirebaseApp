package com.gsixacademy.android.myfirebaseapp.service

import android.provider.Settings
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.gsixacademy.android.myfirebaseapp.R

class MyFirebaseService: FirebaseMessagingService() {

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        handleMessage(remoteMessage)
    }

    private fun handleMessage(remoteMessage: RemoteMessage?) {
        if(remoteMessage!=null && remoteMessage.notification!=null) {
             val notification = remoteMessage.notification

            val body = notification?.body
            val title = notification?.title

               sendMessage(body ?:"", title)
        }


    }

    private fun sendMessage(body: String, title: String?) {

        val notificationBuilder = NotificationCompat.Builder(this,"ch12")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setColor(this.getColor(R.color.colorPrimary))
            .setContentTitle(title)
            .setContentText(body)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
            .setStyle(NotificationCompat.BigTextStyle().bigText(body))
            .setAutoCancel(true)

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(123,notificationBuilder.build())

    }
}