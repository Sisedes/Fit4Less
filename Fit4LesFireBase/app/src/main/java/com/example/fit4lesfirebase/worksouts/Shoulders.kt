package com.example.fit4lesfirebase.worksouts

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.fit4lesfirebase.R

class Shoulders : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoulders)

        val shoulderPressButton = findViewById<Button>(R.id.shoulderPress);
        shoulderPressButton.setOnClickListener {

            setContentView(R.layout.shoulder_press)

        }
        val frontRaiseButton = findViewById<Button>(R.id.frontRaises);
        frontRaiseButton.setOnClickListener {
            setContentView(R.layout.front_raise)

        }
        val frontBarButton = findViewById<Button>(R.id.frontBar);
        frontBarButton.setOnClickListener {
            setContentView(R.layout.front_bar)

        }
        val dumbbellScareButton = findViewById<Button>(R.id.dumbbellScarecrow);
        dumbbellScareButton.setOnClickListener {
            setContentView(R.layout.dumbbell_scarecrow)
        }
    }
}