package com.example.hackdroid_imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        btnVoltar1.setOnClickListener {

            startActivity(Intent(this@ResultadoActivity,MainActivity::class.java))
        }
    }
}
