package com.example.contactsapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val name=intent.getStringExtra("name")
        val address=intent.getStringExtra("address")
        val image=intent.getStringExtra("image").toInt()
        val email=intent.getStringExtra("email")
        val phone=intent.getStringExtra("phone")


    }

}
