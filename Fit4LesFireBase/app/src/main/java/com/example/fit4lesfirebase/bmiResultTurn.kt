package com.example.fit4lesfirebase

open class bmiResultTurner {
    open  fun bmiResultTurn(a:Double): String? {
        var A:String?=null
        if(a<18.5&&a<0){
            A= "Your Underweight";
        }
        else if(18.5<=a&& a<25){
            A= "Your Weight is Normal";
        }
        else if(a<=25&&a<30){
            A="Your Overweight"
        }
        else if(a>30){
            A="Your Obese"
        }
        else if(18>a&&a>0){
            A="Your kid or Your Skeleton Human"
        }

        return A   }
}