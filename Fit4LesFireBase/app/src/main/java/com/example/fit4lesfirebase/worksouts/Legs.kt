package com.example.fit4lesfirebase.worksouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.fit4lesfirebase.R

class Legs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_legs)

        val squadButton = findViewById<Button>(R.id.squad);
        squadButton.setOnClickListener {

            setContentView(R.layout.squad)

        }
        val legExtentionsButton = findViewById<Button>(R.id.legExtentions);
        legExtentionsButton.setOnClickListener {
            setContentView(R.layout.leg_extentions)

        }
        val legPressButton = findViewById<Button>(R.id.legPress);
        legPressButton.setOnClickListener {
            setContentView(R.layout.leg_press)

        }
        val dumbbellLungesButton = findViewById<Button>(R.id.dumbbellLunges);
        dumbbellLungesButton.setOnClickListener {
            setContentView(R.layout.dumbbell_lunges)
        }
    }
}