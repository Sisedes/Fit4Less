package com.example.fit4lesfirebase.worksouts

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.fit4lesfirebase.R

class Biceps : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biceps)

        val curlButton=findViewById<Button>(R.id.curls);
        curlButton.setOnClickListener {

            setContentView(R.layout.curls)

        }
        val barbellButton=findViewById<Button>(R.id.barbellCurl);
        barbellButton.setOnClickListener {
            setContentView(R.layout.barbell)

        }
        val reverseCurlButton=findViewById<Button>(R.id.reverseCurl);
        reverseCurlButton.setOnClickListener {
            setContentView(R.layout.reverse_curl)

        }
        val hammerButton=findViewById<Button>(R.id.hammer);
        hammerButton.setOnClickListener {
            setContentView(R.layout.hammer)

        }
    }
}