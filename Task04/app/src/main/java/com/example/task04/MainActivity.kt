package com.example.task04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonOK = findViewById<Button>(R.id.btnOK)
        buttonOK.setOnClickListener {
            Toast.makeText(
                applicationContext,
                getString(R.string.btnClickMessage),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
