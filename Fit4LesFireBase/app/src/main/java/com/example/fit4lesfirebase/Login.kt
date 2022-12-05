package com.example.fit4lesfirebase

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val registerButton=findViewById<Button>(R.id.registerBtnButLoginScreen);
        registerButton.setOnClickListener {
            val Intent = Intent(this, Register::class.java)
            startActivity(Intent)
        }

        val loginBtn=findViewById<Button>(R.id.loginButton);
        loginBtn.setOnClickListener {
            var email=findViewById<EditText>(R.id.loginEmail).text.toString();
            var passW=findViewById<EditText>(R.id.loginPassword).text.toString();
            val goMain=Intent(this@Login,MainActivity::class.java)

            if(email.isNotEmpty()&&passW.isNotEmpty()){

                FirebaseAuth.getInstance().signInWithEmailAndPassword(email,passW)
                    .addOnCompleteListener(object:OnCompleteListener<AuthResult>{
                        override fun onComplete(p0: Task<AuthResult>) {
                            if(p0.isSuccessful){
                                Toast.makeText(this@Login,"Login Succesfully: "+FirebaseAuth.getInstance().currentUser?.email,Toast.LENGTH_SHORT).show();
                                startActivity(goMain);
                            }
                            else{
                                Toast.makeText(this@Login,"Incorrect e-mail or password! "+p0.exception?.message,Toast.LENGTH_SHORT).show()
                            }
                        }
                    })
            }
            else{
                Toast.makeText(this,"Fill the blanks!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}