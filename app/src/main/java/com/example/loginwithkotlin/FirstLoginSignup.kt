package com.example.loginwithkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FirstLoginSignup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_and_singup)

        // GO TO LOGIN PAGE WHEN CLICK
        findViewById<Button>(R.id.loginbtn1).setOnClickListener()
        {
            startActivity(Intent(this,Login::class.java))        }

        // GO TO SIGNUP PAGE WHNE CLICK
        findViewById<TextView>(R.id.signup).setOnClickListener()
        {
            startActivity(Intent(this,SignupPage1::class.java))        }


    }




}