package com.example.loginwithkotlin

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.getValue

import com.google.firebase.FirebaseAppLifecycleListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Login :AppCompatActivity() {


    private val dataBaseLink =
        "https://kotlin-login-70273-default-rtdb.asia-southeast1.firebasedatabase.app/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        findViewById<Button>(R.id.loginbtn2).setOnClickListener()
        {

            val userNameEnterd =
                findViewById<EditText>(R.id.userNameEditText).text.toString().trim()
            val passwordEnterd =
                findViewById<EditText>(R.id.passwordLoginEditText).text.toString().trim()

            FirebaseDatabase.getInstance(dataBaseLink).reference.child("users")
                .child("loginInfo").child(userNameEnterd).get().addOnSuccessListener {


                    if (it.child("password").value.toString().trim() == passwordEnterd) {
                        startActivity(Intent(this, SignupPage1::class.java))
                    }
                    else
                    {

                       val toast= Toast.makeText(this,"Password is incorrect",Toast.LENGTH_SHORT)

                        toast.setGravity(10,Gravity.CENTER_HORIZONTAL,5)
                        toast.show()

                    }
                }.addOnFailureListener()
                {
                    Toast.makeText(this,"Username incorrect",Toast.LENGTH_SHORT)
                }

        }


    }

}

