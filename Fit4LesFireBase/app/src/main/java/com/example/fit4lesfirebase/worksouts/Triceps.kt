package com.example.fit4lesfirebase.worksouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.fit4lesfirebase.R

class Triceps : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_triceps)

        val pushDownButton = findViewById<Button>(R.id.pushDown);
        pushDownButton.setOnClickListener {

            setContentView(R.layout.push_down)

        }
        val tricepsExtensionButton = findViewById<Button>(R.id.tricepsExtension);
        tricepsExtensionButton.setOnClickListener {
            setContentView(R.layout.triceps_extension)

        }
        val dipsButton = findViewById<Button>(R.id.dips);
        dipsButton.setOnClickListener {
            setContentView(R.layout.dips)

        }
        val tricepsKickButton = findViewById<Button>(R.id.tricepsKickback);
        tricepsKickButton.setOnClickListener {
            setContentView(R.layout.triceps_kick)
        }
    }
}