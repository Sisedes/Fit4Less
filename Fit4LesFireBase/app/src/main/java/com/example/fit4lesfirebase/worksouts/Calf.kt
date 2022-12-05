package com.example.fit4lesfirebase.worksouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.fit4lesfirebase.R

class Calf : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calf)

        val barbellcalfButton=findViewById<Button>(R.id.barbellCalfRaise);
        barbellcalfButton.setOnClickListener {

            setContentView(R.layout.barbell_calf)

        }
        val barbellButton=findViewById<Button>(R.id.toeRaise);
        barbellButton.setOnClickListener {
            setContentView(R.layout.toe_raise)

        }
        val oneLegButton=findViewById<Button>(R.id.oneLegRaise);
        oneLegButton.setOnClickListener {
            setContentView(R.layout.one_leg_raise)

        }
        val calfJumpButton=findViewById<Button>(R.id.calfJump);
        calfJumpButton.setOnClickListener {
            setContentView(R.layout.calf_jump)

        }
    }
}