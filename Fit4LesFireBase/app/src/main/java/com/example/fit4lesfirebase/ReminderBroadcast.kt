package com.example.fit4lesfirebase

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


class ReminderBroadcast:BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        val builder= NotificationCompat.Builder(context!!,"notifyWaterReminder")
            .setSmallIcon(R.drawable.bildirim)
            .setContentTitle("Fit4Less")
            .setContentText("It's time to drink water!!!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)


        val notificationManager= NotificationManagerCompat.from(context!!);
notificationManager.notify(200,builder.build());
    }

}