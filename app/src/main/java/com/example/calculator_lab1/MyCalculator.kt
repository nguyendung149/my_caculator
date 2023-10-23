package com.example.calculator_lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import nguyenvanquan7826.com.Balan

class MyCalculator : AppCompatActivity() {
    lateinit var tvEquation: TextView
    lateinit var tvResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.caculator_layout)
        tvEquation = findViewById(R.id.tv_equation)
        tvResult = findViewById(R.id.tv_result)
    }

    fun onDigit(view: View) {
        if (tvEquation.text.toString().trim() == "|") {
            tvEquation.text = ""
        }
        tvEquation.text = "${tvEquation.text}${(view as Button).text.toString()}"

    }

    fun onClear(view: View) {
        tvResult.text = "0"
        tvEquation.text = "|"
    }

   fun removeZero(result: String): String {
        var resultRemoveZero: String? = null
        if (result.endsWith(".0")) {
            resultRemoveZero = result.substring(0, result.indexOf("."))
        } else {
            resultRemoveZero = result
        }
        return resultRemoveZero
    }


    fun onEqual(view: View) {

        val mathEquation: String = tvEquation.text.toString()
        if (mathEquation.isNotEmpty()) {
            val balan: Balan = Balan()
            val result: String = balan.valueMath(mathEquation).toString()
            val error = balan.error
            if (error != null) {
                Toast.makeText(this@MyCalculator, error, Toast.LENGTH_LONG).show()
            } else {
                tvResult.text = removeZero(result)
            }
        }
    }
    fun onAns(view: View){
        tvEquation.text = tvResult.text
    }
    fun onDel(view: View){
        tvEquation.text = tvEquation.text.toString().substring(0,tvEquation.text.toString().length-1)
    }
}