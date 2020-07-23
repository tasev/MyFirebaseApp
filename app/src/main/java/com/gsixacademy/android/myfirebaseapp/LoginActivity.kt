package com.gsixacademy.android.myfirebaseapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        createNotificationChannel(getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
        button_login.setOnClickListener {
            //
        }

    }

    private fun createNotificationChannel(notificationManager: NotificationManager?) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "channel_notification"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("ch12", name, importance)
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            notificationManager?.createNotificationChannel(channel)
        }
    }

}