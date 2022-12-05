package com.example.fit4lesfirebase

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder


import okhttp3.*
import java.io.IOException


class NutVals : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nut_vals)



        val nutValsearchButton = findViewById<Button>(R.id.nutValSearch);
        nutValsearchButton.setOnClickListener {
            var inputFoodText=findViewById<EditText>(R.id.inputFood).text.toString()


//Calorie Ninja API ////////////////////////////////////////////////////////////////////////////
            var URL="https://calorieninjas.p.rapidapi.com/v1/nutrition?query=$inputFoodText";
            if(URL.isNotEmpty()){
                val client = OkHttpClient();
                val request = Request.Builder()
                    .url(URL)
                    .get()
                    .addHeader("X-RapidAPI-Key", "5c78828f61msh1d4e7c9299c6e3ep10613bjsne463577718fb")
                    .addHeader("X-RapidAPI-Host", "calorieninjas.p.rapidapi.com")
                    .build();
                client.newCall(request).enqueue(object:Callback{
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
                                val gson= GsonBuilder().create();
                                val getNuts=gson.fromJson(body,getItems::class.java)
                                var x=getNuts.items.get(0);
                                var nameofNuts=getNuts.items.get(0).name;


                                findViewById<TextView>(R.id.nutName).text="Name:"+nameofNuts;
                                findViewById<TextView>(R.id.totalNuts).text="Calories:"+x.calories+
                                        "\n\nProtein:"+x.protein_g+"\n\nFat:"+x.fat_total_g+"\n\nCarbohydrate:"+x.carbohydrates_total_g+
                                        "\n\nSugar:"+x.sugar_g+"\n\nFiber:"+x.fiber_g;
                                ;
                            }

                        }
                    }
                })

///////////////////////////////////////////////////////////////////////////////////////////////////////////
            }





        }

    }






    class getItems(val items:List<Items>)//alttaki sınıfın listesini içeriye alıyor
    class Items(val sugar_g:Double, val fiber_g:Double, val serving_size_g:Double,
                val sodium_mg:Double, val name:String,val potassium_mg:Double ,val fat_saturated_g:Double,
                val fat_total_g:Double,val calories:Double,val cholesterol_mg:Double,val protein_g:Double,val carbohydrates_total_g:Double);}
//Api'nin veri çekmesi için gerekli class sistemi
