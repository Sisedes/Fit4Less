package com.example.fit4lesfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.fit4lesfirebase.worksouts.*

class Workouts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workouts)

        val absButton=findViewById<ImageButton>(R.id.buttonAbs);
        absButton.setOnClickListener{ val intent=Intent(this, Abs::class.java);
            startActivity(intent)
        }
        val backButton=findViewById<ImageButton>(R.id.buttonBack);
        backButton.setOnClickListener { val intent=Intent(this, Back::class.java);
            startActivity(intent)}
        val bicepsButton=findViewById<ImageButton>(R.id.buttonBiceps);
        bicepsButton.setOnClickListener { val intent=Intent(this,Biceps::class.java);
            startActivity(intent)}
        val calfButton=findViewById<ImageButton>(R.id.buttonCalf);
        calfButton.setOnClickListener { val intent=Intent(this, Calf::class.java);
            startActivity(intent)}
        val chestButton=findViewById<ImageButton>(R.id.buttonChest);
        chestButton.setOnClickListener { val intent=Intent(this, Chest::class.java);
            startActivity(intent)}
        val forearmsButton=findViewById<ImageButton>(R.id.buttonForearms);
        forearmsButton.setOnClickListener { val intent=Intent(this, Forearms::class.java);
            startActivity(intent)}
        val legsButton=findViewById<ImageButton>(R.id.buttonLegs);
        legsButton.setOnClickListener { val intent=Intent(this, Legs::class.java);
            startActivity(intent)}
        val shoulderButton=findViewById<ImageButton>(R.id.buttonShoulders);
        shoulderButton.setOnClickListener { val intent=Intent(this, Shoulders::class.java);
            startActivity(intent)}
        val tricepsButton=findViewById<ImageButton>(R.id.buttonTriceps);
        tricepsButton.setOnClickListener { val intent=Intent(this, Triceps::class.java);
            startActivity(intent)}
    }
}