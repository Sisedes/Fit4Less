package com.example.fit4lesfirebase.worksouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.fit4lesfirebase.R

class Back : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_back)

        val deadliftButton=findViewById<Button>(R.id.deadlift);
        deadliftButton.setOnClickListener {

            setContentView(R.layout.deadlift)

        }
        val latPullButton=findViewById<Button>(R.id.latPull);
        latPullButton.setOnClickListener {
            setContentView(R.layout.lat_pull)

        }
        val twistinHipsButton=findViewById<Button>(R.id.chin);
        twistinHipsButton.setOnClickListener {
            setContentView(R.layout.chin_ups)

        }
        val dumbbellButton=findViewById<Button>(R.id.oneArm);
        dumbbellButton.setOnClickListener {
            setContentView(R.layout.one_arm)

        }
    }
}