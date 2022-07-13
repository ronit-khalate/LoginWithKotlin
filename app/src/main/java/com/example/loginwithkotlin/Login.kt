package com.example.loginwithkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Login :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        findViewById<Button>(R.id.loginbtn2).setOnClickListener()
        {


        }

        findViewById<TextView>(R.id.signup).setOnClickListener()
        {

            startActivity(Intent(this,SignupPage1::class.java))
        }
    }
}