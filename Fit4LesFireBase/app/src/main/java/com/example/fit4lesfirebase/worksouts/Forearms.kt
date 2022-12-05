package com.example.fit4lesfirebase.worksouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.fit4lesfirebase.R

class Forearms : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forearms)

        val wristCurlButton = findViewById<Button>(R.id.wristCurl);
        wristCurlButton.setOnClickListener {

            setContentView(R.layout.wrist_curl)

        }
        val wristBarButton = findViewById<Button>(R.id.wristBar);
        wristBarButton.setOnClickListener {
            setContentView(R.layout.wrist_bar)

        }
        val dumbbellWristButton = findViewById<Button>(R.id.dumbbellWrist);
        dumbbellWristButton.setOnClickListener {
            setContentView(R.layout.dumbbell_wrist)

        }
        val standingWristButton = findViewById<Button>(R.id.standingWrist);
        standingWristButton.setOnClickListener {
            setContentView(R.layout.standing_wrist)
        }
    }
}