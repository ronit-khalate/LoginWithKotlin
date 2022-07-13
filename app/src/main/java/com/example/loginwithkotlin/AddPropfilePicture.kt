package com.example.loginwithkotlin

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class AddPropfilePicture:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_profile_picture)

        findViewById<Button>(R.id.getPicture).setOnClickListener()
        {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type="image/*"

            startActivityForResult(intent,100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

            val viewPicture=findViewById<ImageView>(R.id.profile_pictute_imageview)

            viewPicture.setImageURI(data?.data)

    }

}

