package com.example.yemektarifleri

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.yemek_bilgiler.*

class yemekbilgileriactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.yemek_bilgiler)

        val Kaydet = findViewById<Button>(R.id.Tıkla);

        Tıkla.setOnClickListener {

            Toast.makeText(this,"Kaydedildi",Toast.LENGTH_SHORT).show()
        }






    }
}