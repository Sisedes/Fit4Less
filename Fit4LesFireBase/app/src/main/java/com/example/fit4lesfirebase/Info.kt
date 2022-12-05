package com.example.fit4lesfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView

class Info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        val gitHubText=findViewById<TextView>(R.id.textView3);
        val linkedinText=findViewById<TextView>(R.id.textView5);
        gitHubText.movementMethod = LinkMovementMethod.getInstance();
        linkedinText.movementMethod = LinkMovementMethod.getInstance();
    }
}