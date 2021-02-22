package com.example.hackdroid_imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({

            //Criando a minha Intent

            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
            finish()
        },3000)
    }
}