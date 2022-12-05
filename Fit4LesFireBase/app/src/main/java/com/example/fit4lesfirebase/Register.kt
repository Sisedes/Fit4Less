package com.example.fit4lesfirebase

import android.content.Intent
import android.media.MediaPlayer.OnCompletionListener
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)




        val registerBtn = findViewById<Button>(R.id.registerButton)

        registerBtn.setOnClickListener {
            var eMail = findViewById<EditText>(R.id.mailText).text.toString()
            var password = findViewById<EditText>(R.id.textPassword).text.toString()
            var rePassword = findViewById<EditText>(R.id.textPasswordAgain).text.toString()
            val goLogin=Intent(this,Login::class.java);

            if(eMail.isNotEmpty()&&password.isNotEmpty()&&rePassword.isNotEmpty()){
                if(password.equals(rePassword)){

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(eMail,password)
                        .addOnCompleteListener(object:OnCompleteListener<AuthResult>{
                            override fun onComplete(p0: Task<AuthResult>) {
                                if(p0.isSuccessful){
                                    Toast.makeText(this@Register,"Succesfully Registered",Toast.LENGTH_SHORT).show()
                                    startActivity(goLogin)
                                }
                                else{
                                    Toast.makeText(this@Register,"Something went wrong! "+p0.exception?.message,Toast.LENGTH_SHORT).show()
                                }
                            }
                        })
                }else{
                    Toast.makeText(this,"Passwords don't match!!",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Fill the blanks!!",Toast.LENGTH_SHORT).show()
            }
        }
    }

}