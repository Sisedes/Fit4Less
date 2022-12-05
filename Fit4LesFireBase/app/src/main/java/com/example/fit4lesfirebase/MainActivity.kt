package com.example.fit4lesfirebase

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//butonları sabitlere atıyoruz////////
        val workOutButton = findViewById<Button>(R.id.workouts);
        val nutvalButton = findViewById<Button>(R.id.nutVals);
        val personalTrainingButton = findViewById<Button>(R.id.settings);
        val waterReminderButton = findViewById<Button>(R.id.waterReminder);
        val bmiCalculatorButton = findViewById<Button>(R.id.bmiCalculator);
        val infoButton = findViewById<Button>(R.id.info);


        workOutButton.setOnClickListener {
            val Intent = Intent(this, Workouts::class.java);
            startActivity(Intent);
        } //Workout butonunun basılma aktivitesi
        nutvalButton.setOnClickListener {
            val Intent = Intent(this, NutVals::class.java)
            startActivity(Intent)
        }//nutritional values butonunun basılma aktivitesi
        personalTrainingButton.setOnClickListener {
            val Intent = Intent(this, Settings::class.java)
            startActivity(Intent)
        }//personalTraining butonunun basılma aktivitesi
        waterReminderButton.setOnClickListener {
            val Intent = Intent(this, WaterReminder::class.java)
            startActivity(Intent)
        }//waterReminder butonunun basılma aktivitesi
        infoButton.setOnClickListener {
            val Intent = Intent(this, Info::class.java)
            startActivity(Intent)
        }//info butonunun basılma aktivitesi
        bmiCalculatorButton.setOnClickListener {
            val Intent = Intent(this, BmiCalculator::class.java)
            startActivity(Intent)
        }




    }


}