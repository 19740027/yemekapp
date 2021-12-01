package com.example.yemektarifleri

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_yemek_details.*

class yemekDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yemek_details)
        button2.setOnClickListener({
            val gecişyap=Intent(applicationContext,yemekbilgileriactivity::class.java)
            startActivity(gecişyap)

        })




        var bundle = intent.extras
        imageView2.setImageResource(bundle!!.getInt("image"))
        textView2.text = bundle!!.getString("name")
        textView3.text = bundle!!.getString("des")


    }
}