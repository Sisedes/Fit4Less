package com.example.fit4lesfirebase

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import com.google.gson.GsonBuilder

import okhttp3.*

import java.io.IOException



class BmiCalculator : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_calculator)

        var turnWhatIam= bmiResultTurner();




        val bmiSendButton = findViewById<Button>(R.id.bmiCalculate);
        bmiSendButton.setOnClickListener{
            var kiloText=findViewById<EditText>(R.id.kilo).text.toString()
            var boyText=findViewById<EditText>(R.id.boy).text.toString();

//BMI Calculator API////////////////////////////////////////////////////////////////////////
            var URL="https://body-mass-index-bmi-calculator.p.rapidapi.com/metric?weight=$kiloText&height=$boyText";
            if(URL.isNotEmpty()){
                val client = OkHttpClient();
                val request = Request.Builder()
                    .url(URL)
                    .get()
                    .addHeader("X-RapidAPI-Key", "3c8ffef3c7msh3923e83affe5a67p1ac88ejsnd64d5df0ee9d")
                    .addHeader("X-RapidAPI-Host", "body-mass-index-bmi-calculator.p.rapidapi.com")
                    .build();
                client.newCall(request).enqueue(object: Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        e.printStackTrace()
                    }

                    override fun onResponse(call: Call, response: Response) {
                        response.use {
                            if (!response.isSuccessful){
                                val x:String="something didn't load"

                            }
                            else{
                                var body=response.body?.string();
                                val gson=GsonBuilder().create();
                                val gettbmi=gson.fromJson(body,getBmi::class.java)
                                var x= gettbmi.bmi;
                                var y=turnWhatIam.bmiResultTurn(x)




                                findViewById<TextView>(R.id.bmiSUM).text="Body Mass Index:"+x.toString()
                                findViewById<TextView>(R.id.bmiResult).text=y.toString();
                            }

                        }
                    }
                })


            }
///////////////////////////////////////////////////////////////////////////////////////////////////
        }


    }

    //Api'nin veri çekmesi için gerekli class sistemi
    class getBmi(val bmi:Double,val height:Double, val weight:Int,val weightCategory:String);
}