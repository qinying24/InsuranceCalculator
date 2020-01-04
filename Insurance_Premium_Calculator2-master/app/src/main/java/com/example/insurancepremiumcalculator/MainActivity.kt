package com.example.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.ResultSet


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SubmitBtn.setOnClickListener(){
            val age = spinnerAge.getSelectedItem().toString()

            var<Int> Premium = 0
            when (age)
            {
                "Less than 17" -> {Premium = 60}
                "17 - 25" -> {Premium = 70}
                "26 - 30" -> {Premium = 90}
                "31 - 40" -> {Premium = 120}
                "41 - 55" -> {Premium = 150}
                "More than 55" -> {Premium = 150}
            }

            var<string> gender = ""
            if (Mbtn.isChecked())
            {
                gender = Mbtn.text.toString();
            }
            else if (Fbtn.isChecked())
            {
                gender = Fbtn.text.toString();
            }

            var<Int> Gender = 0
            if (gender == "Male")
            {
                when (age)
                {
                    "17 - 25" -> {Gender = 50}
                    "26 - 30" -> {Gender = 100}
                    "31 - 40" -> {Gender = 150}
                    "41 - 55" -> {Gender = 200}
                    "More than 55" -> {Gender = 200}
                }
            }

            var<boolean> smoker = false

            if (smokerCBox.isChecked)
            {
                smoker = true;
            }


            var<Int> Smoker = 0
            if (smoker == true)
            {
                when (age)
                {
                    "17 - 25" -> {Smoker = 100}
                    "26 - 30" -> {Smoker = 150}
                    "31 - 40" -> {Smoker = 200}
                    "41 - 55" -> {Smoker = 250}
                    "More than 55" -> {Smoker = 300}
                }
            }

            var<Int> total = Premium + Gender + Smoker
            payment.text = "Total Payment: RM" + Premium + "   "+ Gender + "   "+ Smoker+ "   " + total.toString()




        }

        ResetBtn.setOnClickListener(){

        }
    }
}
class GameViewModel : ViewModel() {
    init {
        Log.i("GameViewModel", "GameViewModel created!")
    }
}