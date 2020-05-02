package com.example.contactsapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView as RecyclerV

class MainActivity : AppCompatActivity() {

    lateinit var recyclerview: RecyclerV
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview=findViewById(R.id.recyclerView)

        //create list of names
        var names = arrayListOf<MyContacts>()
            .apply {
                add(MyContacts("silas","0712345678","kevin@gmail.com",R.mipmap.kefa,address = ""))
                add(MyContacts("kefa","0712345678","kefa@gmail.com",R.mipmap.kefa,address = ""))
                add(MyContacts("zack","0712345678","zack@gmail.com",R.mipmap.zack,address = ""))
                add(MyContacts("ayana","0712345678","ayana@gmail.com",R.mipmap.ayana,address = ""))

            }

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter =ContactsAdapter(this,names)

        requestPermission()
    }


    @RequiresApi(Build.VERSION_CODES.M)
    fun requestPermission(){
        if (checkSelfPermission(Manifest.permission.READ_CONTACTS)
            != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(
                arrayOf(Manifest.permission.READ_CONTACTS),
                100)

            return
        }
    }


}
