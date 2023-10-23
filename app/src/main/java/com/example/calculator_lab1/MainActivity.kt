package com.example.calculator_lab1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import nguyenvanquan7826.com.Balan

class MainActivity : AppCompatActivity() {
    lateinit var btnStart: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_calculator)
        var intent: Intent = Intent(this@MainActivity, MyCalculator::class.java)
        btnStart = findViewById(R.id.btn_start)
        btnStart.setOnClickListener {
            startActivity(intent)
            finish()
        }

    }
}