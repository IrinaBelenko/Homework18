package com.example.homework18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var textValue: TextView? = null
    var value: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textValue = findViewById(R.id.value)
        val plusButton: Button = findViewById(R.id.plusButton)
        val minusButton: Button = findViewById(R.id.minusButton)
        val savedData = MyApplication.getApp().getSavedData()
        value = savedData.toInt()
        textValue?.setText(savedData)

        plusButton.setOnClickListener {
            value += 1
            textValue?.text = value.toString()

        }

        minusButton.setOnClickListener {
            value -= 1
            textValue?.text = value.toString()

        }
    }

    override fun onPause() {
        super.onPause()
        MyApplication.getApp().saveData(textValue?.text.toString())
    }
}