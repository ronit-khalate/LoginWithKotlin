package com.example.loginwithkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SignupPage1 : AppCompatActivity() {


    private val dataBaseLink ="https://kotlin-login-70273-default-rtdb.asia-southeast1.firebasedatabase.app/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity_1)


        // click listener of NEXT button
        findViewById<Button>(R.id.next).setOnClickListener()
        {

            val userName = findViewById<EditText>(R.id.userNameSignupEditText).text.toString().trim()
            if(isInfoEntered())
            {
                saveInfoToDatabase(getInfo(),userName)
            }

        }

        // click Listener of add image

        findViewById<ImageView>(R.id.add_picture).setOnClickListener()
        {
            startActivityForResult(Intent(this,AddPropfilePicture::class.java),101)
        }
        findViewById<ImageView>(R.id.add_image_link_icon).setOnClickListener()
        {
            startActivityForResult(Intent(this,AddPropfilePicture::class.java),101)
        }

        findViewById<TextView>(R.id.login).setOnClickListener()
        {
            startActivity(Intent(this,Login::class.java))
        }
    }

    // get info entered by user to save in database
    private fun getInfo(): UserInfo {


        val password = findViewById<EditText>(R.id.passwordSignupEditText).text.toString().trim()
        val name = findViewById<EditText>(R.id.nameSignupEditText).text.toString().trim()

        return UserInfo( password,name)

    }

    private fun saveInfoToDatabase(user:UserInfo,userName:String)
    {

        val rootRef = FirebaseDatabase.getInstance(dataBaseLink).reference

        rootRef.child("users").child("loginInfo").child(userName).setValue(user).addOnCompleteListener {
            Toast.makeText(this,"Sign up Successfully",Toast.LENGTH_SHORT).show()
            startSiguPage2()

        }


    }

    // check if user entered all the info or not

    fun isInfoEntered():Boolean
    {
        val password = findViewById<EditText>(R.id.passwordSignupEditText).text.toString()
        val name = findViewById<EditText>(R.id.nameSignupEditText).text.toString()
        val userName = findViewById<EditText>(R.id.userNameSignupEditText).text.toString()

        if(!password.isEmpty()&&!name.isEmpty()&&!userName.isEmpty())
        {
            return true
        }
        else
        {
            Toast.makeText(this,"Please enter all infromation",Toast.LENGTH_SHORT)
        }
        return false
    }
    private fun startSiguPage2 ()
    {
        startActivity(Intent(this,SignupPage2::class.java))
    }
}