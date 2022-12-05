package com.example.fit4lesfirebase.worksouts

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.fit4lesfirebase.R

class Abs : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abs)

        val sitUpsButton=findViewById<Button>(R.id.sitUps);
        sitUpsButton.setOnClickListener {

            setContentView(R.layout.sit_ups)

        }
        val crunchesButton=findViewById<Button>(R.id.crunches);
        crunchesButton.setOnClickListener {
            setContentView(R.layout.crunches)

        }
        val twistinHipsButton=findViewById<Button>(R.id.twistingHip);
        twistinHipsButton.setOnClickListener {
            setContentView(R.layout.twisting_hips)

             }
        val dumbbellButton=findViewById<Button>(R.id.dumbbellSide);
        dumbbellButton.setOnClickListener {
            setContentView(R.layout.dumbbell_side_bench)

        }
        }


    }
