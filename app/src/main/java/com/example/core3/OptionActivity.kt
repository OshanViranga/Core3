package com.example.core3

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option)

        val sharedPref = this.getSharedPreferences("preferences", Context.MODE_PRIVATE)
        val name = sharedPref.getString("name","a")

        val saved = findViewById<TextView>(R.id.saved)
        saved.text = "The last country clicked was ${name}."
    }
}