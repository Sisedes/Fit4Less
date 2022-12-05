package com.example.fit4lesfirebase.worksouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.fit4lesfirebase.R

class Chest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chest)

        val benchPressButton=findViewById<Button>(R.id.benchPress);
        benchPressButton.setOnClickListener {

            setContentView(R.layout.bench_press)

        }
        val inclinePressButton=findViewById<Button>(R.id.inclinePress);
        inclinePressButton.setOnClickListener {
            setContentView(R.layout.incline_bench_press)

        }
        val pushUpButton=findViewById<Button>(R.id.pushUp);
        pushUpButton.setOnClickListener {
            setContentView(R.layout.push_up)

        }
        val inclinePushButton=findViewById<Button>(R.id.inclininePushUp);
        inclinePushButton.setOnClickListener {
            setContentView(R.layout.incline_push_up)

        }
    }
}