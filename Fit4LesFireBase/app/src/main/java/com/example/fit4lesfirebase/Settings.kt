package com.example.fit4lesfirebase

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase

class Settings : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation", "WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val goLogin= Intent(this,Login::class.java);


        val panelButton=findViewById<Button>(R.id.panel)
        panelButton.setOnClickListener {
            if(FirebaseAuth.getInstance().currentUser?.email.toString().equals("kaan44tor@gmail.com")||FirebaseAuth.getInstance().currentUser?.email.toString().equals("kaan41tor@gmail.com")){
                setContentView(R.layout.panel);
                val sendButton=findViewById<Button>(R.id.sendResPassButton)
                sendButton.setOnClickListener {
                var inputMail=findViewById<EditText>(R.id.sendMailPassRes).text.toString();
                FirebaseAuth.getInstance().sendPasswordResetEmail(inputMail)}


                val adminUserAdd = findViewById<Button>(R.id.adminUserAddBtn)

                adminUserAdd.setOnClickListener {
                    FirebaseAuth.getInstance().signOut();
                    var eMail = findViewById<EditText>(R.id.adminAddMail).text.toString()
                    var password = findViewById<EditText>(R.id.adminAddPass).text.toString()
                    val goLogin=Intent(this,Login::class.java);

                    if(eMail.isNotEmpty()&&password.isNotEmpty()){


                            FirebaseAuth.getInstance().createUserWithEmailAndPassword(eMail,password)
                                .addOnCompleteListener(object:OnCompleteListener<AuthResult>{
                                    override fun onComplete(p0: Task<AuthResult>) {
                                        if(p0.isSuccessful){
                                            Toast.makeText(this@Settings,"User Succesfully Added",Toast.LENGTH_SHORT).show()
                                            finish()
                                            startActivity(goLogin)
                                        }
                                        else{
                                            Toast.makeText(this@Settings,"Something went wrong! "+p0.exception?.message,Toast.LENGTH_SHORT).show()
                                        }
                                    }
                                })

                    }else{
                        Toast.makeText(this,"Fill the blanks!!",Toast.LENGTH_SHORT).show()
                    }
                }

            }else{
                Toast.makeText(this@Settings,"You don't have permission",Toast.LENGTH_SHORT).show()
            }
        }




        val delAccButton=findViewById<Button>(R.id.delAcc);
        delAccButton.setOnClickListener{

            val dialogBuilder = AlertDialog.Builder(this)

            dialogBuilder.setMessage("Are you sure you want to delete your account?")
                .setCancelable(true)
                .setPositiveButton("Delete", DialogInterface.OnClickListener {
                        dialog, id ->
                    FirebaseAuth.getInstance().currentUser?.delete()?.addOnCompleteListener {

                        val intent = Intent(this,Login::class.java)
                        FirebaseAuth.getInstance().signOut()
                        Toast.makeText(this, "Your account has been deleted", Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                        finish()
                    }
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                })

            val alert = dialogBuilder.create()
            alert.setTitle("Delete")
            alert.show()

        }


        val changeMailButton=findViewById<Button>(R.id.changeMail);
        changeMailButton.setOnClickListener {
            val newMaill=findViewById<EditText>(R.id.newMail).text.toString();
            val oldMaill=findViewById<EditText>(R.id.oldMail).text.toString();
            val currentMaillPassword=findViewById<EditText>(R.id.currentMailPass);
            var passCurrent=currentMaillPassword.text.toString();

            if(newMaill.isNotEmpty()&&oldMaill.isNotEmpty()){
                var userMail=FirebaseAuth.getInstance().currentUser?.email.toString()
                if(userMail==oldMaill) {
                    FirebaseAuth.getInstance().currentUser?.updateEmail(newMaill);
                    FirebaseAuth.getInstance().signOut();
                    Toast.makeText(this@Settings,"Succesfully Changed", Toast.LENGTH_SHORT).show()
                    finish()
                    startActivity(goLogin)
                }

                else{Toast.makeText(this@Settings,"Incorrect e-mail! ",Toast.LENGTH_SHORT).show()
                }
            }
            else{Toast.makeText(this@Settings,"Fill the blanks! ",Toast.LENGTH_SHORT).show()

            }

        }

        val changePasswordButton=findViewById<Button>(R.id.changePassword);
            changePasswordButton.setOnClickListener {
                val oldPassword=findViewById<EditText>(R.id.oldPassword).text.toString();
                val newPassword=findViewById<EditText>(R.id.newPassword).text.toString();
                val newPasswordAgain=findViewById<EditText>(R.id.newPasswordAgain).text.toString();
                if (oldPassword.isNotEmpty()&&newPassword.isNotEmpty()&&newPasswordAgain.isNotEmpty())
                {
                    if(newPassword.equals(newPasswordAgain)){
                        var user=FirebaseAuth.getInstance().currentUser;
                        user?.updatePassword(newPassword.toString());
                        FirebaseAuth.getInstance().signOut();
                        startActivity(goLogin)
                        Toast.makeText(this@Settings,"Succesfully Changed", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(this@Settings,"Passwords don't match! ",Toast.LENGTH_SHORT).show()
                    }
                }else
                {
                    Toast.makeText(this@Settings,"Fill the blanks! ",Toast.LENGTH_SHORT).show()
                }

            }
    }
}