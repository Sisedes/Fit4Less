package com.example.fit4lesfirebase

import android.annotation.SuppressLint
import android.app.*
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build

import android.os.Bundle
import android.widget.Button

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class WaterReminder : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water_reminder)

        createNotificationChannel();

        val cancelButton=findViewById<Button>(R.id.cancel);
        cancelButton.setOnClickListener {
            Toast.makeText(this,"Remainder Cancelled!",Toast.LENGTH_SHORT).show()
            val intent=Intent(this,ReminderBroadcast::class.java);
            val pendingIntent=PendingIntent.getBroadcast(this,0,intent,0);
            val alarmManager: AlarmManager = getSystemService(ALARM_SERVICE) as AlarmManager;
            alarmManager.cancel(pendingIntent)
        }

        val buttonTestReminder=findViewById<Button>(R.id.bt30min);
        buttonTestReminder.setOnClickListener {
            Toast.makeText(this,"Remainder Set!",Toast.LENGTH_SHORT).show();
            val intent=Intent(this,ReminderBroadcast::class.java);
            val pendingIntent=PendingIntent.getBroadcast(this,0,intent,0);
            val alarmManager: AlarmManager = getSystemService(ALARM_SERVICE) as AlarmManager;

            var timeAtButtonClick:Long=System.currentTimeMillis();
            var Minutes:Long=1000*1800; //bir saniye=1000 millis ; 30 dakika= 1800 saniye

            alarmManager.set(AlarmManager.RTC_WAKEUP,timeAtButtonClick+Minutes,pendingIntent);

            var cal = Calendar.getInstance();

            cal.setTimeInMillis(System.currentTimeMillis())
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),Minutes,pendingIntent);




        }

        val buttonOneHour=findViewById<Button>(R.id.btnOneHour);
        buttonOneHour.setOnClickListener {
            Toast.makeText(this,"Remainder Set!",Toast.LENGTH_SHORT).show();
            val intent=Intent(this,ReminderBroadcast::class.java);
            val pendingIntent=PendingIntent.getBroadcast(this,0,intent,0);
            val alarmManager: AlarmManager = getSystemService(ALARM_SERVICE) as AlarmManager;

            var timeAtButtonClick:Long=System.currentTimeMillis();
            var Minutes:Long=1000*3600; //bir saniye=1000 millis ; 1 saat= 3600 saniye

            alarmManager.set(AlarmManager.RTC_WAKEUP,timeAtButtonClick+Minutes,pendingIntent);
            var cal = Calendar.getInstance();

            cal.setTimeInMillis(System.currentTimeMillis())
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),Minutes,pendingIntent);




        }

        val button2Hour=findViewById<Button>(R.id.btn2Hour)
        button2Hour.setOnClickListener {
            Toast.makeText(this,"Remainder Set!",Toast.LENGTH_SHORT).show();
            val intent=Intent(this,ReminderBroadcast::class.java);
            val pendingIntent=PendingIntent.getBroadcast(this,0,intent,0);
            val alarmManager: AlarmManager = getSystemService(ALARM_SERVICE) as AlarmManager;

            var timeAtButtonClick:Long=System.currentTimeMillis();
            var Minutes:Long=1000*7200; //bir saniye=1000 millis ; 2 saat= 7200 saniye

            alarmManager.set(AlarmManager.RTC_WAKEUP,timeAtButtonClick+Minutes,pendingIntent);

            var calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis())
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),Minutes,pendingIntent);





        }
    }
    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val name:CharSequence="WaterRemindChannel";
            var description:String="Channel for WaterReminder"
            var importance:Int=NotificationManager.IMPORTANCE_DEFAULT;
            val channel=NotificationChannel("notifyWaterReminder",name, importance)
            channel.description = description;

            val notificationManager=getSystemService(NotificationManager::class.java);
            notificationManager.createNotificationChannel(channel);
        }
    }
}