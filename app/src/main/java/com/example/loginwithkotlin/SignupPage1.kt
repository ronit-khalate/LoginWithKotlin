package com.example.loginwithkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SignupPage1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity_1)


        // click listener of NEXT button
        findViewById<Button>(R.id.next).setOnClickListener()
        {
            val name :String =findViewById<EditText>(R.id.editText3).text.toString()
            val userName:String=findViewById<EditText>(R.id.editText4).text.toString()

            if(!name.isEmpty() && userName.length>5) {

                startActivity(Intent(this,SignupPage2::class.java))
            }
            else if(name.isEmpty())
            {
                /*
                * tell user to enter text
                * */
                Toast.makeText(this,"please enter name",Toast.LENGTH_SHORT).show()
            }
            else if(userName.length<5)
            {
                /*
               * tell user to enter text
               * */
                Toast.makeText(this,"User name must be greater than 5",Toast.LENGTH_SHORT).show()// .show() must call
                // to show toast
            }

        }

        // click Listener of add image

        findViewById<ImageView>(R.id.add_picture).setOnClickListener()
        {
            startActivity(Intent(this,SignupPage2::class.java))
        }
        findViewById<ImageView>(R.id.add_image_link_icon).setOnClickListener()
        {
            startActivity(Intent(this,SignupPage2::class.java))
        }
    }
}