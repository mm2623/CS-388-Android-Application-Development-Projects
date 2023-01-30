package com.example.tapcounterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.countertextview)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
//            Toast.makeText(this, "Clicked Button", Toast.LENGTH_SHORT).show()
            counter++
            textView.text = counter.toString()
        }
    }
}